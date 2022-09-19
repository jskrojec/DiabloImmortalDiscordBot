package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.ReactionRolesCache;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import net.dv8tion.jda.api.events.message.MessageDeleteEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

/**
 * @author Umbreon Majora
 *
 * Description: Deletes all stored information when the message gets deleted.
 */
public class MessageDelete extends ListenerAdapter {

    private final DatabaseRequests databaseRequests;
    private final ReactionRolesCache reactionRolesCache;

    public MessageDelete(ReactionRolesCache reactionRolesCache, DatabaseRequests databaseRequests) {
        this.reactionRolesCache = reactionRolesCache;
        this.databaseRequests = databaseRequests;
    }

    @Override
    public void onMessageDelete(final @NotNull MessageDeleteEvent event) {
        String messageID = event.getMessageId();

        if (reactionRolesCache.doReactionRoleMessageExists(messageID)) {
            databaseRequests.deleteReactionRole(messageID);
        }
    }
}
