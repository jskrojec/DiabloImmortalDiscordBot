package me.umbreon.diabloimmortalbot.notifier;

import me.umbreon.diabloimmortalbot.gameevents.*;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientArenaEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.AncientNightmareEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.DemonGatesEmbed;
import me.umbreon.diabloimmortalbot.gameevents.embeds.HauntedCarriageEmbed;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
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

    public void runNotificationScheduler(final JDA jda) {
        Date nextFullMinuteTime = getNextFullMinuteTime();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (isChannelNotificationListEmpty()) {
                    return;
                }

                clientCache.getListWithNotifierChannels().forEach((textChannelID, notifierChannel) -> {
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

                        if (clientCache.isDebugEnabled(textChannelID)) {
                            notificationMessageBuilder.append("Debug");
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
        String roleID = clientCache.getRoleID(textChannelID);
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
        return clientCache.getListWithNotifierChannels().size() == 0;
    }

    private Role findRoleInGuildUsingID(Guild guild, String roleID) {
        return guild.getRoles().stream()
                .filter(role -> role.getId().equals(roleID))
                .findFirst()
                .orElse(null);
    }

}
