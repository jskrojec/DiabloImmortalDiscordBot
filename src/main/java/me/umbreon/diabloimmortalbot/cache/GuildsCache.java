package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.GuildInformation;

import java.util.Map;

/**
 * @author Umbreon Majora
 * <p>
 * System cache for registered guilds.
 */
public class GuildsCache {

    public Map<String, GuildInformation> listWithGuildInformation;

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

}
