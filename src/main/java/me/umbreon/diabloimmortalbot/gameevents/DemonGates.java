package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class DemonGates {

    private final Map<String, Boolean> listDemonGates;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public DemonGates(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listDemonGates = databaseRequests.getEventTimes("event_demon_gates", false);
        this.clientCache = clientCache;
    }

    public void checkDemonGates(TextChannel textChannel, String timezone) {
        String time = Time.getFullTime(timezone);
        if (listDemonGates.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listDemonGates.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getDemonGatesHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getDemonGatesMessage()).queue();
        }
    }
}
