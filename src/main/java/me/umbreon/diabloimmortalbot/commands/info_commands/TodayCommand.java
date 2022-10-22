package me.umbreon.diabloimmortalbot.commands.info_commands;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.commands.ClientCommand;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Umbreon Majora
 * <p>
 * Description:
 * Sends the user a list of all today events.
 * <p>
 * Command:
 * /today
 */
public class TodayCommand implements ClientCommand {

    private final GameEventsCache gameEventsCache;
    private final GuildsCache guildsCache;

    public TodayCommand(GameEventsCache gameEventsCache, GuildsCache guildsCache) {
        this.gameEventsCache = gameEventsCache;
        this.guildsCache = guildsCache;
    }

    @Override
    public void runCommand(SlashCommandInteraction event) {
        String guildID = event.getGuild().getId();
        String timeZone = guildsCache.getGuildTimeZone(guildID);
        String weekday = TimeUtils.getCurrentWeekday(timeZone);
        String guildLanguage = guildsCache.getGuildLanguage(guildID);
        boolean addedHeader = false;
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithDemonGatesTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoDemonGatesMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithShadowLotteryTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoShadowLotteryMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithHauntedCarriageTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoHauntedCarriageMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithBattlegroundTimes(), true)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoBattlegroundMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithAssemblyTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoAssemblyMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithAncientNightmareTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoAncientNightmareMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithAncientAreaTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoAncientArenaMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithWrathborneInvasionTimes(), true)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoWrathborneInvasionMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayEvents(weekday, gameEventsCache.getListWithVaultTimes(), true)) {
            if (!addedHeader) {
                stringBuilder.append("\nVault:\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }

        event.reply(stringBuilder.toString()).setEphemeral(true).queue();
    }

    private List<String> getTodayEvents(String weekday, Map<String, Boolean> eventList, boolean everyday) {
        List<String> result = new ArrayList<>();
        eventList.forEach((time, isHeadUp) -> {
            if (!isHeadUp) {
                if (everyday) {
                    result.add(time);
                } else {
                    String[] tmp = time.split(" ");
                    if (tmp[0].equalsIgnoreCase(weekday)) {
                        result.add(tmp[1]);
                    }
                }
            }
        });

        return result;
    }

}
