package me.umbreon.diabloimmortalbot.commands.help_commands;

import me.umbreon.diabloimmortalbot.utils.ImageAssistant;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
/**
 * Command: >help
 */
public class HelpCommand {

    public void runHelpCommand(Message message) {
        TextChannel textChannel = message.getTextChannel();
        textChannel.sendMessageEmbeds(buildHelpMessage()).queue();
    }

    private MessageEmbed buildHelpMessage() {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setTitle("Diablo Immortal Notifier Commands");
        embedBuilder.setColor(Color.RED);
        embedBuilder.setThumbnail(ImageAssistant.getDiabloImmortalLogo());

        embedBuilder.addField(">register", "Registers that channel as notifier-channel.", false);
        embedBuilder.addField(">unregister", "Unregisters that channel.", false);

        embedBuilder.addField(">timezone [Timezone]", "Sets your timezone server wide.", false);
        embedBuilder.addField(">role [Role]", "Set what role should be mentioned in this textchannel. If you dont set the role everyone will be mentioned.", false);

        embedBuilder.addField(">cm create", "Creates an custom message.", false);
        embedBuilder.addField(">cm delete ID", "Deletes an custom message. See ID's using >cm list.", false);
        embedBuilder.addField(">cm list", "Show's all custom messages.", false);
        embedBuilder.addField(">cm info ID", "Show's all informations about a custom message.", false);

        embedBuilder.addField(">server headup on/off", "Disables or enables headup messages server wide.", false);
        embedBuilder.addField(">server message on/off", "Disables or enables event messages server wide.", false);
        embedBuilder.addField(">server config", "Shows all server configurations", false);
        embedBuilder.addField(">server lanugae", "Sets language for your server.", false);
        embedBuilder.addField(">server timezone", "Sets timezone for your server.", false);

        embedBuilder.addField(">instructions", "Shows the bot instructions.", false);
        embedBuilder.addField(">help", "Shows this message.", false);
        embedBuilder.addField(">info", "Shows channel informations.", false);

        embedBuilder.addBlankField(false);
        embedBuilder.addField("Support on Discord:", "https://discord.gg/hpBHYkffS3", false);
        embedBuilder.setFooter("Diablo Immortal Notifier - Created by Umbreon.");
        return embedBuilder.build();
    }
}
