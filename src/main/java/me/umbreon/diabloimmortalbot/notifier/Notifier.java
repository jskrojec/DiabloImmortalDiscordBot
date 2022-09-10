package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientArenaEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientNightmareEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.DemonGatesEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.HauntedCarriageEmbed;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.TimeAssistant;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Notifier {

    private final ClientCache clientCache;

    //Normal Notifications
    private final AncientArena ancientArena;
    private final AncientNightMare ancientNightMare;
    private final Battleground battleground;
    private final DemonGates demonGates;
    private final HauntedCarriage hauntedCarriage;
    private final RaidVault raidVault;
    private final Assembly assembly;
    private final ShadowLottery shadowLottery;
    private final DefendVault defendVault;
    private final WrathborneInvasion wrathborneInvasion;

    //Overworld Embed Notifications
    private final AncientNightmareEmbed ancientNightmareEmbed;
    private final AncientArenaEmbed ancientArenaEmbed;
    private final DemonGatesEmbed demonGatesEmbed;
    private final HauntedCarriageEmbed hauntedCarriageEmbed;

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public Notifier(final ClientCache clientCache) {
        this.clientCache = clientCache;

        this.assembly = new Assembly(clientCache);
        this.shadowLottery = new ShadowLottery(clientCache);
        this.ancientArena = new AncientArena(clientCache);
        this.ancientNightMare = new AncientNightMare(clientCache);
        this.battleground = new Battleground(clientCache);
        this.demonGates = new DemonGates(clientCache);
        this.hauntedCarriage = new HauntedCarriage(clientCache);
        this.raidVault = new RaidVault(clientCache);
        this.defendVault = new DefendVault(clientCache);
        this.wrathborneInvasion = new WrathborneInvasion(clientCache);

        this.ancientNightmareEmbed = new AncientNightmareEmbed(clientCache);
        this.ancientArenaEmbed = new AncientArenaEmbed(clientCache);
        this.demonGatesEmbed = new DemonGatesEmbed(clientCache);
        this.hauntedCarriageEmbed = new HauntedCarriageEmbed(clientCache);
    }

    public void runScheduler(final JDA jda) {
        final Date nextFullMinuteTime = getNextFullMinuteTime();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                LOGGER.info(TimeAssistant.getTime("GMT+2"));
                try {
                    if (isChannelNotificationListEmpty()) {
                        return;
                    }

                    clientCache.getListWithNotifierChannels().forEach((textChannelID, notifierChannel) -> {
                        TextChannel textChannel;

                        if (textChannelID != null) {
                            textChannel = jda.getTextChannelById(textChannelID);
                        } else {
                            return;
                        }

                        if (textChannel == null) {
                            return;
                        }

                        String guildID = clientCache.getGuildIdByChannelID(textChannelID);
                        String timeZone = clientCache.getGuildTimeZone(guildID);
                        String guildLanguage = clientCache.getGuildLanguage(guildID);
                        StringBuilder notificationMessageBuilder = new StringBuilder();

                        if (clientCache.isRaidVaultMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(raidVault.checkOnRaidTheVaultEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isBattlegroundMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(battleground.checkOnBattlegroundEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isAncientNightmareMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(ancientNightMare.checkOnAncientNightMareEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isDemonGatesMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(demonGates.checkOnDemonGatesEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isHauntedCarriageMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(hauntedCarriage.checkOnHauntedCarriageEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isAncientArenaMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(ancientArena.checkOnAncientAreaEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isAssemblyMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(assembly.checkOnAssemblyEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isShadowLotteryMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(shadowLottery.checkOnShadowLotteryEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isDefendVaultMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(defendVault.checkOnDefendVaultEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (clientCache.isWrathborneInvasionEnabled(textChannelID)) {
                            notificationMessageBuilder.append(wrathborneInvasion.checkOnWrathborneInvasionEvent(timeZone, guildLanguage, guildID, textChannelID));
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, nextFullMinuteTime, 60 * 1000);
    }

    @NotNull
    private Date getNextFullMinuteTime() {
        final Date date = Calendar.getInstance().getTime();
        date.setMinutes(date.getMinutes() + 1);
        date.setSeconds(0);
        return date;
    }

    private void addMentionToMessage(final StringBuilder stringBuilder, final TextChannel textChannel) {
        String mention;
        String textChannelID = textChannel.getId();
        switch (clientCache.getRoleID(textChannelID).toLowerCase()) {
            case "everyone":
                mention = "@everyone";
                break;
            case "here":
                mention = "@here";
                break;
            default:
                mention = Objects.requireNonNull(textChannel.getJDA().getRoleById(clientCache.getRoleID(textChannelID)))
                        .getAsMention();
                break;
        }

        stringBuilder.append(mention);
    }

    private boolean isChannelNotificationListEmpty() {
        return clientCache.getListWithNotifierChannels().size() == 0;
    }

}
