package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

public class WeeklyReset {

    private final String weeklyRestTime;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public WeeklyReset(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.weeklyRestTime = databaseRequests.getWeeklyResetTime("event_weekly_reset");
        this.clientCache = clientCache;
    }

    public void checkIfResetted(TextChannel textChannel, String timezone) {
        String time = Time.getTime(timezone);
        if (!weeklyRestTime.equals(time)) return;

        String roleId = clientCache.getRoleId(textChannel.getId());
        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        textChannel.sendMessage(mentionMessage + clientConfig.getWeeklyResetMessage()).queue();
    }

}
