package me.umbreon.diabloimmortalbot.commands.info_commands;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.commands.ClientCommand;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.TimeUtils;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Umbreon Majora
 * <p>
 * Description:
 * Sends the user a list of all upcomming events.
 * <p>
 * Command:
 * /upcoming
 */
public class UpComingCommand implements ClientCommand {

    private final GameEventsCache gameEventsCache;
    private final GuildsCache guildsCache;

    public UpComingCommand(GameEventsCache gameEventsCache, GuildsCache guildsCache) {
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

        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithDemonGatesTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoDemonGatesMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithShadowLotteryTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoShadowLotteryMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithHauntedCarriageTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoHauntedCarriageMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithBattlegroundTimes(), true)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoBattlegroundMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithAssemblyTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoAssemblyMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithAncientNightmareTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoAncientNightmareMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithAncientAreaTimes(), false)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoAncientArenaMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithWrathborneInvasionTimes(), true)) {
            if (!addedHeader) {
                stringBuilder.append("\n").append(LanguageController.getInfoWrathborneInvasionMessage(guildLanguage)).append(":\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }
        addedHeader = false;
        for (String s : getTodayUpComingEvents(weekday, timeZone, gameEventsCache.getListWithVaultTimes(), true)) {
            if (!addedHeader) {
                stringBuilder.append("\nVault:\n");
                addedHeader = true;
            }
            stringBuilder.append(s).append("\n");
        }

        event.reply(stringBuilder.toString()).setEphemeral(true).queue();
    }

    private List<String> getTodayUpComingEvents(String weekday, String timeZone, Map<String, Boolean> eventList, boolean everyday) {
        List<String> result = new ArrayList<>();
        eventList.forEach((time, isHeadUp) -> {
            if (!isHeadUp) {
                if (everyday) {
                    Date eventTime = TimeUtils.getTimeAsCalendar(time).getTime();
                    Date nowTime = TimeUtils.getTimeAsCalendar(TimeUtils.getTime(timeZone)).getTime();
                    if (eventTime.after(nowTime)) {
                        result.add(time);
                    }
                } else {
                    if (time.toLowerCase().contains(weekday.toLowerCase())) {
                        String[] tmp = time.split(" ");
                        Date eventTime = TimeUtils.getTimeAsCalendar(tmp[1]).getTime();
                        Date nowTime = TimeUtils.getTimeAsCalendar(TimeUtils.getTime(timeZone)).getTime();
                        if (eventTime.after(nowTime)) {
                            result.add(tmp[1]);
                        }
                    }
                }
            }
        });

        return result;
    }

}
