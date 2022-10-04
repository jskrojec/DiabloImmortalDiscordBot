package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;

public class MessageReactionAdd extends ListenerAdapter {

    private final ReactionRolesCache reactionRolesCache;
    private final DatabaseRequests databaseRequests;

    private final Logger LOGGER = LoggerFactory.getLogger(MessageReactionAdd.class);

    public MessageReactionAdd(ReactionRolesCache reactionRolesCache, DatabaseRequests databaseRequests) {
        this.reactionRolesCache = reactionRolesCache;
        this.databaseRequests = databaseRequests;
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        if (!isChannelTypeNotText(event.getChannel())) {
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
                    " tried to get a role using reaction roles but it failed because reactionRole was null.");
            LOGGER.info("{} tried to get a role using reaction roles but it failed because reactionRole was null.", commandExecutor);
            return;
        }

        String roleID = reactionRole.getRoleID();
        if (!doRoleStillExists(event.getGuild(), roleID)) {
            ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                    " tried to get a role using reaction roles but the role no longer exists so it will be deleted " +
                    "from the system. RoleID: " + roleID + " MessageID: " + messageID + " EmojiCode: " + emojiCode);
            LOGGER.info("{} tried to get a role using reaction roles but the role no longer exists so it will be " +
                    "deleted from the system.", commandExecutor);
            deleteReactionRole(messageID, emojiCode);
            return;
        }

        boolean success;
        try {
            Role role = getRoleByID(event.getGuild(), roleID);
            event.getGuild().addRoleToMember(user, role).queue();
            String roleName = role.getName();

            ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                    " got a role using reaction roles. Added role " + roleName);
            LOGGER.info("{} got a role using reaction roles. Added role {}.", commandExecutor, roleName);
        } catch (InsufficientPermissionException e) {
            if (e.getMessage().equals("Cannot perform action due to a lack of Permission. Missing permission: MANAGE_ROLES")) {
                ClientLogger.createNewServerLogEntry(guildID, "server-log", commandExecutor +
                        " tried to get a role using reaction roles but it failed because insufficient permissions.");
                LOGGER.info("{} tried to get a role using reaction roles but it failed because insufficient permissions.", commandExecutor);
            }
        } finally {

        }
    }

    private void deleteReactionRole(String messageID, String emojiCode) {
        reactionRolesCache.deleteReactionRole(messageID, emojiCode);
        databaseRequests.deleteReactionRole(messageID, emojiCode);
    }

    private void sendFeedbackMessageInPrivateChannel(User user, String roleName, boolean success) {
        user.openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessage(String.format(StringUtils.roleReceivedMessage, roleName)).queue();
        });
    }

    private boolean doReactionRoleExists(String messageID, String emojiCode) {
        return reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, emojiCode) != null;
    }

    private ReactionRole getReactionRoleFromCache(String messageID, String emojiCode) {
        return reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, emojiCode);
    }

    @Nullable
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

    private boolean isChannelTypeNotText(MessageChannelUnion channel) {
        return channel.getType().getId() == 0;
    }

    private boolean isUserBot(User user) {
        if (user == null) {
            //Small workaround, user can be null. If so just return true so the event will be cancelled.
            return true;
        }

        return user.isBot();
    }

    private boolean doRoleStillExists(Guild guild, String roleID) {
        return guild.getRoleById(roleID) != null;
    }

    private Role getRoleByID(Guild guild, String roleID) {
        return guild.getRoleById(roleID);
    }

}
