package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class RaidVault {

    private final Map<String, Boolean> listVault;
    private final ClientCache clientCache;

    public RaidVault(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listVault = databaseRequests.getEventTimes("event_vault", true);
        this.clientCache = clientCache;
    }

    public String checkVault(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            if (clientCache.getHeadUpValue(guildID)) {
                return LanguageController.getRaidTheVaultHeadUpMessage(language) + "\n";
            }
        } else {
            return LanguageController.getRaidTheVaultMessage(language) + "\n";
        }
        return "";
    }

    private boolean isTimeValid(String timezone) {
        String time = Time.getTime(timezone);
        return listVault.get(time) != null;
    }

    private boolean isHeadUpTime(String timezone) {
        String time = Time.getTime(timezone);
        return listVault.get(time);
    }

}
