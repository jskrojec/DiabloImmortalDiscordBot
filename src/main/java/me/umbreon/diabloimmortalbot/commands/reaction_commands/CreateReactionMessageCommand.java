package me.umbreon.diabloimmortalbot.commands.reaction_commands;

import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ContextException;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.ErrorResponse;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

/***********************************************************
 * @author Umbreon Majora
 * <p>
 * Command: /createreactionmessage <Message_ID> <Reaction_Emoji> <Reaction_Role>
 * <p>
 * Description: Allow's the user to create reaction roles messages.
 * The user has to create an own message and get that message ID.
 * Now with this command the user can add a Reaction to his message and if user also reacts with the emoji they will
 * recieve the role. This is not possible with roles that have admin permissions.
 ************************************************************/
public class CreateReactionMessageCommand {

    private final DatabaseRequests databaseRequests;
    private final ReactionRolesCache reactionRolesCache;

    private final Logger LOGGER = LoggerFactory.getLogger(CreateReactionMessageCommand.class);

    public CreateReactionMessageCommand(ReactionRolesCache reactionRolesCache, DatabaseRequests databaseRequests) {
        this.reactionRolesCache = reactionRolesCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCreateReactionMessageCommand(SlashCommandInteractionEvent event) {
        String commandExecutor = event.getUser().getName() + "#" + event.getUser().getDiscriminator();
        String guildID = event.getGuild().getId();

        String messageID = getMessageID(event);
        if (messageID == null) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a reaction role but it failed because messageID was null.");
            LOGGER.info("{} tried to create a reaction role but it failed because messageID was null.", commandExecutor);
            event.reply(StringUtils.messageIdNullError).setEphemeral(true).queue();
            return;
        }

        String emote = getEmote(event);
        if (emote == null) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a reaction role but it failed because emoji was null.");
            LOGGER.info("{} tried to create a reaction role but it failed because emoji was null.", commandExecutor);
            event.reply(StringUtils.emoteNullError).setEphemeral(true).queue();
            return;
        }

