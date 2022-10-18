package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.languages.LanguageController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Umbreon Majora
 * <p>
 * System cache for static variables.
 */
public class ClientCache {

    private static final ArrayList<String> listWithAvailableNotifications = new ArrayList<>();

    public ArrayList<String> getListWithAvailableNotifications() {
        return listWithAvailableNotifications;
    }

    private static final ArrayList<String> listOfAvailableEventDays = new ArrayList<>();

    public ArrayList<String> getListOfAvailableEventDays() {
        return listOfAvailableEventDays;
    }

    private static final List<String> listWithSupportedLanguage = new ArrayList<>();

    public List<String> getListWithSupportedLanguage() {
        return listWithSupportedLanguage;
    }

    static {
        listWithAvailableNotifications.add("message");
        listWithAvailableNotifications.add("headup");

        listWithAvailableNotifications.add("ancientarena");
        listWithAvailableNotifications.add("ancientnightmare");
        listWithAvailableNotifications.add("assembly");
        listWithAvailableNotifications.add("battlegrounds");
        listWithAvailableNotifications.add("defendvault");
        listWithAvailableNotifications.add("raidvault");
        listWithAvailableNotifications.add("demongates");
        listWithAvailableNotifications.add("shadowlottery");
        listWithAvailableNotifications.add("hauntedcarriage");
        listWithAvailableNotifications.add("wrathborneinvasion");

        listWithAvailableNotifications.add("hauntedcarriageembed");
        listWithAvailableNotifications.add("demongatesembed");
        listWithAvailableNotifications.add("ancientnightmareembed");
        listWithAvailableNotifications.add("ancientarenaembed");

        listOfAvailableEventDays.add("monday");
        listOfAvailableEventDays.add("tuesday");
        listOfAvailableEventDays.add("wednesday");
        listOfAvailableEventDays.add("thursday");
        listOfAvailableEventDays.add("friday");
        listOfAvailableEventDays.add("saturday");
        listOfAvailableEventDays.add("sunday");
        listOfAvailableEventDays.add("everyday");

        for (String language : LanguageController.languages) {
            listWithSupportedLanguage.add(language.toLowerCase());
        }
    }

}
