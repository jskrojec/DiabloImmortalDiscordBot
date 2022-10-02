package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.data.ReactionRole;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReactionAdd extends ListenerAdapter {

    private final ReactionRolesCache reactionRolesCache;

    private final Logger LOGGER = LoggerFactory.getLogger(MessageReactionAdd.class);

    public MessageReactionAdd(ReactionRolesCache reactionRolesCache) {
        this.reactionRolesCache = reactionRolesCache;
    }

    @Override
    public void onMessageReactionAdd(final @NotNull MessageReactionAddEvent event) {
        if (!isChannelTypeTextChannel(event.getChannelType())) {
            return;
        }

        String messageID = event.getReaction().getMessageId();
        String guildID = event.getGuild().getId();
        String textChannelID = event.getChannel().getId();
        String log;

        Member member = event.getMember();
        User user = event.getUser();
        if (member == null || user == null) {
            log = "Failed to run " + getClass().getSimpleName() + " because guild or member was null.";
            LOGGER.info(log);
            ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
            return;
        }

        if (user.isBot()) {
            return;
        }

        if (!reactionRolesCache.doReactionRoleMessageExists(messageID)) {
            return;
        }

        //removed for upgrade to alpha20
        String s = "";//EmojiUtils.shortCodify(event.getReaction().getReactionEmote().getAsReactionCode());
        ReactionRole reactionRole = reactionRolesCache.getReactionRoleByMessageIDAndEmojiID(messageID, s);
        String givenReaction = reactionRole.getReactionID();

        if (!givenReaction.equalsIgnoreCase(s)) {
            LOGGER.info("Failed to run onMessageReactionAdd because reacted reaction was not registered.");
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

        log = "Added " + role.getName() + " to " + member.getEffectiveName() + " by using reaction role.";
        LOGGER.info(log);
        ClientLogger.createNewServerLogEntry(guildID, textChannelID, log);
        event.getUser().openPrivateChannel().queue(privateChannel -> {
            privateChannel.sendMessage("You received role " + role.getName()).queue();
        });
        event.getGuild().addRoleToMember(member, role).queue();
    }

    private boolean isChannelTypeTextChannel(final ChannelType channelType) {
        return channelType.getId() == 0;
    }
}
