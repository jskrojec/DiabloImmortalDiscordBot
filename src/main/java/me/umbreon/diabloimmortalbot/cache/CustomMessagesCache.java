package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.CustomMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Umbreon Majora
 * <p>
 * System cache for custom messages.
 */
public class CustomMessagesCache {

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
        customMessagesList.forEach((key, customMessage) -> {
            if (customMessage.getGuildID().equalsIgnoreCase(guildID)) {
                guildCustomMessagesList.add(customMessage);
            }
        });
        return guildCustomMessagesList;
    }

    public Map<Integer, CustomMessage> getAllCustomMessages() {
        return customMessagesList;
    }

    public CustomMessage getCustomMessageByID(int customMessageID) {
        return customMessagesList.get(customMessageID);
    }

    //FIXME: Not in use because the database gives the ID's
    public void addCustomMessageToList(CustomMessage customMessage) {
        this.customMessagesList.put(customMessage.getCustomMessageID(), customMessage);
    }

}
