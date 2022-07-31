package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.Time;

import java.util.Map;

public class DefendVault {

    private final Map<String, Boolean> listVault;
    private final ClientCache clientCache;

    public DefendVault(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.listVault = databaseRequests.getEventTimes("event_vault", true);
        this.clientCache = clientCache;
    }

    public String checkDefendVault(String timezone, String language, String guildID) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            if (clientCache.getHeadUpValue(guildID))
                return LanguageController.getDefendTheVaultHeadUpMessage(language) + "\n";
        } else {
            if (clientCache.isEventMessageEnabled(guildID))
                return LanguageController.getDefendTheVaultMessage(language) + "\n";
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
