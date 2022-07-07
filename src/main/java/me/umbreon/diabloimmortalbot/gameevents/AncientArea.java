package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class AncientArea {

    private final Map<String, Boolean> listAncientArea;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public AncientArea(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listAncientArea = databaseRequests.getEventTimes("event_ancient_area", false);
        this.clientCache = clientCache;
    }

    public void checkAncientArea(TextChannel textChannel, String timezone) {

        String time = Time.getFullTime(timezone);
        if (listAncientArea.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listAncientArea.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getAncientAreaHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getAncientAreaMessage()).queue();
        }
    }

}
