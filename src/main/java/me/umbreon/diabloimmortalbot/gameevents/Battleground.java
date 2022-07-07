package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class Battleground {

    private final Map<String, Boolean> listBattleground;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public Battleground(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listBattleground = databaseRequests.getEventTimes("event_battleground", true);
        this.clientCache = clientCache;
    }

    public void checkBattleground(TextChannel textChannel, String timezone) {
        String time = Time.getTime(timezone);
        if (listBattleground.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listBattleground.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getBattlegroundHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getBattlegroundMessage()).queue();
        }
    }

}
