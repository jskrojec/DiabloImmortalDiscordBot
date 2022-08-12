package me.umbreon.diabloimmortalbot.utils;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.data.NotifierChannel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientCache {

    // GUILDS CACHE

    public Map<String, GuildInformation> listWithGuildInformation;

    public boolean isAutoDeleteEnabled(String guildID) {
        return listWithGuildInformation.get(guildID).isAutoDeleteEnabled();
    }

    public void setAutoDeleteBoolValue(String guildID, boolean bool) {
        listWithGuildInformation.get(guildID).setAutoDeleteEnabled(bool);
    }

    public int getAutoDeleteValue(String guildID) {
        return listWithGuildInformation.get(guildID).getAutoDeleteValue();
    }

    public void setAutoDeleteIntValue(String guildID, int i) {
        listWithGuildInformation.get(guildID).setAutoDeleteValue(i);
    }

    public void setListWithGuildInformation(Map<String, GuildInformation> listWithGuildInformation) {
        this.listWithGuildInformation = listWithGuildInformation;
    }

    public String getGuildLanguage(String guildID) {
        String language;
        try {
            language = listWithGuildInformation.get(guildID).getLanguage();
        } catch (NullPointerException e) {
            language = "ENG";
        }
        return language;
    }

    public void setGuildTimeZone(String guildID, String guildTimeZone) {
        listWithGuildInformation.get(guildID).setTimezone(guildTimeZone);
    }

    public GuildInformation getGuildInformation(String guildID) {
        return listWithGuildInformation.get(guildID);
    }

    public String getGuildTimeZone(String guildID) {
        return listWithGuildInformation.get(guildID).getTimezone();
    }

    public void setGuildLanguage(String guildID, String language) {
        listWithGuildInformation.get(guildID).setLanguage(language);
    }

    public boolean doGuildExists(String guildID) {
        return listWithGuildInformation.containsKey(guildID);
    }

    public void addGuildInformation(GuildInformation guildInformation) {
        this.listWithGuildInformation.put(guildInformation.getGuildID(), guildInformation);
    }

    public boolean isHeadUpOnServerEnabled(String guildID) {
        return listWithGuildInformation.get(guildID).isHeadUpEnabled();
    }

    public void setHeadUpOnServerValue(String guildID, boolean value) {
        listWithGuildInformation.get(guildID).setHeadUpEnabled(value);
    }

    public boolean isEventMessageOnServerEnabled(String guildID) {
        return listWithGuildInformation.get(guildID).isEventMessageEnabled();
    }

    public void setEventMessageOnServerValue(String guildID, boolean value) {
        listWithGuildInformation.get(guildID).setEventMessageEnabled(value);
    }


    // CUSTOM MESSAGES CACHE

    private Map<Integer, CustomMessage> customMessagesList;

    public void setCustomMessagesList(Map<Integer, CustomMessage> customMessagesList) {
        this.customMessagesList = customMessagesList;
    }

    public void deleteCustomMessageByID(int customMessageID) {
        customMessagesList.forEach((key, customMessage) -> {
            if (customMessage.getCustomMessageID() == customMessageID) {
                customMessagesList.remove(key);
            }
        });
    }

    public List<CustomMessage> getAllCustomMessagesByGuildID(String guildID) {
        List<CustomMessage> guildCustomMessagesList = new ArrayList<>();
        this.customMessagesList.forEach((key, customMessage) -> {
            if (customMessage.getGuildID().equalsIgnoreCase(guildID)) {
                guildCustomMessagesList.add(customMessage);
            }
        });

        return guildCustomMessagesList;
    }

    public Map<Integer, CustomMessage> getAllCustomMessages() {
        return this.customMessagesList;
    }

    public CustomMessage getCustomMessageByID(int customMessageID) {
        return customMessagesList.get(customMessageID);
    }

    public void addCustomMessageToList(CustomMessage customMessage) {
        this.customMessagesList.put(customMessage.getCustomMessageID(), customMessage);
    }

    // NOTIFIER CHANNELS

    public Map<String, NotifierChannel> notifierChannelsList;

    public void setNotifierChannelsList(Map<String, NotifierChannel> notifierChannelsList) {
        this.notifierChannelsList = notifierChannelsList;
    }

    public boolean isHeadUpMessageOnChannelEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isEventHeadUpEnabled();
    }

    public boolean isEventMessageOnChannelEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isEventMessageEnabled();
    }

    public boolean isAssemblyMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAssemblyMessageEnabled();
    }

    public boolean isRaidVaultMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isRaidVaultMessageEnabled();
    }

    public boolean isDemonGatesMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isDemonGatesMessageEnabled();
    }

    public boolean isDefendVaultMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isDefendVaultMessageEnabled();
    }

    public boolean isAncientArenaMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientArenaMessageEnabled();
    }

    public boolean isShadowLotteryMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isShadowLotteryMessageEnabled();
    }

    public boolean isBattlegroundMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isBattlegroundsMessageEnabled();
    }

    public boolean isHauntedCarriageMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isHauntedCarriageMessageEnabled();
    }

    public boolean isAncientNightmareMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientNightmareMessageEnabled();
    }

    public boolean isDemonGatesEmbedMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isDemonGatesMessageEmbedEnabled();
    }

    public boolean isAncientArenaEmbedMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientArenaMessageEmbedEnabled();
    }

    public boolean isHauntedCarriageEmbedMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isHauntedCarriageMessageEmbedEnabled();
    }

    public boolean isAncientNightmareEmbedMessageEnabled(String textchannelID) {
        return notifierChannelsList.get(textchannelID).isAncientNightmareMessageEmbedEnabled();
    }

    public String getRoleID(String textchannelID) {
        return notifierChannelsList.get(textchannelID).getRoleID();
    }

    public Map<String, NotifierChannel> getListWithNotifierChannels() {
        return notifierChannelsList;
    }

    public String getGuildIdByChannelID(String textchannelID) {
        return notifierChannelsList.get(textchannelID).getGuildID();
    }

    public void addNotifierChannelToList(NotifierChannel notifierChannel) {
        notifierChannelsList.put(notifierChannel.getTextChannelID(), notifierChannel);
    }

    public void setRoleID(String textChannelID, String roleID) {
        notifierChannelsList.get(textChannelID).setRoleID(roleID);
    }

    public void removeNotifierChannelFromList(String textChannelID) {
        notifierChannelsList.remove(textChannelID);
    }

    public void setNotificationsValue(String event, boolean value, String textChannelID) {
        switch (event) {
            case "message":
                notifierChannelsList.get(textChannelID).setEventMessageEnabled(value);
                break;
            case "headup":
                notifierChannelsList.get(textChannelID).setEventHeadUpEnabled(value);
                break;
            case "ancientarena":
                notifierChannelsList.get(textChannelID).setAncientArenaMessageEnabled(value);
                break;
            case "ancientnightmare":
                notifierChannelsList.get(textChannelID).setAncientNightmareMessageEnabled(value);
                break;
            case "assembly":
                notifierChannelsList.get(textChannelID).setAssemblyMessageEnabled(value);
                break;
            case "battlegrounds":
                notifierChannelsList.get(textChannelID).setBattlegroundsMessageEnabled(value);
                break;
            case "defendvault":
                notifierChannelsList.get(textChannelID).setDefendVaultMessageEnabled(value);
                break;
            case "raidvault":
                notifierChannelsList.get(textChannelID).setRaidVaultMessageEnabled(value);
                break;
            case "demongates":
                notifierChannelsList.get(textChannelID).setDemonGatesMessageEnabled(value);
                break;
            case "shadowlottery":
                notifierChannelsList.get(textChannelID).setShadowLotteryMessageEnabled(value);
                break;
            case "hauntedcarriage":
                notifierChannelsList.get(textChannelID).setHauntedCarriageMessageEnabled(value);
                break;
            case "hauntedcarriageembed":
                notifierChannelsList.get(textChannelID).setHauntedCarriageMessageEmbedEnabled(value);
                break;
            case "demongatesembed":
                notifierChannelsList.get(textChannelID).setDemonGatesMessageEmbedEnabled(value);
                break;
            case "ancientnightmareembed":
                notifierChannelsList.get(textChannelID).setAncientNightmareMessageEmbedEnabled(value);
                break;
            case "ancientarenaembed":
                notifierChannelsList.get(textChannelID).setAncientArenaMessageEmbedEnabled(value);
                break;
        }
    }

    public boolean doNotifierChannelExists(String textChannelID) {
        return notifierChannelsList.containsKey(textChannelID);
    }

    // Custom messages create

    //         textChannelID, userID - Waiting for text Channel
    private final Map<String, String> waitingForTextChannel = new ConcurrentHashMap<>();

    public void addToWaitingForTextChannelList(String textChannelID, String userID) {
        waitingForTextChannel.put(textChannelID, userID);
    }

    public void removeFromWaitingForTextChannelList(String textChannelID) {
        waitingForTextChannel.remove(textChannelID);
    }

    public boolean isOperatingUserForChannel(String textChannelID, String userID) {
        if (waitingForTextChannel.get(textChannelID) == null) return false;
        return waitingForTextChannel.get(textChannelID).equals(userID);
    }

    //         textChannelID, userID - Waiting for day
    private final Map<String, String> waitingForDay = new ConcurrentHashMap<>();

    public void addToWaitingForDayList(String textChannelID, String userID) {
        waitingForDay.put(textChannelID, userID);
    }

    public void removeFromWaitingForDayList(String textChannelID) {
        waitingForDay.remove(textChannelID);
    }

    public boolean isOperatingUserForDay(String textChannelID, String userID) {
        if (waitingForDay.get(textChannelID) == null) return false;
        return waitingForDay.get(textChannelID).equals(userID);
    }

    //         textChannelID, userID - Waiting for time
    private final Map<String, String> waitingForTime = new ConcurrentHashMap<>();

    public void addToWaitingForTimeList(String textChannelID, String userID) {
        waitingForTime.put(textChannelID, userID);
    }

    public void removeFromWaitingForTimeList(String textChannelID) {
        waitingForTime.remove(textChannelID);
    }

    public boolean isOperatingUserForTime(String textChannelID, String userID) {
        if (waitingForTime.get(textChannelID) == null) return false;
        return waitingForTime.get(textChannelID).equals(userID);
    }

    //         textChannelID, userID - Waiting for repeating
    private final Map<String, String> waitingForRepeating = new ConcurrentHashMap<>();

    public void addToWaitingForRepeatingList(String textChannelID, String userID) {
        waitingForRepeating.put(textChannelID, userID);
    }

    public void removeFromWaitingForRepeatingList(String textChannelID) {
        waitingForRepeating.remove(textChannelID);
    }

    public boolean isOperatingUserForRepeating(String textChannelID, String userID) {
        if (waitingForRepeating.get(textChannelID) == null) return false;
        return waitingForRepeating.get(textChannelID).equals(userID);
    }

    //         textChannelID, userID - Waiting for message
    private final Map<String, String> waitingForMessage = new ConcurrentHashMap<>();

    public void addToWaitingForMessageList(String textChannelID, String userID) {
        waitingForMessage.put(textChannelID, userID);
    }

    public void removeFromWaitingForMessageList(String textChannelID) {
        waitingForMessage.remove(textChannelID);
    }

    public boolean isOperatingUserForMessage(String textChannelID, String userID) {
        if (waitingForMessage.get(textChannelID) == null) return false;
        return waitingForMessage.get(textChannelID).equals(userID);
    }


    //         textChannelID, cm
    private final Map<String, CustomMessage> preparingCustomMessagesList = new ConcurrentHashMap<>();
    //         textChannelId, userID
    private final Map<String, String> preparingUsersList = new ConcurrentHashMap<>();

    public void addToPreparingCustomMessagesList(String textChannelID, CustomMessage customMessage) {
        preparingCustomMessagesList.put(textChannelID, customMessage);
    }

    public void addToPreparingCustomMessageUserList(String textChannelID, String userID) {
        preparingUsersList.put(textChannelID, userID);
    }

    public void removeFromPreparingCustomMessageUserList(String textChannelID) {
        preparingUsersList.remove(textChannelID);
    }

    public boolean isUserInOperationMode(String textChannelID, String userID) {
        if (preparingUsersList.get(textChannelID) == null) return false;
        return preparingUsersList.get(textChannelID).equals(userID);
    }

    public CustomMessage getPreparingCustomMessage(String textChannelID) {
        return preparingCustomMessagesList.get(textChannelID);
    }

    public void removeFromPreparingCustomMessagesList(String textChannelID) {
        waitingForMessage.remove(textChannelID);
    }

    // -

    private Map<String, Boolean> listWithShadowLotteryTimes;

    public void setListWithShadowLotteryTimes(Map<String, Boolean> listWithShadowLotteryTimes) {
        this.listWithShadowLotteryTimes = listWithShadowLotteryTimes;
    }

    public Map<String, Boolean> getListWithShadowLotteryTimes() {
        return listWithShadowLotteryTimes;
    }

    // -

    private Map<String, Boolean> listWithVaultTimes;

    public Map<String, Boolean> getListWithVaultTimes() {
        return listWithVaultTimes;
    }

    public void setListWithVaultTimes(Map<String, Boolean> listWithRaidTheVautTimes) {
        this.listWithVaultTimes = listWithRaidTheVautTimes;
    }

    // -

    private Map<String, Boolean> listWithHauntedCarriageTimes;

    public Map<String, Boolean> getListWithHauntedCarriageTimes() {
        return listWithHauntedCarriageTimes;
    }

    public void setListWithHauntedCarriageTimes(Map<String, Boolean> listWithHauntedCarriageTimes) {
        this.listWithHauntedCarriageTimes = listWithHauntedCarriageTimes;
    }

    // -

    private Map<String, Boolean> listWithDemonGatesTimes;

    public Map<String, Boolean> getListWithDemonGatesTimes() {
        return listWithDemonGatesTimes;
    }

    public void setListWithDemonGatesTimes(Map<String, Boolean> listWithDemonGatesTimes) {
        this.listWithDemonGatesTimes = listWithDemonGatesTimes;
    }

    // -

    private Map<String, Boolean> listWithBattlegroundTimes;

    public Map<String, Boolean> getListWithBattlegroundTimes() {
        return listWithBattlegroundTimes;
    }

    public void setListWithBattlegroundTimes(Map<String, Boolean> listWithBattlegroundTimes) {
        this.listWithBattlegroundTimes = listWithBattlegroundTimes;
    }

    // -

    private Map<String, Boolean> listWithAssemblyTimes;

    public Map<String, Boolean> getListWithAssemblyTimes() {
        return listWithAssemblyTimes;
    }

    public void setListWithAssemblyTimes(Map<String, Boolean> listWithAssemblyTimes) {
        this.listWithAssemblyTimes = listWithAssemblyTimes;
    }

    // -

    private Map<String, Boolean> listWithAncientNightmareTimes;

    public Map<String, Boolean> getListWithAncientNightmareTimes() {
        return listWithAncientNightmareTimes;
    }

    public void setListWithAncientNightmareTimes(Map<String, Boolean> listWithAncientNightmareTimes) {
        this.listWithAncientNightmareTimes = listWithAncientNightmareTimes;
    }

    // -

    private Map<String, Boolean> listWithAncientAreaTimes;

    public Map<String, Boolean> getListWithAncientAreaTimes() {
        return listWithAncientAreaTimes;
    }

    public void setListWithAncientAreaTimes(Map<String, Boolean> listWithAncientAreaTimes) {
        this.listWithAncientAreaTimes = listWithAncientAreaTimes;
    }

    // - Demon Gates Embed

    private ArrayList<String> listWithDemonGateEmbedTimes;

    public ArrayList<String> getListWithDemonGateEmbedTimes() {
        return listWithDemonGateEmbedTimes;
    }

    public void setListWithDemonGateEmbedTimes(ArrayList<String> listWithDemonGateEmbedTimes) {
        this.listWithDemonGateEmbedTimes = listWithDemonGateEmbedTimes;
    }

    // - Haunted Carriage Embed

    private ArrayList<String> listWithHauntedCarriageEmbedTimes;

    public ArrayList<String> getListWithHauntedCarriageEmbedTimes() {
        return listWithHauntedCarriageEmbedTimes;
    }

    public void setListWithHauntedCarriageEmbedTimes(ArrayList<String> listWithHauntedCarriageEmbedTimes) {
        this.listWithHauntedCarriageEmbedTimes = listWithHauntedCarriageEmbedTimes;
    }

    // - Ancient Nightmare Embed

    private ArrayList<String> listWithAncientNightmareEmbedTimes;

    public ArrayList<String> getListWithAncientNightmareEmbedTimes() {
        return listWithAncientNightmareEmbedTimes;
    }

    public void setListWithAncientNightmareEmbedTimes(ArrayList<String> listWithAncientNightmareEmbedTimes) {
        this.listWithAncientNightmareEmbedTimes = listWithAncientNightmareEmbedTimes;
    }

    // - Ancient Arena Embed

    private ArrayList<String> listWithAncientArenaEmbedTimes;

    public ArrayList<String> getListWithAncientArenaEmbedTimes() {
        return listWithAncientArenaEmbedTimes;
    }

    public void setListWithAncientArenaEmbedTimes(ArrayList<String> listWithAncientArenaEmbedTimes) {
        this.listWithAncientArenaEmbedTimes = listWithAncientArenaEmbedTimes;
    }

    // -

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
        //Todo: add new event

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

    private final List<String> listWithSupportedLanguage = Arrays.asList("ger", "eng", "esp", "fra", "pol", "ita", "rus", "ind");

    public List<String> getListWithSupportedLanguage() {
        return listWithSupportedLanguage;
    }
}
