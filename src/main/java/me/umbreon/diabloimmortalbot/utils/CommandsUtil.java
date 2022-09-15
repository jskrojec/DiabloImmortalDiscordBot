package me.umbreon.diabloimmortalbot.utils;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.util.ArrayList;
import java.util.List;

public class CommandsUtil {

    public static List<CommandData> getCommandDataList() {
        List<CommandData> commandDataList = new ArrayList<>();
        // - /register <CHANNEL>
        OptionData channelOptionData = new OptionData(OptionType.CHANNEL, "targetchannel", "Select here your channel", false);
        commandDataList.add(Commands.slash("register", "Registers a channel as notifier-channel.")
                .addOptions(channelOptionData));
        // - /unregister <CHANNEL>
        commandDataList.add(Commands.slash("unregister", "Unregisters a channel as notifier-channel.")
                .addOptions(channelOptionData));
        // - /role <ROLE>
        OptionData roleOptionData = new OptionData(OptionType.ROLE, "role", "Select here your role.", true);
        commandDataList.add(Commands.slash("role", "Select that role which should get mentioned in this channel")
                .addOptions(roleOptionData));
        // - /info <CHANNEL>
        commandDataList.add(Commands.slash("info", "Show's you all information about that given channel.")
                .addOptions(channelOptionData));
        // - /timezone <TIMEZONE>
        OptionData timezoneOptionData = new OptionData(OptionType.STRING, "timezone", "Select here your matching GMT timezone. Use /timzones to see what timezone would match you.", true)
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
        commandDataList.add(Commands.slash("timezone", "Set's your server timezone.")
                .addOptions(timezoneOptionData));
        // Custom Messages
        OptionData customMessageIdOptionData = new OptionData(OptionType.INTEGER, "custommessageid", "Enter your custom message ID here.", true);
        // - /deletecustommessage <ID>
        commandDataList.add(Commands.slash("deletecustommessage", "You can delete your custom messages here.")
                .addOptions(customMessageIdOptionData));
        // - /custommessageinfo <ID>
        commandDataList.add(Commands.slash("custommessageinfo", "Show's you information about a custom message.")
                .addOptions(customMessageIdOptionData));
        // - /listcustommessages
        commandDataList.add(Commands.slash("listcustommessages", "Lists your all your custom messages."));
        // - /createcustommessage <WEEKDAY> <TIME> <BOOL_REPEATING> <MESSAGE>
        OptionData createCMWeekdayOptionData = new OptionData(OptionType.STRING, "weekday", "At what day would you like to get the message?", true)
                .addChoice("Monday", "monday")
                .addChoice("Tuesday", "tuesday")
                .addChoice("Wednesday", "wednesday")
                .addChoice("Thursday", "thursday")
                .addChoice("Friday", "friday")
                .addChoice("Saturday", "saturday")
                .addChoice("Sunday", "sunday")
                .addChoice("Everyday", "everyday");
        OptionData createCMTimeOptionData = new OptionData(OptionType.STRING, "custommessagetime", "At what time would you like to get the message?", true);
        OptionData createCMRepeatingOptionData = new OptionData(OptionType.BOOLEAN, "custommessagerepeating", "Should the message be sent every week or only once?", true);
        OptionData createCMMessageOptionData = new OptionData(OptionType.STRING, "custommessagemessage", "Enter here your message.", true);
        commandDataList.add(Commands.slash("createcustommessage", "Create a custom notification message.")
                .addOptions(createCMWeekdayOptionData, createCMTimeOptionData, createCMRepeatingOptionData, createCMMessageOptionData));
        // Server commands
        OptionData serverOptionData1 = new OptionData(OptionType.STRING, "serversetting", "Server Setting", true)
                .addChoice("headup", "headup") // on / off
                .addChoice("messages", "messages") // on / off
                .addChoice("config", "config")
                .addChoice("language", "language"); // <language>
        OptionData serverOptionData2 = new OptionData(OptionType.STRING, "servervalue", "24 / 48 / 74 is only for autodelete.", false)
                .addChoice("on", "on")
                .addChoice("off", "off")
                .addChoice("Germany", "GER")
                .addChoice("English", "ENG")
                .addChoice("Spanish", "ESP")
                .addChoice("France", "FRA")
                .addChoice("Polish", "POL")
                .addChoice("Italia", "ITA")
                .addChoice("Indonesia", "IND")
                .addChoice("Russia", "RUS");
        commandDataList.add(Commands.slash("server", "Set's serverwide settings.").addOptions(serverOptionData1, serverOptionData2));
        // Event commands
        OptionData eventOptionData1 = new OptionData(OptionType.STRING, "event", "Allows your to enable or disable a specific event notification for that channel.", true)
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
        OptionData eventOptionData2 = new OptionData(OptionType.STRING, "eventvalue", "Select that event you want to change.", false)
                .addChoice("on", "on")
                .addChoice("off", "off");
        commandDataList.add(Commands.slash("event", "Enable or disable this event notification?").addOptions(eventOptionData1, eventOptionData2));
        // Install, Help, Timezones & Languages command
        commandDataList.add(Commands.slash("install", "Shows you a instruction to install the bot."));
        commandDataList.add(Commands.slash("help", "Shows all commands."));
        commandDataList.add(Commands.slash("langauges", "Shows a list with available languages."));
        commandDataList.add(Commands.slash("timezones", "Shows you a list with the GMT times."));
        commandDataList.add(Commands.slash("deleteme", "Deletes everything."));


        OptionData optionData1 = new OptionData(OptionType.STRING, "debugone", "DEBUG", true);
        OptionData optionData2 = new OptionData(OptionType.STRING, "debugtwo", "DEBUG", true);

        commandDataList.add(Commands.slash("debugone", "X").addOptions(optionData1));
        commandDataList.add(Commands.slash("debugtwo", "X").addOptions(optionData2));
        commandDataList.add(Commands.slash("debugthree", "X").addOptions(optionData2));
        return commandDataList;
    }
}
