package me.umbreon.diabloimmortalbot.cache;

import me.umbreon.diabloimmortalbot.data.ReactionRole;
import org.jetbrains.annotations.NotNull;

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

    public ReactionRole getReactionRoleByMessageIDAndEmojiID(String messageID, String emojiCode) {
        for (ReactionRole reactionRole : reactionRolesList) {
            System.out.println(reactionRole.getReactionID() + reactionRole.getMessageID());
            if (reactionRole.getMessageID().equals(messageID)) {
                if (reactionRole.getReactionID().equals(emojiCode)) {
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

    public int getReactionRolesAmountFromMessage(@NotNull String messageID) {
        int amount = 0;
        for (ReactionRole reactionRole : reactionRolesList) {
            if (reactionRole.getMessageID().equals(messageID)) {
                amount++;
            }
        }
        return amount;
    }

}
