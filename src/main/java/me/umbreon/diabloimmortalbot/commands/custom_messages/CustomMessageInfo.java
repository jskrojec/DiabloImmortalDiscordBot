package me.umbreon.diabloimmortalbot.commands.custom_messages;

import me.umbreon.diabloimmortalbot.data.CustomMessage;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;

public class CustomMessageInfo {

    private final ClientCache clientCache;
    private MessageEmbed invalidCommandUsageEmbed;

    public CustomMessageInfo(final ClientCache clientCache) {
        this.clientCache = clientCache;
        buildInvalidCommandUsageEmbed();
    }

    public void runCustomMessageInfoCommand(final String[] args, final TextChannel textChannel) {
        if (!areArgumentsValid(args)) {
            textChannel.sendMessageEmbeds(invalidCommandUsageEmbed).queue();
            return;
        }

        final int customMessageID;
        try {
            customMessageID = Integer.parseInt(args[2]);
        } catch (final NumberFormatException e) {
            textChannel.sendMessage("Invalid ID. Use >cm list to see all your custom messages.").queue();
            return;
        }

        textChannel.sendMessageEmbeds(buildCustomMessageInfoEmbed(customMessageID)).queue();
    }

    private MessageEmbed buildCustomMessageInfoEmbed(final int customMessageID) {
        final CustomMessage customMessage = clientCache.getCustomMessageByID(customMessageID);
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.ORANGE);
        final String textChannelMention = "<#" + customMessage.getChannelID() + ">";
        final String time = customMessage.getDay() + " " + customMessage.getTime();
        embedBuilder.addField("TextChannel:", textChannelMention, true);
        embedBuilder.addField("Message:", customMessage.getMessage(), true);
        embedBuilder.addField("Time:", time, true);
        embedBuilder.addField("Repeating:", String.valueOf(customMessage.isRepeat()), true);
        return embedBuilder.build();
    }

    private boolean areArgumentsValid(final String[] args) {
        return args[1].equalsIgnoreCase("info") && args.length == 3;
    }

    private void buildInvalidCommandUsageEmbed() {
        final EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.RED);
        embedBuilder.addField("Invalid command", "Command example: >cm info ID.", false);
        this.invalidCommandUsageEmbed = embedBuilder.build();
    }
}
