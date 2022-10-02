package me.umbreon.diabloimmortalbot.commands.reaction_commands;

import emoji4j.EmojiUtils;
import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***********************************************************
 * @author Umbreon Majora
 * <p>
 * Command: /removereactionmessage <Message_ID> <Reaction_Emoji>
 * <p>
 * Description:
 *
 * CommandOption 1: MessageID (messageid)
 * CommandOption 2: Reaction_Emote (emote)
 ************************************************************/
public class RemoveReactionCommand {

    private final ReactionRolesCache reactionRolesCache;
    private final DatabaseRequests databaseRequests;

    private final Logger LOGGER = LoggerFactory.getLogger(RemoveReactionCommand.class);

    public RemoveReactionCommand(ReactionRolesCache reactionRolesCache, DatabaseRequests databaseRequests) {
        this.reactionRolesCache = reactionRolesCache;
        this.databaseRequests = databaseRequests;
    }

    public void runRemoveReactionCommand(final SlashCommandInteractionEvent event) {
        String log;
        Member member = event.getMember();
        User user = event.getUser();
        Guild guild = event.getGuild();

        if (member == null || guild == null) {
            log = "Failed to run " + getClass().getSimpleName() + " because guild or member was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry("global", "global", log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        String guildID = guild.getId();

        OptionMapping messageIdOption = event.getOption("messageid");
        String messageID;
        if (messageIdOption != null) {
            messageID = messageIdOption.getAsString();
        } else {
            log = user.getName() + "#" + user.getDiscriminator() + " tried to remove a reaction role but it failed because messageID was null.";
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            LOGGER.info(log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        OptionMapping emoteOption = event.getOption("emote");
        String emote;
        if (emoteOption != null) {
            emote = emoteOption.getAsString();
        } else {
            log = user.getName() + "#" + user.getDiscriminator() + " tried to remove a reaction role but it failed because emote was null.";
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            LOGGER.info(log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        String codifiedEmote = EmojiUtils.shortCodify(EmojiUtils.emojify(emote));
        ReactionRole reactionRole = reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, codifiedEmote);

        if (reactionRole == null) {
            log = user.getName() + "#" + user.getDiscriminator() + " tried to remove a reaction role but it failed because Reaction Role Object was null.";
            ClientLogger.createNewServerLogEntry(guildID, "global", log);
            LOGGER.info(log);
            event.reply(log).setEphemeral(true).queue();
            return;
        }

        event.getChannel().retrieveMessageById(messageID).queue(message -> {
            for (MessageReaction messageReaction : message.getReactions()) {
                String codifiedEmote1 = EmojiUtils.shortCodify(messageID);
                if (codifiedEmote1.equalsIgnoreCase(codifiedEmote)) {
                    message.getReactions().remove(messageReaction);
                    event.reply("Removed emote from message").setEphemeral(true).queue();
                    databaseRequests.deleteReactionRole(messageID, codifiedEmote);
                    reactionRolesCache.deleteReactionRole(messageID, codifiedEmote);
                    return;
                }
            }
        });

        event.reply("FAILED").setEphemeral(true).queue();
    }
}
