package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.GuildInformation;

import java.util.Map;

public class GuildsCache {

    // GUILDS CACHE

    public Map<String, GuildInformation> listWithGuildInformation;

    public boolean isAutoDeleteEnabled(final String guildID) {
        return listWithGuildInformation.get(guildID).isAutoDeleteEnabled();
    }

    public void setAutoDeleteBoolValue(final String guildID, final boolean bool) {
        listWithGuildInformation.get(guildID).setAutoDeleteEnabled(bool);
    }

    public int getAutoDeleteValue(final String guildID) {
        return listWithGuildInformation.get(guildID).getAutoDeleteValue();
    }

    public void setAutoDeleteIntValue(final String guildID, final int i) {
        listWithGuildInformation.get(guildID).setAutoDeleteValue(i);
    }

    public void setListWithGuildInformation(final Map<String, GuildInformation> listWithGuildInformation) {
        this.listWithGuildInformation = listWithGuildInformation;
    }

    public String getGuildLanguage(final String guildID) {
        String language;
        try {
            language = listWithGuildInformation.get(guildID).getLanguage();
        } catch (final NullPointerException e) {
            language = "ENG";
        }
        return language;
    }

    public void setGuildTimeZone(final String guildID, final String guildTimeZone) {
        listWithGuildInformation.get(guildID).setTimezone(guildTimeZone);
    }

    public GuildInformation getGuildInformation(final String guildID) {
        return listWithGuildInformation.get(guildID);
    }

    public String getGuildTimeZone(final String guildID) {
        return listWithGuildInformation.get(guildID).getTimezone();
    }

    public void setGuildLanguage(final String guildID, final String language) {
        listWithGuildInformation.get(guildID).setLanguage(language);
    }

    public boolean doGuildExists(final String guildID) {
        return listWithGuildInformation.containsKey(guildID);
    }

    public void addGuildInformation(final GuildInformation guildInformation) {
        this.listWithGuildInformation.put(guildInformation.getGuildID(), guildInformation);
    }

    public boolean isHeadUpOnServerEnabled(final String guildID) {
        return listWithGuildInformation.get(guildID).isHeadUpEnabled();
    }

    public void setHeadUpOnServerValue(final String guildID, final boolean value) {
        listWithGuildInformation.get(guildID).setHeadUpEnabled(value);
    }

    public boolean isEventMessageOnServerEnabled(final String guildID) {
        return listWithGuildInformation.get(guildID).isEventMessageEnabled();
    }

    public void setEventMessageOnServerValue(final String guildID, final boolean value) {
        listWithGuildInformation.get(guildID).setEventMessageEnabled(value);
    }



}
