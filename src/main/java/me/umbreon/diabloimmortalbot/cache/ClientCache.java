package me.umbreon.diabloimmortalbot.cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientCache {

    private final ArrayList<String> listWithAvailableNotifications = new ArrayList<>();

    public void fillListWithEvents() {
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
    }

    public ArrayList<String> getListWithAvailableNotifications() {
        return listWithAvailableNotifications;
    }

    // -

    private final ArrayList<String> listOfAvailableEventDays = new ArrayList<>();

    public void fillListWithAvailableEventDays() {
        listOfAvailableEventDays.add("monday");
        listOfAvailableEventDays.add("tuesday");
        listOfAvailableEventDays.add("wednesday");
        listOfAvailableEventDays.add("thursday");
        listOfAvailableEventDays.add("friday");
        listOfAvailableEventDays.add("saturday");
        listOfAvailableEventDays.add("sunday");
        listOfAvailableEventDays.add("everyday");
    }

    public ArrayList<String> getListOfAvailableEventDays() {
        return listOfAvailableEventDays;
    }

    // -

    private final List<String> listWithSupportedLanguage = Arrays.asList(
            "ger", "eng", "esp", "fra", "pol", "ita", "rus", "ind", "ukr");

    public List<String> getListWithSupportedLanguage() {
        return listWithSupportedLanguage;
    }

}