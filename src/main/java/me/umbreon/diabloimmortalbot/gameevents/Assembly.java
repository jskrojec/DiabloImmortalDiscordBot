package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class Assembly {

    private final Map<String, Boolean> listAssembly;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public Assembly(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listAssembly = databaseRequests.getEventTimes("event_assembly", false);
        this.clientCache = clientCache;
    }

    public void checkAssembly(TextChannel textChannel, String timezone) {
        String time = Time.getFullTime(timezone);
        if (listAssembly.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listAssembly.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getAssemblyHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getAssemblyMessage()).queue();
        }
    }

}
