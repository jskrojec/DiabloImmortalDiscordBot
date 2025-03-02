package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import org.jetbrains.annotations.NotNull;

public interface MessageReactionRoles {

    default String getEmojiCode(Emoji emoji) {
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
    default String getEmojiType(Emoji emoji) {
        return emoji.getType().name().toLowerCase();
    }

    default Role getRoleByID(Guild guild, String roleID) {
        return guild.getRoleById(roleID);
    }

    default boolean isChannelTypeNotTextChannel(final ChannelType channelType) {
        return channelType.getId() != 0;
    }

    default boolean isUserBot(User user) {
        if (user == null) {
            //Small workaround, user can be null. If so just return true so the event will be cancelled.
            return true;
        }

        return user.isBot();
    }

    default boolean doRoleStillExists(Guild guild, String roleID) {
        return guild.getRoleById(roleID) != null;
    }
}
