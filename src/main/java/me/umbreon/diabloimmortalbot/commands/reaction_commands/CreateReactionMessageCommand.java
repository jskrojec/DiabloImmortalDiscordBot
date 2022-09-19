package me.umbreon.diabloimmortalbot.commands.reaction_commands;

import emoji4j.EmojiUtils;
import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.ErrorResponseException;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.ErrorResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /createreactionmessage <Message_ID> <Reaction_Emoji> <Reaction_Role>
 * <p>
 * Description: Allow's the user to create reaction roles messages.
 * The user has to create an own message and get that message ID.
 * Now with this command the user can add a Reaction to his message and if user also reacts with the emoji they will
 * recieve the role. This is not possible with roles that have admin permissions.
 * <p>
 * Database: [guildID] [reactionRoleMsgID]-autoincrement [emojiID] [roleID]
 * <p>
 * Command send must be in the same channel?
 */
public class CreateReactionMessageCommand {

    private final DatabaseRequests databaseRequests;
    private final ReactionRolesCache reactionRolesCache;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public CreateReactionMessageCommand(ReactionRolesCache reactionRolesCache, DatabaseRequests databaseRequests) {
        this.reactionRolesCache = reactionRolesCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCreateReactionMessageCommand(final SlashCommandInteractionEvent event) {
        OptionMapping messageIdOption = event.getOption("messageid");
        String messageID;
        String log;
        Member member = event.getMember();
        User user = event.getUser();
        Guild guild = event.getGuild();

        String textChannelID = event.getTextChannel().getId();
        if (member == null || guild == null) {
            log = "Failed to run " + getClass().getSimpleName() + " because guild or member was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry("global", textChannelID, log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        String guildID = guild.getId();

        if (messageIdOption != null) {
            messageID = messageIdOption.getAsString();
        } else {
            log = member.getEffectiveName() + "#" + user.getDiscriminator() + " tried to create a reaction role but it failed because messageID was null.";
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            LOGGER.info(log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        OptionMapping roleIdOption = event.getOption("roleid");
        Role role;
        if (roleIdOption != null) {
            role = roleIdOption.getAsRole();
        } else {
            log = member.getEffectiveName() + "#" + user.getDiscriminator() + " tried to create a reaction role but it failed because roleID was null.";
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            LOGGER.info(log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        OptionMapping emoteOption = event.getOption("emote");
        String emoteID;
        if (emoteOption != null) {
            emoteID = emoteOption.getAsString();
        } else {
            log = member.getEffectiveName() + "#" + user.getDiscriminator() + " tried to create a reaction role but it failed because emoji was null.";
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            LOGGER.info(log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        ReactionRole reactionRole = new ReactionRole(messageID, guildID, EmojiUtils.hexHtmlify(emoteID), role.getId());
        reactionRolesCache.addReactionRoleToList(reactionRole);
        databaseRequests.createNewReactionRole(reactionRole);

        event.getTextChannel().retrieveMessageById(messageID).queue((message) -> message.addReaction(emoteID).queue(), (failure) -> {
            if (failure instanceof ErrorResponseException) {
                ErrorResponseException ex = (ErrorResponseException) failure;
                if (ex.getErrorResponse() == ErrorResponse.UNKNOWN_MESSAGE) {
                    event.getTextChannel().sendMessage("That message doesn't exist !").queue();
                }
            }
            failure.printStackTrace();
        });
    }
}
