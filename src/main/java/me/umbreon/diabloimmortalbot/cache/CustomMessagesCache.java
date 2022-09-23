package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.CustomMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomMessagesCache {

    // CUSTOM MESSAGES CACHE

    private Map<Integer, CustomMessage> customMessagesList;

    public void setCustomMessagesList(final Map<Integer, CustomMessage> customMessagesList) {
        this.customMessagesList = customMessagesList;
    }

    public void deleteCustomMessageByID(final int customMessageID) {
        customMessagesList.forEach((key, customMessage) -> {
            if (customMessage.getCustomMessageID() == customMessageID) {
                customMessagesList.remove(key);
            }
        });
    }

    public List<CustomMessage> getAllCustomMessagesByGuildID(final String guildID) {
        final List<CustomMessage> guildCustomMessagesList = new ArrayList<>();
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

    public CustomMessage getCustomMessageByID(final int customMessageID) {
        return customMessagesList.get(customMessageID);
    }

    public void addCustomMessageToList(final CustomMessage customMessage) {
        this.customMessagesList.put(customMessage.getCustomMessageID(), customMessage);
    }

}
