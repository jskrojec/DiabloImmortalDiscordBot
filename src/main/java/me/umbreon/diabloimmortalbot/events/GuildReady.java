package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.CommandsUtil;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class GuildReady extends ListenerAdapter {

    @Override
    public void onGuildReady(@NotNull final GuildReadyEvent event) {
        try {
            List<CommandData> commandDataList = CommandsUtil.getCommandDataList();
            event.getGuild().updateCommands().addCommands(commandDataList).queue();
        } catch (Exception e) {
            discordLogMessage(1021107125918908486L, event);
            ClientLogger.createNewServerLogEntry(event.getGuild().getId(), "global", "Failed to register new commands on GuildJoinEvent.");
            e.printStackTrace();
        }
    }
    
    private void discordLogMessage(long id, GuildReadyEvent event) {
        Objects.requireNonNull(event.getJDA().getTextChannelById(id))
                .sendMessage(Objects.requireNonNull(event.getGuild().getOwner()).getAsMention() +
                        " is the owner of " + event.getGuild().getName() + " and i couldn't register new commands. " +
                        "USER_ID: " + event.getGuild().getOwnerId() + " GUILD_ID: " + event.getGuild().getId()).queue();
    }
}
