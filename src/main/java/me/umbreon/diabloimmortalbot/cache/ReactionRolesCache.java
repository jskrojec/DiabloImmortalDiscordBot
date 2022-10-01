package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.ReactionRole;

import java.util.ArrayList;
import java.util.List;

public class ReactionRolesCache {

    private List<ReactionRole> reactionRolesList = new ArrayList<>();

    public void setReactionRolesCache(List<ReactionRole> reactionRolesList) {
        this.reactionRolesList = reactionRolesList;
    }

    public void addReactionRoleToList(ReactionRole reactionRole) {
        reactionRolesList.add(reactionRole);
    }

    public boolean doReactionRoleMessageExists(String messageID) {
        for (ReactionRole reactionRole : reactionRolesList) {
            if (reactionRole.getMessageID().equalsIgnoreCase(messageID)) {
                return true;
            }
        }
        return false;
    }

    public ReactionRole getReactionRoleByMessageIDAndEmojiID(String messageID, String emojiID) {
        for (ReactionRole reactionRole : reactionRolesList) {
            if (reactionRole.getMessageID().equalsIgnoreCase(messageID)) {
                if (reactionRole.getReactionID().equalsIgnoreCase(emojiID)) {
                    return reactionRole;
                }
            }
        }
        return null;
    }

    public void deleteReactionRoleMessage(final String messageID) {
        for (ReactionRole reactionRole : reactionRolesList) {
            if (reactionRole.getMessageID().equalsIgnoreCase(messageID)) {
                reactionRolesList.remove(reactionRole);
                break;
            }
        }
    }

    public void deleteReactionRole(final String messageID, final String codifiedEmote) {
        for (ReactionRole reactionRole : reactionRolesList) {
            String tmpListMessageID = reactionRole.getMessageID();
            String tmpListCodifiedEmote = reactionRole.getReactionID();
            if (tmpListMessageID.equalsIgnoreCase(messageID) && tmpListCodifiedEmote.equalsIgnoreCase(codifiedEmote)) {
                reactionRolesList.remove(reactionRole);
                break;
            }
        }
    }

}
