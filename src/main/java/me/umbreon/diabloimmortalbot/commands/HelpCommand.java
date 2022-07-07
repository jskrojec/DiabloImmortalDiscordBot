package me.umbreon.diabloimmortalbot.commands;

import net.dv8tion.jda.api.entities.Message;

public class HelpCommand {

    public void onHelpCommand(Message message) {
        String helpMessage =
                "/notifier - register a channel.\n" +
                        "/unnotifier - unregister a channel.\n" +
                        "/timezone CEST - Set your timezone. Default: PST\n" +
                        "/role @YourCustomRole - Set your custom mention role. Default: everyone\n" +
                        "/status 0 - All messages.\n" +
                        "/status 1 - Overworld Events.\n" +
                        "/status 2 - Immortal Events.\n" +
                        "/status 3 - Shadow Events.\n" +
                        "/status 4 - Immortal & Overworld Events.\n" +
                        "/status 5 - Shadow & Overworld Events.\n\n" +
                        "You need to assign yourself a role named 'Bot Admin' to run these Commands. " +
                        "The Role 'Bot Admin' does not need any permission.";

        message.getTextChannel().sendMessage(helpMessage).queue();

    }

}
