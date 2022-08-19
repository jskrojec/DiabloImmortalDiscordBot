package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.languages.LanguageController;
import me.umbreon.diabloimmortalbot.utils.BooleanAssistant;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.List;

/**
 * Command: >cm create
 */
public class CustomMessageCreate {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    public CustomMessageCreate(ClientCache clientCache, DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
    }

    public void runCustomMessageCreateCommand(Message message) {
        addUserToOperatingMode(message);
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        if (clientCache.isUserInOperationMode(message.getTextChannel().getId(), message.getAuthor().getId())) {
                            String textChannelID = message.getTextChannel().getId();
                            clientCache.removeFromPreparingCustomMessagesList(textChannelID);
                            clientCache.removeFromPreparingCustomMessageUserList(textChannelID);
                            clientCache.removeFromWaitingForMessageList(textChannelID);
                            clientCache.removeFromWaitingForTextChannelList(textChannelID);
                            clientCache.removeFromWaitingForDayList(textChannelID);
                            clientCache.removeFromWaitingForTimeList(textChannelID);
                            clientCache.removeFromWaitingForRepeatingList(textChannelID);
                            clientCache.removeFromPreparingCustomMessageUserList(message.getTextChannel().getId());
                        }
                    }
                }, 300000 // 5 Minutes
        );
    }

    private void addUserToOperatingMode(Message message) {
        String userID = message.getAuthor().getId();
        String textChannelID = message.getTextChannel().getId();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        clientCache.addToPreparingCustomMessageUserList(textChannelID, userID);
        clientCache.addToWaitingForTextChannelList(textChannelID, userID);
        message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatChannelMessage(guildLanguage)).queue();
    }

    public void addTextChannelToPreparingCustomMessage(Message message) {
        String targetTextChannelID;
        String textChannelID = message.getTextChannel().getId();
        String userID = message.getAuthor().getId();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (message.getContentRaw().equalsIgnoreCase("this")) {
            targetTextChannelID = message.getTextChannel().getId();
            clientCache.removeFromWaitingForTextChannelList(textChannelID);
            clientCache.addToWaitingForDayList(textChannelID, userID);
            clientCache.addToPreparingCustomMessagesList(textChannelID, new CustomMessage(targetTextChannelID, guildID));
            message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatDayMessage(guildLanguage)).queue();
            return;
        }

        targetTextChannelID = StringAssistant.removeAllNonNumbers(message.getContentRaw());
        if (findTextChannel(targetTextChannelID, message.getGuild()) != null) {
            clientCache.removeFromWaitingForTextChannelList(textChannelID);
            clientCache.addToWaitingForDayList(textChannelID, userID);
            clientCache.addToPreparingCustomMessagesList(textChannelID, new CustomMessage(targetTextChannelID, guildID));
            message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatDayMessage(guildLanguage)).queue();
            return;
        }

        message.getTextChannel().sendMessage(LanguageController.getChannelNotFoundMessage(guildLanguage)).queue();
    }

    public void addDayToPreparingCustomMessage(Message message) {
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (clientCache.getListOfAvailableEventDays().contains(message.getContentRaw().toLowerCase())) {
            String textChannelID = message.getTextChannel().getId();
            clientCache.removeFromWaitingForDayList(textChannelID);
            clientCache.getPreparingCustomMessage(textChannelID).setDay(message.getContentRaw());
            clientCache.addToWaitingForTimeList(textChannelID, message.getAuthor().getId());
            message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatTimeMessage(guildLanguage)).queue();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(LanguageController.getCustomMessageInvalidDayMessage(guildLanguage));

            for (int i = 0; i <= clientCache.getListOfAvailableEventDays().size(); i++) {
                stringBuilder.append(clientCache.getListOfAvailableEventDays().get(i));
                if (i == clientCache.getListOfAvailableEventDays().size() - 1) {
                    stringBuilder.append(" & ");
                }
                if (i == clientCache.getListOfAvailableEventDays().size()) {
                    stringBuilder.append(" ");
                } else {
                    stringBuilder.append(" , ");
                }
            }

            message.getTextChannel().sendMessage(stringBuilder).queue();
        }
    }

    public void addTimeToPreparingCustomMessage(Message message) {
        if (StringAssistant.isStringInTimePattern(message.getContentRaw())) {
            String textChannelID = message.getTextChannel().getId();
            String guildID = message.getGuild().getId();
            String guildLanguage = clientCache.getGuildLanguage(guildID);
            clientCache.removeFromWaitingForTimeList(textChannelID);
            CustomMessage preparingCustomMessage = clientCache.getPreparingCustomMessage(textChannelID);
            preparingCustomMessage.setTime(message.getContentRaw());

            if (preparingCustomMessage.getDay().equalsIgnoreCase("everyday")) {
                clientCache.addToWaitingForMessageList(textChannelID, message.getAuthor().getId());
                preparingCustomMessage.setRepeating(true);
                message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatMessageMessage(guildLanguage)).queue();
                return;
            }

            clientCache.addToWaitingForRepeatingList(textChannelID, message.getAuthor().getId());
            message.getTextChannel().sendMessage(LanguageController.getCustomMessageIsRepeatingMessage(guildLanguage)).queue();
            ;
        }
    }

    public void addRepeatingValueToCustomMessage(Message message) {
        String textChannelID = message.getTextChannel().getId();
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);

        if (BooleanAssistant.isValueTrue(message.getContentRaw().toLowerCase())) {
            clientCache.getPreparingCustomMessage(textChannelID).setRepeating(true);
            clientCache.removeFromWaitingForRepeatingList(textChannelID);
            clientCache.addToWaitingForMessageList(textChannelID, message.getAuthor().getId());
            message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatMessageMessage(guildLanguage)).queue();
            return;
        }

        if (BooleanAssistant.isValueFalse(message.getContentRaw().toLowerCase())) {
            clientCache.getPreparingCustomMessage(textChannelID).setRepeating(false);
            clientCache.removeFromWaitingForRepeatingList(textChannelID);
            clientCache.addToWaitingForMessageList(textChannelID, message.getAuthor().getId());
            message.getTextChannel().sendMessage(LanguageController.getCustomMessageWhatMessageMessage(guildLanguage)).queue();
            return;
        }

        message.getTextChannel().sendMessage(LanguageController.getYesOrNoMessage(guildLanguage)).queue();
    }

    public void addMessageToCustomMessage(Message message) {
        String textChannelID = message.getTextChannel().getId();
        CustomMessage preparingCustomMessage = clientCache.getPreparingCustomMessage(textChannelID);
        preparingCustomMessage.setMessage(message.getContentRaw());
        String guildID = message.getGuild().getId();
        String guildLanguage = clientCache.getGuildLanguage(guildID);
        databaseRequests.createNewCustomMessageEntry(preparingCustomMessage);
        clientCache.setCustomMessagesList(databaseRequests.getAllCustomMessages());
        clientCache.removeFromPreparingCustomMessagesList(textChannelID);
        clientCache.removeFromPreparingCustomMessageUserList(textChannelID);
        clientCache.removeFromWaitingForMessageList(textChannelID);
        message.getTextChannel().sendMessage(LanguageController.getCustomMessageCreatedMessage(guildLanguage)).queue();
    }

    private TextChannel findTextChannel(String textChannelID, Guild guild) {
        List<TextChannel> textChannels = guild.getTextChannels();
        return textChannels.stream()
                .filter(textChannel -> textChannel.getId().equalsIgnoreCase(textChannelID))
                .findFirst()
                .orElse(null);
    }

}
