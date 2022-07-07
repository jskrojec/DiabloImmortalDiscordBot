package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class HauntedCarriage {

    private final Map<String, Boolean> listHauntedCarriage;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public HauntedCarriage(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listHauntedCarriage = databaseRequests.getEventTimes("event_haunted_carriage", false);
        this.clientCache = clientCache;
    }

    public void checkHauntedCarriage(TextChannel textChannel, String timezone) {
        String time = Time.getFullTime(timezone);
        if (listHauntedCarriage.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listHauntedCarriage.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getHauntedCarriageHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getHauntedCarriageMessage()).queue();
        }
    }

}
