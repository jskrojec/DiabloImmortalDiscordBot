package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.CommandsUtil;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GuildReady extends ListenerAdapter {

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        try {
            List<CommandData> commandDataList = CommandsUtil.getCommandDataList();
            event.getGuild().updateCommands().addCommands(commandDataList).queue();
        } catch (Exception e) {
            ClientLogger.createNewServerLogEntry(event.getGuild().getId(), "global", "Failed to register new commands on GuildJoinEvent.");
            e.printStackTrace();
        }
    }

}
