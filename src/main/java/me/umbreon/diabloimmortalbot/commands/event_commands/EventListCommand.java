package me.umbreon.diabloimmortalbot.commands.event_commands;

import me.umbreon.diabloimmortalbot.utils.ClientCache;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /listevents
 * Description: List's all aviable events.
 */
public class EventListCommand {

    private final ClientCache clientCache;

    public EventListCommand(ClientCache clientCache) {
        this.clientCache = clientCache;
    }

    public void runEventListCommand(final SlashCommandInteractionEvent event) {
        event.reply(createListWithAvailableEvents()).setEphemeral(true).queue();
    }

    @NotNull
    private String createListWithAvailableEvents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < clientCache.getListWithAvailableNotifications().size(); i++) {
            if (i == clientCache.getListWithAvailableNotifications().size() - 2) {
                stringBuilder.append(clientCache.getListWithAvailableNotifications().get(i)).append(" & ");
            } else if (i == clientCache.getListWithAvailableNotifications().size() - 1) {
                stringBuilder.append(clientCache.getListWithAvailableNotifications().get(i));
            } else {
                stringBuilder.append(clientCache.getListWithAvailableNotifications().get(i)).append(", ");
            }
        }
        return stringBuilder.toString();
    }
}
