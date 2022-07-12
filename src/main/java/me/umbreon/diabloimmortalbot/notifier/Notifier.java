package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.utils.*;
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

    int counter = 0;

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
    }

    public void runNotifierScheduler(JDA jda) {

        new Timer().schedule(new TimerTask() {
            public void run() {

                setActivity(jda);

                for (String channel : clientCache.getListWithNotificationChannels().keySet()) {
                    try {
                        TextChannel textChannel = jda.getTextChannelById(channel);

                        if (textChannel != null) {
                            //If the textChannel is null, the channel got deleted or bot isn't on that server anymore.
                            String timezone = clientCache.getTimezone(channel);
                            StringBuilder notificationMessageBuilder = new StringBuilder();

                            switch (clientCache.getStatus(textChannel.getId())) {
                                case 0: //ALL MESSAGES
                                    checkForAnyEvent(notificationMessageBuilder, timezone);
                                    break;
                                case 1: //ONLY OVERWORLD
                                    checkOverworldEvents(notificationMessageBuilder, timezone);
                                    break;
                                case 2: //ONLY IMMPORTAL
                                    checkImmortalEvents(notificationMessageBuilder, timezone);
                                    break;
                                case 3: //ONLY SHADOW
                                    checkShadowEvents(notificationMessageBuilder, timezone);
                                    break;
                                case 4: //IMMORTAL WITH OVERWORLD
                                    checkImmortalWithOverworldEvents(notificationMessageBuilder, timezone);
                                    break;
                                case 5: //SHADOW WITH OVERWORLD
                                    checkShadowWithOverworldEvents(notificationMessageBuilder, timezone);
                                    break;
                                case 128:
                                    counter++;
                                    if (counter == 15) {
                                        counter = 0;
                                        notificationMessageBuilder.append("Time: ").append(Time.getTimeWithWeekday(timezone))
                                                .append(" TimeZone: ").append(timezone);
                                    }
                            }

                            if (notificationMessageBuilder.length() > 0) {
                                addMention(notificationMessageBuilder ,channel, textChannel.getGuild());
                                addDebugMessageIfInMode(channel, timezone, notificationMessageBuilder);
                                textChannel.sendMessage(notificationMessageBuilder.toString()).queue();
                                createLogInfo(notificationMessageBuilder, textChannel, timezone);
                            }
                        }
                    } catch (Exception e) {
                        ClientLogger.createNewLogEntry(e.getMessage());
                    }
                }
            }
        }, 0, 60 * 1000);
    }

    private void addMention(StringBuilder stringBuilder, String channelId, Guild guild) {
        String roleId = clientCache.getMentionRoleID(channelId);
        String mention = "@everyone";

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

    private void createLogInfo(StringBuilder notificationMessageBuilder, TextChannel textChannel, String timezone) {
        String logInfoMessage = "Sended Message to " + textChannel.getGuild().getName() + ".\n" +
                notificationMessageBuilder + "\nID: " + textChannel.getGuild().getId() + "\n" +
                "Timezone: " + timezone + ", Time: " + Time.getTimeWithWeekday(timezone);
        ClientLogger.createNewLogEntry(logInfoMessage);
    }

    private void setActivity(JDA jda) {
        int counter = jda.getGuilds().size();
        jda.getPresence().setActivity(Activity.playing("Diablo Immortal (" + counter + ")"));
    }

}
