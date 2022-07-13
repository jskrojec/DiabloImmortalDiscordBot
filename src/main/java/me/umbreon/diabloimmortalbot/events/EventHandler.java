package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class EventHandler implements EventListener {

    private final MessageReceived messageReceived;

    public EventHandler(DatabaseRequests databaseRequests, ClientCache clientCache) {
        this.messageReceived = new MessageReceived(databaseRequests, clientCache);
    }

    @Override
    public void onEvent(@NotNull GenericEvent event) {

        try {
            if (event instanceof MessageReceivedEvent) {
                Member member = ((MessageReceivedEvent) event).getMember();
                messageReceived.onMessageReceivedEvent((MessageReceivedEvent) event, member);
            }
        } catch (Exception e) {
            ClientLogger.createNewLogEntry("0" , "null", "0", String.valueOf(e));
        }

    }
}