        Role role = getRole(event);
        if (role == null) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a reaction role but it failed because role was null.");
            LOGGER.info("{} tried to create a reaction role but it failed because role was null.", commandExecutor);
            event.reply(StringUtils.roleNullError).setEphemeral(true).queue();
            return;
        }

        if (hasRoleAdminPermissions(role)) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a new reaction role but it failed because the role has admin permissions.");
            LOGGER.info("{} tried to create a new reaction role but it failed because the role has admin permissions.", commandExecutor);
            event.reply(StringUtils.roleHasAdminPermissionsError).setEphemeral(true).queue();
            return;
        }

        MessageChannelUnion channel = event.getChannel();
        if (doMessageNotExist(channel, messageID)) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a new reaction role but it failed because the message doesn't exist.");
            LOGGER.info("{} tried to create a new reaction role but it failed because the message doesn't exist.", commandExecutor);
            event.reply(StringUtils.messageNotFoundError).setEphemeral(true).queue();
            return;
        }

        if (isMaxReactionRolesReached(messageID)) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a reaction role but it failed because the max amount of reaction roles on this" +
                    " message is reached.");
            LOGGER.info("{} tried to create a reaction role but it failed because the max amount of reaction roles on" +
                    " this message is reached.", commandExecutor);
            event.reply(StringUtils.maxAmountOfReactionRolesReachedError).setEphemeral(true).queue();
            return;
        }

        Emoji emoji = Emoji.fromFormatted(emote);
        if (isEmoteAlreadyInUse(event.getChannel(), messageID, emoji)) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a reaction role but it failed because messageID was null.");
            LOGGER.info("{} tried to create a reaction role but it failed because messageID was null.", commandExecutor);
            event.reply(StringUtils.emoteAlreadyInUseError).setEphemeral(true).queue();
            return;
        }

        String emojiCode = getEmojiCode(emoji);
        if (emojiCode == null) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to create a reaction role but it failed because emoji code was null.");
            LOGGER.info("{} tried to create a reaction role but it failed because emoji code was null.", commandExecutor);
            event.reply(StringUtils.emojiCodeNullError).setEphemeral(true).queue();
            return;
        }


        String emojiType = emoji.getType().name();

        ReactionRole reactionRole = new ReactionRole(messageID, guildID, emojiCode, emojiType, role.getId());
        databaseRequests.createNewReactionRole(reactionRole);
        reactionRolesCache.addReactionRoleToList(reactionRole);
        AtomicBoolean unknownEmoji = new AtomicBoolean(false);
        channel.retrieveMessageById(messageID).queue(message -> {
            message.addReaction(emoji).queue();
        }, (failure) -> {
            if (failure instanceof ContextException) {
                unknownEmoji.set(true);
            }
        });
        if (unknownEmoji.get()) return;
        ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                " created a new reaction role. MessageID: " + messageID + " EmojiCode: " + emojiCode +
                " EmojiType: " + emojiType);
        LOGGER.info("{} has created a new reaction role.", commandExecutor);
        event.reply(StringUtils.reactionRoleCreatedMessage).setEphemeral(true).queue();
    }

    private String getEmojiCode(Emoji emoji) {
        String emojiReactionCode = emoji.getAsReactionCode();
        String emojiCode;

        switch (getEmojiType(emoji)) {
            case "unicode":
                emojiCode = StringUtils.convertEmojiToUnicode(emojiReactionCode);
                break;
            case "custom":
                emojiCode = emojiReactionCode;
                break;
            default:
                emojiCode = null;
                break;
        }

        return emojiCode;
    }

    @NotNull
    private String getEmojiType(Emoji emoji) {
        return emoji.getType().name().toLowerCase();
    }

    private boolean isMaxReactionRolesReached(String messageID) {
        return reactionRolesCache.getReactionRolesAmountFromMessage(messageID) >= 10;
    }

    //Todo: Is there a better option to handle this?
    private boolean doMessageNotExist(MessageChannelUnion channel, String messageID) {
        AtomicBoolean result = new AtomicBoolean(false);

        channel.retrieveMessageById(messageID).queue((message) -> {
        }, (failure) -> {
            if (failure instanceof ErrorResponseException) {
                ErrorResponseException ex = (ErrorResponseException) failure;
                if (ex.getErrorResponse() == ErrorResponse.UNKNOWN_MESSAGE) {
                    result.set(true);
                }
            }
        });

        return result.get();
    }

    private boolean isEmoteAlreadyInUse(MessageChannelUnion channel, String messageID, Emoji emoji) {
        AtomicBoolean result = new AtomicBoolean(false);

        channel.retrieveMessageById(messageID).queue((message) -> {
            for (MessageReaction reaction : message.getReactions()) {

                String emojiAsReactionCode = emoji.getAsReactionCode();
                String messageReactionAsReactionCode = reaction.getEmoji().getAsReactionCode();

                if (emojiAsReactionCode.equals(messageReactionAsReactionCode)) {
                    result.set(true);
                }
            }
        });

        return result.get();
    }

    private String getMessageID(SlashCommandInteractionEvent event) {
        OptionMapping messageIdOption = event.getOption("messageid");

        if (messageIdOption != null) {
            return messageIdOption.getAsString();
        }

        return null;
    }

    private String getEmote(SlashCommandInteractionEvent event) {
        OptionMapping emoteOption = event.getOption("emote");

        if (emoteOption != null) {
            return emoteOption.getAsString();
        }

        return null;
    }

    private Role getRole(SlashCommandInteractionEvent event) {
        OptionMapping roleIdOption = event.getOption("role");

        if (roleIdOption != null) {
            return roleIdOption.getAsRole();
        }

        return null;
    }

    private boolean hasRoleAdminPermissions(Role role) {
        return role.hasPermission(Permission.ADMINISTRATOR);
    }
}