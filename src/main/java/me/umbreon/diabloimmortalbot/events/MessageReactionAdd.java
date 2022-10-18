package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.exceptions.HierarchyException;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReactionAdd extends ListenerAdapter implements MessageReactionRoles {

    private final ReactionRolesCache reactionRolesCache;
    private final DatabaseRequests databaseRequests;

    private final Logger LOGGER = LoggerFactory.getLogger(MessageReactionAdd.class);

    public MessageReactionAdd(ReactionRolesCache reactionRolesCache, DatabaseRequests databaseRequests) {
        this.reactionRolesCache = reactionRolesCache;
        this.databaseRequests = databaseRequests;
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
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
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to get a role using reaction roles but it failed because reactionRole was null.");
            LOGGER.info("{} tried to get a role using reaction roles but it failed because reactionRole was null.", commandExecutor);
            return;
        }

        String roleID = reactionRole.getRoleID();
        if (!doRoleStillExists(event.getGuild(), roleID)) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to get a role using reaction roles but the role no longer exists so it will be deleted " +
                    "from the system. RoleID: " + roleID + " MessageID: " + messageID + " EmojiCode: " + emojiCode);
            LOGGER.info("{} tried to get a role using reaction roles but the role no longer exists so it will be " +
                    "deleted from the system.", commandExecutor);
            deleteReactionRole(messageID, emojiCode);
            return;
        }

        try {
            Role role = getRoleByID(event.getGuild(), roleID);
            event.getGuild().addRoleToMember(user, role).queue();
            String roleName = role.getName();

            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " got a role using reaction roles. Added role " + roleName);
            LOGGER.info("{} got a role using reaction roles. Added role {}.", commandExecutor, roleName);
            user.openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage(String.format(StringUtils.receivedRoleMessage, roleName)).queue();
            });
        } catch (InsufficientPermissionException e) {
            if (e.getMessage().equals("Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES")) {
                ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                        " tried to get a role using reaction roles but it failed because insufficient permissions.");
                LOGGER.info("{} tried to get a role using reaction roles but it failed because insufficient permissions.", commandExecutor);
                event.getGuild().getOwner().getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessage("Hey, I can't give people roles because of insufficient permissions.").queue();
                });
            }
        } catch (HierarchyException e) {
            ClientLogger.createNewServerLogEntry(guildID, commandExecutor +
                    " tried to remove a role using reaction roles but it failed because insufficient permissions.");
            LOGGER.info("{} tried to remove a role using reaction roles but it failed because the bot can't modify a role with higher or equal highest role.", commandExecutor);
            event.getGuild().getOwner().getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage("Hey, I can't give people roles because of the hierarchy.").queue();
            });
        }
    }

    private void deleteReactionRole(String messageID, String emojiCode) {
        reactionRolesCache.deleteReactionRole(messageID, emojiCode);
        databaseRequests.deleteReactionRole(messageID, emojiCode);
    }

    private boolean doReactionRoleExists(String messageID, String emojiCode) {
        return reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, emojiCode) != null;
    }

    private ReactionRole getReactionRoleFromCache(String messageID, String emojiCode) {
        return reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, emojiCode);
    }

}
