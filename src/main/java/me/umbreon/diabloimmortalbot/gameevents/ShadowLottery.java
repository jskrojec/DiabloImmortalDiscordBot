package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class ShadowLottery {

    private final Map<String, Boolean> listShadowLottery;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public ShadowLottery(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listShadowLottery = databaseRequests.getEventTimes("event_shadow_lottery", true);
        this.clientCache = clientCache;
    }

    public void checkShadowLottery(TextChannel textChannel, String timezone) {
        String time = Time.getTime(timezone);
        if (listShadowLottery.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());

        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listShadowLottery.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getShadowLotteryHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getShadowLotteryMessage()).queue();
        }
    }



}
