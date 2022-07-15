package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.io.PrintWriter;
import java.io.StringWriter;
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

    private int debugMessageCountdown = 0;

    public Notifier(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.assembly = new Assembly(databaseRequests);
        this.shadowLottery = new ShadowLottery(databaseRequests);
        this.ancientArea = new AncientArea(databaseRequests);
        this.ancientNightMare = new AncientNightMare(databaseRequests);
        this.battleground = new Battleground(databaseRequests);
        this.demonGates = new DemonGates(databaseRequests);
        this.hauntedCarriage = new HauntedCarriage(databaseRequests);
        this.raidVault = new RaidVault(databaseRequests);
        this.databaseRequests = databaseRequests;
        this.defendVault = new DefendVault(databaseRequests);
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
                            String[] guildInfo = sendMessageIfPossible(textChannel);

                            guildID = guildInfo[0];
                            ownerID = guildInfo[1];
                        }

                    } catch (Exception e) {
                        StringWriter sw = new StringWriter();
                        PrintWriter pw = new PrintWriter(sw);
                        e.printStackTrace(pw);
                        databaseRequests.deleteNotificationChannelEntry(channel);
                        ClientLogger.createNewLogEntry(channel, guildID, ownerID, String.valueOf(pw));
                    }
                }
            }
        }, 0, 60 * 1000);
    }

    private String[] sendMessageIfPossible(TextChannel textChannel) {
        String[] guildInfo = new String[2];

        String channelID = textChannel.getId();
        String timezone = clientCache.getTimezone(channelID);
        int status = clientCache.getStatus(textChannel.getId());
        Guild guild = textChannel.getGuild();
        guildInfo[0] = guild.getId();
        guildInfo[1] = guild.getOwnerId();
        String language = clientCache.getLanguage(guildInfo[0]);


        registerGuildIfNotExists(guildInfo[0], timezone);

        StringBuilder notificationMessageBuilder = new StringBuilder();

        switch (status) {
            case 0:
                checkForAnyEvent(notificationMessageBuilder, timezone, language);
                break;
            case 1:
                checkOverworldEvents(notificationMessageBuilder, timezone, language);
                break;
            case 2:
                checkImmortalEvents(notificationMessageBuilder, timezone, language);
                break;
            case 3:
                checkShadowEvents(notificationMessageBuilder, timezone, language);
                break;
            case 4:
                checkImmortalWithOverworldEvents(notificationMessageBuilder, timezone, language);
                break;
            case 5:
                checkShadowWithOverworldEvents(notificationMessageBuilder, timezone, language);
                break;
            case 9:
                checkForOverworldEvents(timezone, textChannel);
                break;
            case 128:
                debugMessageCountdown++;
                if (debugMessageCountdown == 30) {
                    debugMessageCountdown = 0;
                    String debugMessage = "Current time: " + Time.getTimeWithWeekday(timezone) + " in timezone " + timezone + ".";
                    textChannel.sendMessage(debugMessage).queue();
                }
                break;
        }

        if (notificationMessageBuilder.length() > 0) {
            addMention(notificationMessageBuilder, channelID, textChannel.getGuild());
            addDebugMessageIfInMode(channelID, timezone, notificationMessageBuilder);
            textChannel.sendMessage(notificationMessageBuilder.toString()).queue();
        }

        return guildInfo;
    }

    private void registerGuildIfNotExists(String guildID, String timezone) {

        if (clientCache.doGuildExists(guildID)) {
            return;
        }

        GuildInformation guildInformation = new GuildInformation(guildID, "ENG", timezone);

        databaseRequests.createNewGuildEntry(guildInformation);
        clientCache.addGuildInformation(guildInformation);
    }


    private void addMention(StringBuilder stringBuilder, String channelId, Guild guild) {
        String roleId = clientCache.getMentionRoleID(channelId);

        String everyoneMention = "@everyone";
        String hereMention = "@here";
        String mention = everyoneMention;

        if (roleId.equalsIgnoreCase(hereMention)) {
            mention = hereMention;
        }

        try {
            if (!roleId.isBlank()) {
                mention = guild.getRoleById(roleId).getAsMention();
            }
        } catch (NullPointerException ignore) {
            //If this exception happens, no role was set.
        }

        stringBuilder.append(mention);
    }

    private void addDebugMessageIfInMode(String channel, String timezone, StringBuilder notificationMessageBuilder) {
        if (clientCache.isChannelInDebugMode(channel)) {
            String message =
                    "\n\nCT: " + Time.getTimeWithWeekday(timezone) + "\n" +
                            "ACT: " + Time.getTimeWithWeekday("GMT+2") + " \n" +
                            "TZ: " + timezone;
            notificationMessageBuilder.append(message);
        }
    }

    private void checkShadowWithOverworldEvents(StringBuilder notificationMessageBuilder, String timezone, String language) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language));
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language));
    }

    private void checkImmortalWithOverworldEvents(StringBuilder notificationMessageBuilder, String timezone, String language) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language));
        notificationMessageBuilder.append(defendVault.checkDefendVault(timezone, language));
    }

    private void checkShadowEvents(StringBuilder notificationMessageBuilder, String timezone, String language) {
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language));
    }

    private void checkImmortalEvents(StringBuilder notificationMessageBuilder, String timezone, String language) {
        notificationMessageBuilder.append(defendVault.checkDefendVault(timezone, language));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language));
    }

    private void checkOverworldEvents(StringBuilder notificationMessageBuilder, String timezone, String language) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language));
    }

    private void checkForAnyEvent(StringBuilder notificationMessageBuilder, String timezone, String language) {
        notificationMessageBuilder.append(raidVault.checkVault(timezone, language));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone, language));
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone, language));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone, language));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone, language));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone, language));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone, language));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone, language));
    }

    private void checkForOverworldEvents(String timezone, TextChannel textChannel) {
        textChannel.sendMessageEmbeds(ancientArea.checkAncientArenaFormatted(timezone)).queue();
        textChannel.sendMessageEmbeds(ancientNightMare.checkAncientNightMareFormatted(timezone)).queue();
        textChannel.sendMessageEmbeds(demonGates.checkHauntedCarriageFormatted(timezone)).queue();
        textChannel.sendMessageEmbeds(hauntedCarriage.checkHauntedCarriageFormatted(timezone)).queue();
    }

    private void setActivity(JDA jda) {
        int counter = jda.getGuilds().size();
        jda.getPresence().setActivity(Activity.playing("Diablo Immortal (" + counter + ")"));
    }

}
