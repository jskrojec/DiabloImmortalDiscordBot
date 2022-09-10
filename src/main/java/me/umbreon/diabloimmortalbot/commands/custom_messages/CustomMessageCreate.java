package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

/**
 * Command: >cm create
 */
public class CustomMessageCreate {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessageCreate(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    private TextChannel findTextChannel(final String textChannelID, final Guild guild) {
        final List<TextChannel> textChannels = guild.getTextChannels();
        return textChannels.stream()
                .filter(textChannel -> textChannel.getId().equalsIgnoreCase(textChannelID))
                .findFirst()
                .orElse(null);
    }

}
