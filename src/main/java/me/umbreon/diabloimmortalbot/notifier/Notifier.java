package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds.AncientArenaEmbed;
import me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds.AncientNightmareEmbed;
import me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds.DemonGatesEmbed;
import me.umbreon.diabloimmortalbot.gameevents.OverworldEmbeds.HauntedCarriageEmbed;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Timer;
import java.util.TimerTask;

public class Notifier {

    private final AncientArea ancientArea;
    private final AncientNightMare ancientNightMare;
    private final Battleground battleground;
    private final DemonGates demonGates;
    private final HauntedCarriage hauntedCarriage;
    private final RaidVault raidVault;
    private final ClientCache clientCache;
    private final Assembly assembly;
    private final ShadowLottery shadowLottery;
    private final DatabaseRequests databaseRequests;
    private final DefendVault defendVault;

    //Overworld Embed Notifications
    private final AncientNightmareEmbed ancientNightmareEmbed;
    private final AncientArenaEmbed ancientArenaEmbed;
    private final DemonGatesEmbed demonGatesEmbed;
    private final HauntedCarriageEmbed hauntedCarriageEmbed;

    private int debugMessageCountdown = 0;

    public Notifier(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.assembly = new Assembly(databaseRequests, clientCache);
        this.shadowLottery = new ShadowLottery(databaseRequests, clientCache);
        this.ancientArea = new AncientArea(databaseRequests, clientCache);
        this.ancientNightMare = new AncientNightMare(databaseRequests, clientCache);
        this.battleground = new Battleground(databaseRequests, clientCache);
        this.demonGates = new DemonGates(databaseRequests, clientCache);
        this.hauntedCarriage = new HauntedCarriage(databaseRequests, clientCache);
        this.raidVault = new RaidVault(databaseRequests, clientCache);
        this.databaseRequests = databaseRequests;
        this.defendVault = new DefendVault(databaseRequests, clientCache);

        this.ancientNightmareEmbed = new AncientNightmareEmbed(databaseRequests);
        this.ancientArenaEmbed = new AncientArenaEmbed(databaseRequests);
        this.demonGatesEmbed = new DemonGatesEmbed(databaseRequests);
        this.hauntedCarriageEmbed = new HauntedCarriageEmbed(databaseRequests);
    }

