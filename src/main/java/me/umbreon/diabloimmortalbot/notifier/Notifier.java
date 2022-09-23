package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.cache.GameEventsCache;
import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.cache.NotificationChannelsCache;
import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientArenaEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientNightmareEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.DemonGatesEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.HauntedCarriageEmbed;
import me.umbreon.diabloimmortalbot.cache.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Notifier {

    private final ClientCache clientCache;
    private final NotificationChannelsCache notificationChannelsCache;
    private final GameEventsCache gameEventsCache;
    private final GuildsCache guildsCache;

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

    public Notifier(final ClientCache clientCache, final NotificationChannelsCache notificationChannelsCache, final GameEventsCache gameEventsCache, final GuildsCache guildsCache) {
        this.clientCache = clientCache;
        this.notificationChannelsCache = notificationChannelsCache;
        this.gameEventsCache = gameEventsCache;
        this.guildsCache = guildsCache;

        this.assembly = new Assembly(notificationChannelsCache, guildsCache, gameEventsCache);
        this.shadowLottery = new ShadowLottery(notificationChannelsCache, guildsCache, gameEventsCache);
        this.ancientArena = new AncientArena(notificationChannelsCache, guildsCache, gameEventsCache);
        this.ancientNightMare = new AncientNightMare(notificationChannelsCache, guildsCache, gameEventsCache);
        this.battleground = new Battleground(notificationChannelsCache, guildsCache, gameEventsCache);
        this.demonGates = new DemonGates(notificationChannelsCache, guildsCache, gameEventsCache);
        this.hauntedCarriage = new HauntedCarriage(notificationChannelsCache, guildsCache, gameEventsCache);
        this.raidVault = new RaidVault(notificationChannelsCache, guildsCache, gameEventsCache);
        this.defendVault = new DefendVault(notificationChannelsCache, guildsCache, gameEventsCache);
        this.wrathborneInvasion = new WrathborneInvasion(notificationChannelsCache, guildsCache, gameEventsCache);

        this.ancientNightmareEmbed = new AncientNightmareEmbed(gameEventsCache, notificationChannelsCache);
        this.ancientArenaEmbed = new AncientArenaEmbed(gameEventsCache, notificationChannelsCache);
        this.demonGatesEmbed = new DemonGatesEmbed(gameEventsCache, notificationChannelsCache);
        this.hauntedCarriageEmbed = new HauntedCarriageEmbed(gameEventsCache, notificationChannelsCache);
    }

    public void runNotificationScheduler(final JDA jda) {
        Date nextFullMinuteTime = getNextFullMinuteTime();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (isChannelNotificationListEmpty()) {
                    return;
                }

                notificationChannelsCache.getListWithNotifierChannels().forEach((textChannelID, notifierChannel) -> {
                    try {
                        TextChannel textChannel;

                        if (textChannelID != null) {
                            textChannel = jda.getTextChannelById(textChannelID);
                        } else {
                            return;
                        }

                        if (textChannel == null) {
                            return;
                        }

                        String guildID = notificationChannelsCache.getGuildIdByChannelID(textChannelID);
                        String timeZone = guildsCache.getGuildTimeZone(guildID);
                        String guildLanguage = guildsCache.getGuildLanguage(guildID);
                        StringBuilder notificationMessageBuilder = new StringBuilder();

                        if (notificationChannelsCache.isRaidVaultMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(raidVault.checkOnRaidTheVaultEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isBattlegroundMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(battleground.checkOnBattlegroundEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isAncientNightmareMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(ancientNightMare.checkOnAncientNightMareEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isDemonGatesMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(demonGates.checkOnDemonGatesEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isHauntedCarriageMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(hauntedCarriage.checkOnHauntedCarriageEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isAncientArenaMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(ancientArena.checkOnAncientAreaEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isAssemblyMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(assembly.checkOnAssemblyEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isShadowLotteryMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(shadowLottery.checkOnShadowLotteryEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isDefendVaultMessageEnabled(textChannelID)) {
                            notificationMessageBuilder.append(defendVault.checkOnDefendVaultEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        if (notificationChannelsCache.isWrathborneInvasionEnabled(textChannelID)) {
                            notificationMessageBuilder.append(wrathborneInvasion.checkOnWrathborneInvasionEvent(timeZone, guildLanguage, guildID, textChannelID));
                        }

                        //Embeds
                        if (notificationChannelsCache.isAncientArenaEmbedMessageEnabled(textChannelID)) {
                            ancientArenaEmbed.checkAncientArenaFormatted(textChannel, timeZone, guildLanguage);
                        }

                        if (notificationChannelsCache.isAncientNightmareEmbedMessageEnabled(textChannelID)) {
                            ancientNightmareEmbed.checkAncientNightmareFormatted(textChannel, timeZone, guildLanguage);
                        }

                        if (notificationChannelsCache.isDemonGatesEmbedMessageEnabled(textChannelID)) {
                            demonGatesEmbed.checkDemonGatesFormatted(textChannel, timeZone, guildLanguage);
                        }

                        if (notificationChannelsCache.isHauntedCarriageEmbedMessageEnabled(textChannelID)) {
                            hauntedCarriageEmbed.checkHauntedCarriageFormatted(textChannel, timeZone, guildLanguage);
                        }

                        if (notificationMessageBuilder.length() > 0) {
                            addMentionToMessage(notificationMessageBuilder, textChannel);
                            textChannel.sendMessage(notificationMessageBuilder.toString()).queue();
                        }
                    } catch (InsufficientPermissionException e) {
                        ClientLogger.createNewServerLogEntry(notifierChannel.getGuildID(), "global", "Failed to send notification message cause of insufficient permissions. " + e.getMessage());
                    } catch (Exception e) {
                        ClientLogger.createNewServerLogEntry(notifierChannel.getGuildID(), "global", "Failed to send notification message.");
                    }

                });
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
        String mention = null;
        String textChannelID = textChannel.getId();
        String roleID = notificationChannelsCache.getRoleID(textChannelID);
        Guild guild = textChannel.getGuild();
        switch (roleID.toLowerCase()) {
            case "everyone":
                mention = "@everyone";
                break;
            case "here":
                mention = "@here";
                break;
            default:
                Role mentionRole = findRoleInGuildUsingID(textChannel.getGuild(), roleID);
                if (mentionRole != null) {
                    mention = mentionRole.getAsMention();
                } else {
                    ClientLogger.createNewServerLogEntry(guild.getId(), textChannelID, "Tried to add mention " +
                            "role, but role couldn't be found.");
                }
                break;
        }

        if (mention != null) {
            stringBuilder.append(mention);
        }
    }

    private boolean isChannelNotificationListEmpty() {
        return notificationChannelsCache.getNotificationChannelsAmount() > 0;
    }

    private Role findRoleInGuildUsingID(Guild guild, String roleID) {
        return guild.getRoles().stream()
                .filter(role -> role.getId().equals(roleID))
                .findFirst()
                .orElse(null);
    }

}
