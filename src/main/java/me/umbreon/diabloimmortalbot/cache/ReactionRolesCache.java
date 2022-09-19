package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.ReactionRole;

import java.util.HashMap;
import java.util.Map;

public class ReactionRolesCache {


    // Key: messageID
    private Map<String, ReactionRole> reactionRolesCache = new HashMap<>();

    public Map<String, ReactionRole> getReactionRolesCache() {
        return reactionRolesCache;
    }

    public void setReactionRolesCache(Map<String, ReactionRole> reactionRolesCache) {
        this.reactionRolesCache = reactionRolesCache;
    }

    public void addReactionRoleToList(ReactionRole reactionRole) {
        this.reactionRolesCache.put(reactionRole.getMessageID(), reactionRole);
    }

    public boolean doReactionRoleMessageExists(String messageID) {
        return this.reactionRolesCache.containsKey(messageID);
    }

    public ReactionRole getReactionRoleByMessageID(String messageID) {
        return this.reactionRolesCache.get(messageID);
    }


}
