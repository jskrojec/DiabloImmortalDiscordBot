package me.umbreon.diabloimmortalbot.data;

public class ReactionRole {

    private String messageID;
    private String guildID;
    private String emojiID;
    private String roleID;

    public ReactionRole(String messageID, String guildID, String emojiID, String roleID) {
        this.messageID = messageID;
        this.guildID = guildID;
        this.emojiID = emojiID;
        this.roleID = roleID;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getGuildID() {
        return guildID;
    }

    public void setGuildID(String guildID) {
        this.guildID = guildID;
    }

    public String getEmojiID() {
        return emojiID;
    }

    public void setEmojiID(String emojiID) {
        this.emojiID = emojiID;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
}
