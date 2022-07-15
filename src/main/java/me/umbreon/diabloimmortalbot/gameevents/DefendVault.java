package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.configuration.LanguageController;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class DefendVault {

    private final Map<String, Boolean> listVault;

    public DefendVault(DatabaseRequests databaseRequests) {
        this.listVault = databaseRequests.getEventTimes("event_vault", true);
    }

    public String checkDefendVault(String timezone, String language) {
        if (!isTimeValid(timezone)) return "";

        if (isHeadUpTime(timezone)) {
            return LanguageController.getDefendTheVaultHeadUpMessage(language) + "\n";
        } else {
            return LanguageController.getDefendTheVaultMessage(language) + "\n";
        }
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
