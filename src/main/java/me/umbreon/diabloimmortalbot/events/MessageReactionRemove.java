package me.umbreon.diabloimmortalbot.events;

import emoji4j.EmojiUtils;
import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class MessageReactionRemove extends ListenerAdapter {

    private final ReactionRolesCache reactionRolesCache;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public MessageReactionRemove(ReactionRolesCache reactionRolesCache) {
        this.reactionRolesCache = reactionRolesCache;
    }

    @Override
    public void onMessageReactionRemove(final MessageReactionRemoveEvent event) {
        String messageID = event.getReaction().getMessageId();

        if (!reactionRolesCache.doReactionRoleMessageExists(messageID)) {
            return;
        }

        ReactionRole reactionRole = reactionRolesCache.getReactionRoleByMessageID(messageID);

        if (!EmojiUtils.emojify(reactionRole.getEmojiID()).equalsIgnoreCase(EmojiUtils.emojify(event.getReactionEmote().getAsReactionCode()))) {
            return;
        }

        String guildID = event.getGuild().getId();
        String textChannelID = event.getTextChannel().getId();
        String log;
        Guild guild = event.getGuild();
        Member member = event.getMember();
        User user = event.getUser();
        if (member == null || user == null || guild == null) {
            log = "Failed to run " + getClass().getSimpleName() + " because of NullPointerException.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry("global", textChannelID, log);
            return;
        }

        if (!hasRole(member, reactionRole.getRoleID())) {
            return;
        }

        String roleID = reactionRole.getRoleID();
        Role role = event.getGuild().getRoleById(roleID);
        if (role == null) {
            log = member.getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to remove a role using reaction roles but it failed because role was null";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            return;
        }

        log = "Added " + role.getName() + " to " + member.getEffectiveName() + " by using reaction role.";
        LOGGER.info(log);
        ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
        event.getGuild().removeRoleFromMember(member, role).queue();
    }

    private boolean hasRole(Member member, String roleID) {
        Role role = member.getRoles().stream()
                .filter(guildRole -> guildRole.getId().equalsIgnoreCase(roleID))
                .findFirst()
                .orElse(null);
        return role != null;
    }
}

