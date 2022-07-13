package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.gameevents.*;
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
    private final Vault vault;
    private final ClientCache clientCache;
    private final Assembly assembly;
    private final ShadowLottery shadowLottery;
    private final DatabaseRequests databaseRequests;

    public Notifier(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.assembly = new Assembly(databaseRequests);
        this.shadowLottery = new ShadowLottery(databaseRequests);
        this.ancientArea = new AncientArea(databaseRequests);
        this.ancientNightMare = new AncientNightMare(databaseRequests);
        this.battleground = new Battleground(databaseRequests);
        this.demonGates = new DemonGates(databaseRequests);
        this.hauntedCarriage = new HauntedCarriage(databaseRequests);
        this.vault = new Vault(databaseRequests);
        this.databaseRequests = databaseRequests;
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
                        databaseRequests.deleteNotificationChannelEntry(channel);
                        ClientLogger.createNewLogEntry(channel, guildID, ownerID, e.toString());
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

        StringBuilder notificationMessageBuilder = new StringBuilder();

        switch (status) {
            case 0:
                checkForAnyEvent(notificationMessageBuilder, timezone);
                break;
            case 1:
                checkOverworldEvents(notificationMessageBuilder, timezone);
                break;
            case 2:
                checkImmortalEvents(notificationMessageBuilder, timezone);
                break;
            case 3:
                checkShadowEvents(notificationMessageBuilder, timezone);
                break;
            case 4:
                checkImmortalWithOverworldEvents(notificationMessageBuilder, timezone);
                break;
            case 5:
                checkShadowWithOverworldEvents(notificationMessageBuilder, timezone);
                break;
            case 9:
              //Todo: Overworld Embed Messages
            break;
        }

        if (notificationMessageBuilder.length() > 0) {
            addMention(notificationMessageBuilder, channelID, textChannel.getGuild());
            addDebugMessageIfInMode(channelID, timezone, notificationMessageBuilder);
            textChannel.sendMessage(notificationMessageBuilder.toString()).queue();
        }

        return guildInfo;
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

    private void checkShadowWithOverworldEvents(StringBuilder notificationMessageBuilder, String timezone) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone));
        notificationMessageBuilder.append(vault.checkVault(timezone));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone));
    }

    private void checkImmortalWithOverworldEvents(StringBuilder notificationMessageBuilder, String timezone) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone));
        notificationMessageBuilder.append(vault.checkVault(timezone));
    }

    private void checkShadowEvents(StringBuilder notificationMessageBuilder, String timezone) {
        notificationMessageBuilder.append(vault.checkVault(timezone));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone));
    }

    private void checkImmortalEvents(StringBuilder notificationMessageBuilder, String timezone) {
        notificationMessageBuilder.append(vault.checkVault(timezone));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone));
    }

    private void checkOverworldEvents(StringBuilder notificationMessageBuilder, String timezone) {
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone));
    }

    private void checkForAnyEvent(StringBuilder notificationMessageBuilder, String timezone) {
        notificationMessageBuilder.append(vault.checkVault(timezone));
        notificationMessageBuilder.append(battleground.checkBattleground(timezone));
        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timezone));
        notificationMessageBuilder.append(demonGates.checkDemonGates(timezone));
        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timezone));
        notificationMessageBuilder.append(ancientArea.checkAncientArea(timezone));
        notificationMessageBuilder.append(assembly.checkAssembly(timezone));
        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timezone));
    }

    private void setActivity(JDA jda) {
        int counter = jda.getGuilds().size();
        jda.getPresence().setActivity(Activity.playing("Diablo Immortal (" + counter + ")"));
    }

}
