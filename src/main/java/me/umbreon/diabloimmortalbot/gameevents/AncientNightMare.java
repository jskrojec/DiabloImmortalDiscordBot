package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class AncientNightMare {

    private final Map<String, Boolean> listAncientNightMare;
    private ClientConfig clientConfig;
    private final ClientCache clientCache;

    public AncientNightMare(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        listAncientNightMare = databaseRequests.getEventTimes("event_ancient_nightmare", false);
        this.clientCache = clientCache;
    }

    public void checkAncientNightMare(TextChannel textChannel, String timezone) {
        String time = Time.getFullTime(timezone);
        if (listAncientNightMare.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listAncientNightMare.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getAncientNightmareHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getAncientNightmareMessage()).queue();
        }
    }

}
