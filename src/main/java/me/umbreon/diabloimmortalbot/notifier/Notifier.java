package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientArenaEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientNightmareEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.DemonGatesEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.HauntedCarriageEmbed;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Notifier {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    private final AncientArena ancientArena;
    private final AncientNightMare ancientNightMare;
    private final Battleground battleground;
    private final DemonGates demonGates;
    private final HauntedCarriage hauntedCarriage;
    private final RaidVault raidVault;
    private final Assembly assembly;
    private final ShadowLottery shadowLottery;
    private final DefendVault defendVault;

    //Overworld Embed Notifications
    private final AncientNightmareEmbed ancientNightmareEmbed;
    private final AncientArenaEmbed ancientArenaEmbed;
    private final DemonGatesEmbed demonGatesEmbed;
    private final HauntedCarriageEmbed hauntedCarriageEmbed;

    public Notifier(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;

        this.assembly = new Assembly(clientCache);
        this.shadowLottery = new ShadowLottery(clientCache);
        this.ancientArena = new AncientArena(clientCache);
        this.ancientNightMare = new AncientNightMare(clientCache);
        this.battleground = new Battleground(clientCache);
        this.demonGates = new DemonGates(clientCache);
        this.hauntedCarriage = new HauntedCarriage(clientCache);
        this.raidVault = new RaidVault(clientCache);
        this.defendVault = new DefendVault(clientCache);

        this.ancientNightmareEmbed = new AncientNightmareEmbed(clientCache);
        this.ancientArenaEmbed = new AncientArenaEmbed(clientCache);
        this.demonGatesEmbed = new DemonGatesEmbed(clientCache);
        this.hauntedCarriageEmbed = new HauntedCarriageEmbed(clientCache);
    }

    public void runScheduler(JDA jda) {
        Date date = Calendar.getInstance().getTime();
        date.setMinutes(date.getMinutes() + 1);
        date.setSeconds(0);

        new Timer().schedule(new TimerTask() {
            public void run() {
                setActivity(jda);
                if (clientCache.getListWithNotifierChannels().size() == 0) return;
                clientCache.getListWithNotifierChannels().forEach((textChannelID, notifierChannel) -> {
                    TextChannel textChannel = jda.getTextChannelById(textChannelID);

                    String guildID = clientCache.getGuildIdByChannelID(textChannelID);
                    String timeZone = clientCache.getGuildTimeZone(guildID);
                    String guildLanguage = clientCache.getGuildLanguage(guildID);

                    StringBuilder notificationMessageBuilder = new StringBuilder();

                    if (clientCache.isRaidVaultMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(raidVault.checkVault(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isBattlegroundMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(battleground.checkBattleground(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isAncientNightmareMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(ancientNightMare.checkAncientNightMare(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isDemonGatesMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(demonGates.checkDemonGates(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isHauntedCarriageMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(hauntedCarriage.checkHauntedCarriage(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isAncientArenaMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(ancientArena.checkAncientArea(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isAssemblyMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(assembly.checkAssembly(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isShadowLotteryMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(shadowLottery.checkShadowLottery(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    if (clientCache.isDefendVaultMessageEnabled(textChannelID)) {
                        notificationMessageBuilder.append(defendVault.checkDefendVault(timeZone, guildLanguage, guildID, textChannelID));
                    }

                    //Embeds
                    if (clientCache.isAncientArenaEmbedMessageEnabled(textChannelID)) {
                        ancientArenaEmbed.checkAncientArenaFormatted(textChannel, timeZone, guildLanguage);
                    }

                    if (clientCache.isAncientNightmareEmbedMessageEnabled(textChannelID)) {
                        ancientNightmareEmbed.checkAncientNightmareFormatted(textChannel, timeZone, guildLanguage);
                    }

                    if (clientCache.isDemonGatesEmbedMessageEnabled(textChannelID)) {
                        demonGatesEmbed.checkDemonGatesFormatted(textChannel, timeZone, guildLanguage);
                    }

                    if (clientCache.isHauntedCarriageEmbedMessageEnabled(textChannelID)) {
                        hauntedCarriageEmbed.checkHauntedCarriageFormatted(textChannel, timeZone, guildLanguage);
                    }

                    if (notificationMessageBuilder.length() > 0) {
                        addMentionToMessage(notificationMessageBuilder, textChannel);
                        textChannel.sendMessage(notificationMessageBuilder.toString()).queue();
                    }
                });
            }
        }, date, 60 * 1000);
    }

    private void addMentionToMessage(StringBuilder stringBuilder, TextChannel textChannel) {
        String mention;
        String textChannelID = textChannel.getId();
        switch (clientCache.getRoleID(textChannelID)) {
            case "EVERYONE":
                mention = "@everyone";
                break;
            case "HERE":
                mention = "@here";
                break;
            default:
                mention = textChannel.getJDA().getRoleById(clientCache.getRoleID(textChannelID)).getAsMention();
                break;
        }

        stringBuilder.append(mention);
    }

    private void setActivity(JDA jda) {
        int counter = jda.getGuilds().size();
        jda.getPresence().setActivity(Activity.playing("Diablo Immortal (" + counter + ")"));
    }

}
