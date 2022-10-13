package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReactionRemove extends ListenerAdapter implements MessageReactionRoles {

    private final ReactionRolesCache reactionRolesCache;

    private final Logger LOGGER = LoggerFactory.getLogger(MessageReactionRemove.class);

    public MessageReactionRemove(ReactionRolesCache reactionRolesCache) {
        this.reactionRolesCache = reactionRolesCache;
    }

    @Override
    public void onMessageReactionRemove(final MessageReactionRemoveEvent event) {
        if (isChannelTypeNotTextChannel(event.getChannelType())) {
            return;
        }

        User user = event.getUser();
        if (isUserBot(user)) {
            return;
        }

        String messageID = event.getMessageId();
        Emoji emoji = event.getEmoji();
        String emojiCode = getEmojiCode(emoji);
        if (!doReactionRoleExists(messageID, emojiCode)) {
            return;
        }

        String commandExecutor = user.getName() + "#" + user.getDiscriminator();
        String guildID = event.getGuild().getId();
        ReactionRole reactionRole = getReactionRoleFromCache(messageID, emojiCode);
        if (reactionRole == null) {
            ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                    " tried to remove a role using reaction roles but it failed because reactionRole was null.");
            LOGGER.info("{} tried to remove a role using reaction roles but it failed because reactionRole was null.", commandExecutor);
            return;
        }

        String roleID = reactionRole.getRoleID();
        try {
            Role role = getRoleByID(event.getGuild(), roleID);
            event.getGuild().removeRoleFromMember(user, role).queue();
            String roleName = role.getName();

            ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                    " removed a role using reaction roles. Added role " + roleName);
            LOGGER.info("{} removed a role using reaction roles. Added role {}.", commandExecutor, roleName);
            user.openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage(String.format(StringUtils.lostRoleMessage, roleName)).queue();
            });
        } catch (InsufficientPermissionException e) {
            if (e.getMessage().equals("Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES")) {
                ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                        " tried to remove a role using reaction roles but it failed because insufficient permissions.");
                LOGGER.info("{} tried to remove a role using reaction roles but it failed because insufficient permissions.", commandExecutor);
                event.getGuild().getOwner().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessage("Hey, I can't give people roles because of insufficient permissions.").queue();
                });
            }
        } catch (HierarchyException e) {
            ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                    " tried to remove a role using reaction roles but it failed because insufficient permissions.");
            LOGGER.info("{} tried to remove a role using reaction roles but it failed because the bot can't modify a role with higher or equal highest role.", commandExecutor);
            event.getGuild().getOwner().getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage("Hey, I can't give people roles because of the hierarchy.").queue();
            });
        }
    }

    private boolean doReactionRoleExists(String messageID, String emojiCode) {
        return reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, emojiCode) != null;
    }

    private ReactionRole getReactionRoleFromCache(String messageID, String emojiCode) {
        return reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, emojiCode);
    }

}
