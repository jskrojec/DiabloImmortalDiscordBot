package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuildReady extends ListenerAdapter {

    private final String registerDescription = "Registers a channel as notifier-channel.";
    private final String unregisterDescription = "Unregisters a channel as notifier-channel.";
    private final String roleDescription = "Set's new mention role for that channel.";
    private final String roleOptionDescription = "Select that role which should get mentioned in this channel";
    private final String infoDescription = "Shows channels informations.";
    private final String serverDescription = "Set's serverwide settings.";
    private final String serverOptionDescription1 = "Server Setting";
    private final String serverOptionDescription2 = "24 / 48 / 74 is only for autodelete.";
    private final String eventDescription = "Allows your to enable or disable a specific event notification for that channel.";
    private final String eventOptionDescription1 = "Select that event you want to change.";
    private final String eventOptionDescription2 = "Enable or disable this event notification?";
    private final String installDescription = "Shows you a instruction to install the bot.";
    private final String helpDescription = "Shows all commands.";
    private final String languagesDescription = "Shows a list with available languages.";
    private final String timezonesDescription = "Shows you a list with the GMT times.";

    @Override
    public void onGuildReady(@NotNull final GuildReadyEvent event) {
        try {
            final List<CommandData> commandDataList = new ArrayList<>();
            // Register & Unregister Channel
            commandDataList.add(Commands.slash("register", registerDescription));
            commandDataList.add(Commands.slash("unregister", unregisterDescription));
            // Set mention role for channel & Info
            final OptionData roleOptionData = new OptionData(OptionType.ROLE, "role", roleOptionDescription, true);
            commandDataList.add(Commands.slash("role", roleDescription).addOptions(roleOptionData));
            commandDataList.add(Commands.slash("info", infoDescription));
            // timezone <timezone> command
            final OptionData languageOptionData = new OptionData(OptionType.STRING, "timezone", "Set's your server timezone.", true)
                    .addChoice("GMT-11", "GMT-11")
                    .addChoice("GMT-10", "GMT-10")
                    .addChoice("GMT-9", "GMT-9")
                    .addChoice("GMT-8", "GMT-8")
                    .addChoice("GMT-7", "GMT-7")
                    .addChoice("GMT-6", "GMT-6")
                    .addChoice("GMT-5", "GMT-5")
                    .addChoice("GMT-4", "GMT-4")
                    .addChoice("GMT-3", "GMT-3")
                    .addChoice("GMT-2", "GMT-2")
                    .addChoice("GMT-1", "GMT-1")
                    .addChoice("GMT", "GMT")
                    .addChoice("GMT+1", "GMT+1")
                    .addChoice("GMT+2", "GMT+2")
                    .addChoice("GMT+3", "GMT+3")
                    .addChoice("GMT+4", "GMT+4")
                    .addChoice("GMT+5", "GMT+5")
                    .addChoice("GMT+6", "GMT+6")
                    .addChoice("GMT+7", "GMT+7")
                    .addChoice("GMT+8", "GMT+8")
                    .addChoice("GMT+9", "GMT+9")
                    .addChoice("GMT+10", "GMT+10")
                    .addChoice("GMT+11", "GMT+11");
            commandDataList.add(Commands.slash("timezone", "X").addOptions(languageOptionData));

            // Server commands
            final OptionData serverOptionData1 = new OptionData(OptionType.STRING, "serversetting", serverOptionDescription1, true)
                    .addChoice("headup", "headup") // on / off
                    .addChoice("messages", "messages") // on / off
                    .addChoice("config", "config")
                    //.addChoice("autodelete", "autodelete") // on / off OR 24 / 48 / 72
                    .addChoice("language", "language"); // <language>
            final OptionData serverOptionData2 = new OptionData(OptionType.STRING, "servervalue", serverOptionDescription2, false)
                    .addChoice("on", "on")
                    .addChoice("off", "off")
                    .addChoice("24", "24")
                    .addChoice("48", "48")
                    .addChoice("72", "72")
                    .addChoice("Germany", "GER")
                    .addChoice("English", "ENG")
                    .addChoice("Spanish", "ESP")
                    .addChoice("France", "FRA")
                    .addChoice("Polish", "POL")
                    .addChoice("Italia", "ITA")
                    .addChoice("Indonesia", "IND")
                    .addChoice("Russia", "RUS");
            commandDataList.add(Commands.slash("server", serverDescription).addOptions(serverOptionData1, serverOptionData2));
            // Event commands
            final OptionData eventOptionData1 = new OptionData(OptionType.STRING, "event", eventOptionDescription1, true)
                    .addChoice("list", "list")
                    .addChoice("message", "message")
                    .addChoice("headup", "headup")
                    .addChoice("ancientarena", "ancientarena")
                    .addChoice("ancientnightmare", "ancientnightmare")
                    .addChoice("assembly", "assembly")
                    .addChoice("battlegrounds", "battlegrounds")
                    .addChoice("defendvault", "defendvault")
                    .addChoice("raidvault", "raidvault")
                    .addChoice("demongates", "demongates")
                    .addChoice("shadowlottery", "shadowlottery")
                    .addChoice("hauntedcarriage", "hauntedcarriage")
                    .addChoice("wrathborneinvasion", "wrathborneinvasion")
                    .addChoice("hauntedcarriageembed", "hauntedcarriageembed")
                    .addChoice("demongatesembed", "demongatesembed")
                    .addChoice("ancientnightmareembed", "ancientnightmareembed")
                    .addChoice("ancientarenaembed", "ancientarenaembed");
            final OptionData eventOptionData2 = new OptionData(OptionType.STRING, "eventvalue", eventOptionDescription2, false)
                    .addChoice("on", "on")
                    .addChoice("off", "off");
            commandDataList.add(Commands.slash("event", eventDescription).addOptions(eventOptionData1, eventOptionData2));
            // Install, Help, Timezones & Languages command
            commandDataList.add(Commands.slash("install", installDescription));
            commandDataList.add(Commands.slash("help", helpDescription));
            commandDataList.add(Commands.slash("languages", languagesDescription));
            commandDataList.add(Commands.slash("timezones", timezonesDescription));
            commandDataList.add(Commands.slash("deleteme", "Deletes everything."));

            event.getGuild().updateCommands().addCommands(commandDataList).queue();
        } catch (Exception e) {
            Objects.requireNonNull(event.getGuild().getOwner()).getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage("Hey, we noticed that we can't register any new commands to your guild." +
                        "If you like to use this bot commands you need to re invite the bot with out new invite url: " +
                        "https://discord.com/api/oauth2/authorize?client_id=527511535309029407&permissions=2147739712&scope=applications.commands%20bot").queue();
            });
            ClientLogger.createNewErrorLogEntry(e);
            e.printStackTrace();
        }
    }
}