    public void runNotifierScheduler(JDA jda) {

        new Timer().schedule(new TimerTask() {
            public void run() {

                setActivity(jda);

                String guildID = "0";
                String ownerID = "0";

                for (String channel : clientCache.getListWithNotificationChannels().keySet()) {
                    try {
                        TextChannel textChannel = jda.getTextChannelById(channel);

                        if (textChannel != null) {

                            guildID = textChannel.getGuild().getId();
                            String timezone = clientCache.getTimezone(channel);
                            registerGuildIfDoNotExists(guildID);

                            String fullTimeWithWeekday = Time.getTimeWithWeekday(timezone);

                            if (fullTimeWithWeekday.equalsIgnoreCase("INVALID_TIMEZONE")) {
                                textChannel.getGuild().getOwner().getUser().openPrivateChannel().queue(privateChannel -> {
                                    privateChannel.sendMessage("You're using an invalid timezone on your server " +
                                            textChannel.getGuild().getName() + ". Known working timezones are GMT, UTC and ET.").queue();
                                });
                                textChannel.sendMessage("Unknown Timezone. Known timezones are UTC, GMT & ET.").queue();
                                return;
                            }

                            sendMessageIfPossible(textChannel);
                        }

                    } catch (Exception e) {
                        ClientLogger.createNewErrorLogEntry(e);
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 60 * 1000);
    }

    private void registerGuildIfDoNotExists(String guildID) {
        try {
            if (!clientCache.doGuildExists(guildID)) {
                String language = "ENG";
                GuildInformation guildInformation = new GuildInformation(guildID, language, true, true, true);
                databaseRequests.createNewGuildEntry(guildInformation);
                clientCache.addGuildInformation(guildInformation);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void sendMessageIfPossible(TextChannel textChannel) {
        String channelID = textChannel.getId();
        String timezone = clientCache.getTimezone(channelID);
        int status = clientCache.getStatus(textChannel.getId());
        Guild guild = textChannel.getGuild();
        String guildID = guild.getId();
        String language = clientCache.getLanguage(guildID);

        StringBuilder notificationMessageBuilder = new StringBuilder();

        switch (status) {
            case 0:
                checkForAnyEvent(notificationMessageBuilder, timezone, language, guildID);
                break;
            case 1:
                checkOverworldEvents(notificationMessageBuilder, timezone, language, guildID);
                break;
            case 2:
                checkImmortalEvents(notificationMessageBuilder, timezone, language, guildID);
                break;
            case 3:
                checkShadowEvents(notificationMessageBuilder, timezone, language, guildID);
                break;
            case 4:
                checkImmortalWithOverworldEvents(notificationMessageBuilder, timezone, language, guildID);
                break;
            case 5:
                checkShadowWithOverworldEvents(notificationMessageBuilder, timezone, language, guildID);
                break;
            case 7:
                checkImmortalWithOverworldEmbededEvents(notificationMessageBuilder, timezone, language, guildID, textChannel);
                break;
            case 8:
                checkShadowWithOverworldEmbededEvents(notificationMessageBuilder, timezone, language, guildID, textChannel);
                break;
            case 9:
                checkForOverworldEvents(timezone, textChannel, language);
                break;
            case 128:
                debugMessageCountdown++;
                if (debugMessageCountdown == 1) {
                    debugMessageCountdown = 0;
                    String debugMessage = "Current time: " + Time.getTimeWithWeekday(timezone) + " in timezone " + timezone + "." +
                            "\nBattlegrounds: " + clientCache.isBattlegroundsNotificationsEnabled(guildID) +
                            "\nEvent Messages: " + clientCache.isEventMessageEnabled(guildID) +
                            "\nHeadUp Messages:" + clientCache.getHeadUpValue(guildID) + "\n";
                    notificationMessageBuilder.append(debugMessage);
                }
                break;
        }

        if (notificationMessageBuilder.length() > 0) {
            addMention(notificationMessageBuilder, channelID, textChannel.getGuild());
            textChannel.sendMessage(notificationMessageBuilder.toString()).queue();
        }
    }


    private void addMention(StringBuilder stringBuilder, String channelId, Guild guild) {
        String mention;
        String everyoneMention = "@everyone";
        try {
            mention = clientCache.getMentionRoleID(channelId);
        } catch (NullPointerException exception) {
            mention = everyoneMention;
        }

        if (mention == null) {
            mention = everyoneMention;
        }

        String hereMention = "@here";

        if (mention.equalsIgnoreCase(hereMention)) {
            mention = hereMention;
            stringBuilder.append(mention);
            return;
        }

        try {
            if (guild.getRoleById(mention) == null) {
                mention = everyoneMention;
            } else {
                mention = guild.getRoleById(mention).getAsMention();
            }
        } catch (NumberFormatException e) {
            mention = everyoneMention;
        }

        stringBuilder.append(mention);

    }


    private void checkShadowWithOverworldEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language, guildID));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language, guildID));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language, guildID));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language, guildID));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language, guildID));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language, guildID));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language, guildID));
    }

    private void checkImmortalWithOverworldEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language, guildID));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language, guildID));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language, guildID));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language, guildID));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
        notificationMessageBuilder.append(defendVault.checkDefendVault(timezone, language, guildID));
    }

    private void checkShadowEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID) {
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language, guildID));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language, guildID));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language, guildID));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
    }

    private void checkImmortalEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID) {
        notificationMessageBuilder.append(defendVault.checkDefendVault(timezone, language, guildID));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
    }

    private void checkOverworldEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language, guildID));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language, guildID));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language, guildID));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language, guildID));

        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
    }

    private void checkForAnyEvent(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID) {
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language, guildID));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));

        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language, guildID));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language, guildID));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language, guildID));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language, guildID));

        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language, guildID));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language, guildID));
    }

    private void checkForOverworldEvents(String timezone, TextChannel textChannel, String language) {
        ancientArenaEmbed.checkAncientArenaFormatted(textChannel, timezone, language);
        ancientNightmareEmbed.checkAncientNightmareFormatted(textChannel, timezone, language);
        demonGatesEmbed.checkDemonGatesFormatted(textChannel, timezone, language);
        hauntedCarriageEmbed.checkHauntedCarriageFormatted(textChannel ,timezone, language);
    }

    private void checkShadowWithOverworldEmbededEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID, TextChannel textChannel) {
        ancientArenaEmbed.checkAncientArenaFormatted(textChannel, timezone, language);
        ancientNightmareEmbed.checkAncientNightmareFormatted(textChannel, timezone, language);
        demonGatesEmbed.checkDemonGatesFormatted(textChannel, timezone, language);
        hauntedCarriageEmbed.checkHauntedCarriageFormatted(textChannel ,timezone, language);
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language, guildID));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language, guildID));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language, guildID));
    }

    private void checkImmortalWithOverworldEmbededEvents(StringBuilder notificationMessageBuilder, String timezone, String language, String guildID, TextChannel textChannel) {
        ancientArenaEmbed.checkAncientArenaFormatted(textChannel, timezone, language);
        ancientNightmareEmbed.checkAncientNightmareFormatted(textChannel, timezone, language);
        demonGatesEmbed.checkDemonGatesFormatted(textChannel, timezone, language);
        hauntedCarriageEmbed.checkHauntedCarriageFormatted(textChannel ,timezone, language);
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language, guildID));
        notificationMessageBuilder.append(defendVault.checkDefendVault(timezone, language, guildID));
    }

    private void setActivity(JDA jda) {
        int counter = jda.getGuilds().size();
        jda.getPresence().setActivity(Activity.playing("Diablo Immortal (" + counter + ")"));
    }

}
