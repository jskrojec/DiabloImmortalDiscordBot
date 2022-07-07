package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.Client;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.JDA;
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
    private final WeeklyReset weeklyReset;
    private final Assembly assembly;
    private final ShadowLottery shadowLottery;

    public Notifier(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.assembly = new Assembly(databaseRequests, clientConfig, clientCache);
        this.shadowLottery = new ShadowLottery(databaseRequests, clientConfig, clientCache);
        this.ancientArea = new AncientArea(databaseRequests, clientConfig, clientCache);
        this.weeklyReset = new WeeklyReset(databaseRequests, clientConfig, clientCache);
        this.ancientNightMare = new AncientNightMare(databaseRequests, clientConfig, clientCache);
        this.battleground = new Battleground(databaseRequests, clientConfig, clientCache);
        this.demonGates = new DemonGates(databaseRequests, clientConfig, clientCache);
        this.hauntedCarriage = new HauntedCarriage(databaseRequests, clientConfig, clientCache);
        this.vault = new Vault(databaseRequests, clientConfig, clientCache);
    }

    public void runNotifierScheduler(JDA jda) {

        new Timer().schedule(new TimerTask() {
            public void run() {

                for (String channel : clientCache.getListWithNotificationChannels().keySet()) {
                    try {
                        TextChannel textChannel = jda.getTextChannelById(channel);
                        String timezone = clientCache.getTimezone(channel);

                        if (textChannel != null) {
                            switch (clientCache.getStatus(textChannel.getId())) {
                                case 0: //ALL MESSAGES
                                    vault.checkVault(textChannel, timezone);
                                    battleground.checkBattleground(textChannel, timezone);
                                    ancientNightMare.checkAncientNightMare(textChannel, timezone);
                                    demonGates.checkDemonGates(textChannel, timezone);
                                    hauntedCarriage.checkHauntedCarriage(textChannel, timezone);
                                    ancientArea.checkAncientArea(textChannel, timezone);
                                    weeklyReset.checkIfResetted(textChannel, timezone);
                                    assembly.checkAssembly(textChannel, timezone);
                                    shadowLottery.checkShadowLottery(textChannel, timezone);
                                    break;
                                case 1: //ONLY OVERWORLD
                                    ancientNightMare.checkAncientNightMare(textChannel, timezone);
                                    demonGates.checkDemonGates(textChannel, timezone);
                                    hauntedCarriage.checkHauntedCarriage(textChannel, timezone);
                                    ancientArea.checkAncientArea(textChannel, timezone);
                                    battleground.checkBattleground(textChannel, timezone);
                                    break;
                                case 2: //ONLY IMMPORTAL
                                    vault.checkVault(textChannel, timezone);
                                    battleground.checkBattleground(textChannel, timezone);
                                    break;
                                case 3: //ONLY SHADOW
                                    vault.checkVault(textChannel, timezone);
                                    assembly.checkAssembly(textChannel, timezone);
                                    shadowLottery.checkShadowLottery(textChannel, timezone);
                                    battleground.checkBattleground(textChannel, timezone);
                                    break;
                                case 4: //IMMORTAL WITH OVERWORLD
                                    ancientNightMare.checkAncientNightMare(textChannel, timezone);
                                    demonGates.checkDemonGates(textChannel, timezone);
                                    hauntedCarriage.checkHauntedCarriage(textChannel, timezone);
                                    ancientArea.checkAncientArea(textChannel, timezone);
                                    battleground.checkBattleground(textChannel, timezone);
                                    vault.checkVault(textChannel, timezone);
                                    break;
                                case 5: //SHADOW WITH OVERWORLD
                                    ancientNightMare.checkAncientNightMare(textChannel, timezone);
                                    demonGates.checkDemonGates(textChannel, timezone);
                                    hauntedCarriage.checkHauntedCarriage(textChannel, timezone);
                                    ancientArea.checkAncientArea(textChannel, timezone);
                                    battleground.checkBattleground(textChannel, timezone);
                                    vault.checkVault(textChannel, timezone);
                                    assembly.checkAssembly(textChannel, timezone);
                                    shadowLottery.checkShadowLottery(textChannel, timezone);
                                    break;
                            }
                        }

                    } catch (NullPointerException e) {
                        ClientLogger.createNewLogEntry(e.getMessage());
                    }

                }

            }
        }, 0, 60 * 1000); //every minute
    }
}
