package me.umbreon.diabloimmortalbot.events;

import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TextChannelDelete extends ListenerAdapter {

    @Override
    public void onChannelDelete(ChannelDeleteEvent event) {
        if (event.getChannelType().getId() == 0) {
            System.out.println("CHANNEL DELETED");
        }
    }
}
