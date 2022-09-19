package me.umbreon.diabloimmortalbot.events;

import emoji4j.EmojiUtils;
import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class MessageReactionAdd extends ListenerAdapter {

    private final ReactionRolesCache reactionRolesCache;

    private final Logger LOGGER = LogManager.getLogger(getClass());

    public MessageReactionAdd(ReactionRolesCache reactionRolesCache) {
        this.reactionRolesCache = reactionRolesCache;
    }

    @Override
    public void onMessageReactionAdd(final @NotNull MessageReactionAddEvent event) {
        String messageID = event.getReaction().getMessageId();
        String guildID = event.getGuild().getId();
        String textChannelID = event.getTextChannel().getId();
        String log;

        if (!reactionRolesCache.doReactionRoleMessageExists(messageID)) {
            return;
        }

        ReactionRole reactionRole = reactionRolesCache.getReactionRoleByMessageID(messageID);

        if (!EmojiUtils.emojify(reactionRole.getEmojiID()).equalsIgnoreCase(EmojiUtils.emojify(event.getReactionEmote().getAsReactionCode()))) {
            return;
        }

        Member member = event.getMember();
        User user = event.getUser();
        if (member == null || user == null) {
            log = "Failed to run " + getClass().getSimpleName() + " because guild or member was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry("global", textChannelID, log);
            return;
        }

        if (hasRole(member, reactionRole.getRoleID())) {
            return;
        }

        String roleID = reactionRole.getRoleID();
        Role role = event.getGuild().getRoleById(roleID);
        if (role == null) {
            log = member.getEffectiveName() + "#" + event.getUser().getDiscriminator() + " tried to get a new role using reaction roles but it failed because role was null";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            return;
        }

        LOGGER.info("Added " + role.getName() + " to " + member.getEffectiveName() + " by using reaction role.");
        event.getGuild().addRoleToMember(member, role).queue();
    }

    private boolean hasRole(Member member, String roleID) {
        Role role = member.getRoles().stream()
                .filter(guildRole -> guildRole.getId().equalsIgnoreCase(roleID))
                .findFirst()
                .orElse(null);
        return role != null;
    }
}
