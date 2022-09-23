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

        prepareChannelCommands(commandDataList);
        prepareCustomMessagesCommands(commandDataList);
        prepareEventCommands(commandDataList);
        prepareHelpCommands(commandDataList);
        prepareServerCommands(commandDataList);
        prepareReactionRolesCommand(commandDataList);

        return commandDataList;
    }

    private static void prepareReactionRolesCommand(List<CommandData> commandDataList) {
        OptionData messageIdOption = new OptionData(OptionType.STRING, "messageid", "Enter here your message ID.", true);
        OptionData roleIdOption = new OptionData(OptionType.ROLE, "role", "Enter here your role", true);
        OptionData emojiOption = new OptionData(OptionType.STRING, "emote", "Enter here your emote", true);

        commandDataList.add(Commands.slash("createreactionrole", "Create your custom reaction role.").addOptions(messageIdOption, roleIdOption, emojiOption));
        commandDataList.add(Commands.slash("removereactionrole", "Removes a custom reaction role.").addOptions(messageIdOption, emojiOption));
    }

    private static void prepareChannelCommands(List<CommandData> commandDataList) {
        OptionData channelOptionData = new OptionData(OptionType.CHANNEL, "targetchannel", "Select here your channel", false);
        OptionData roleOptionData = new OptionData(OptionType.ROLE, "mentionrole", "Select here your role.", true);

        // - /info <CHANNEL>
        commandDataList.add(Commands.slash("info", "Show's you all information about that given channel.")
                .addOptions(channelOptionData));

        // - /register <CHANNEL>
        commandDataList.add(Commands.slash("register", "Registers a channel as notifier-channel.")
                .addOptions(channelOptionData));

        // - /unregister <CHANNEL>
        commandDataList.add(Commands.slash("unregister", "Unregisters a channel as notifier-channel.")
                .addOptions(channelOptionData));

        // - /mentionrole <ROLE> <CHANNEL>
        commandDataList.add(Commands.slash("mentionrole", "Select that role which should get mentioned in this channel")
                .addOptions(roleOptionData, channelOptionData));
    }

    private static void prepareCustomMessagesCommands(List<CommandData> commandDataList) {
        // - /createcustommessage <WEEKDAY> <TIME> <BOOL_REPEATING> <MESSAGE>
        OptionData createCMWeekdayOptionData = new OptionData(OptionType.STRING, "custommessageweekday", "At what day would you like to get the message?", true)
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

        // - /custommessageinfo <ID>
        OptionData customMessageIdOptionData = new OptionData(OptionType.INTEGER, "custommessageid", "Enter your custom message ID here.", true);

        commandDataList.add(Commands.slash("custommessageinfo", "Show's you information about a custom message.")
                .addOptions(customMessageIdOptionData));

        // - /deletecustommessage <ID>
        commandDataList.add(Commands.slash("deletecustommessage", "You can delete your custom messages here.")
                .addOptions(customMessageIdOptionData));

        // - /listcustommessages
        commandDataList.add(Commands.slash("listcustommessages", "Lists your all your custom messages."));
    }

    private static void prepareEventCommands(List<CommandData> commandDataList) {
        // - /event <GAME_EVENT> <ON/OFF>
        OptionData eventOptionData1 = new OptionData(OptionType.STRING, "event", "Allows your to enable or disable a specific event notification for that channel.", true)
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
        OptionData eventOptionData2 = new OptionData(OptionType.BOOLEAN, "eventvalue", "Select that event you want to change.", true);

        commandDataList.add(Commands.slash("event", "Enable or disable this event notification?").addOptions(eventOptionData1, eventOptionData2));

        // - /listevents
        commandDataList.add(Commands.slash("listevents", "List's all aviable events."));
    }

    private static void prepareHelpCommands(List<CommandData> commandDataList) {
        commandDataList.add(Commands.slash("install", "Shows you a instruction to install the bot."));
        commandDataList.add(Commands.slash("help", "Shows all commands."));
        commandDataList.add(Commands.slash("langauges", "Shows a list with available languages."));
        commandDataList.add(Commands.slash("timezones", "Shows you a list with the GMT times."));
    }

    private static void prepareServerCommands(List<CommandData> commandDataList) {
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
        // - /language <LANGUAGE>
        OptionData languageOptionData = new OptionData(OptionType.STRING, "language", "Select here your language.", true)
                .addChoice("Germany", "GER")
                .addChoice("English", "ENG")
                .addChoice("Spanish", "ESP")
                .addChoice("France", "FRA")
                .addChoice("Polish", "POL")
                .addChoice("Italia", "ITA")
                .addChoice("Indonesia", "IND")
                .addChoice("Russia", "RUS");
        commandDataList.add(Commands.slash("language", "Changes the bots language for your server.")
                .addOptions(languageOptionData));
        // - /config
        commandDataList.add(Commands.slash("config", "Show's you your server settings."));

        // - /server <SERVER_SETTING> <ON/OFF>
        OptionData serverOptionData1 = new OptionData(OptionType.STRING, "serversetting", "Server Setting", true)
                .addChoice("headup", "headup")
                .addChoice("message", "message");
        OptionData serverOptionData2 = new OptionData(OptionType.BOOLEAN, "servervalue", "True or false", false);

        commandDataList.add(Commands.slash("server", "Set's serverwide settings.").addOptions(serverOptionData1, serverOptionData2));
    }

}
