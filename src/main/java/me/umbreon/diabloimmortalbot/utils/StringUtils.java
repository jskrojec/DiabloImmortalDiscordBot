package me.umbreon.diabloimmortalbot.utils;

public class StringUtils {

    public static String messageIdNullError = "Failed to create a new reaction role. The message ID was empty.";
    public static String roleNullError = "Failed to create a new reaction role. The role was empty.";
    public static String emoteNullError = "Failed to create a new reaction role. The emote was empty.";
    public static String emoteAlreadyInUseError = "Failed to create a new reaction role. The emote was already in use.";
    public static String maxAmountOfReactionRolesReachedError = "Failed to crate a new reaction role. The max amount of reaction roles was reached.";
    public static String messageNotFoundError = "Failed to create a new reaction role. The message couldn't be found.";
    public static String roleHasAdminPermissionsError = "Failed to create a new reaction role. The role has admin permissions. This is disabled for safety reasons.";
    public static String emojiCodeNullError = "Failed to create a new reaction role. The emoji code was null. Please report that to an developer.";
    public static String reactionRoleCreatedMessage = "Created a new reaction role use /reactionroleslist to see all your reaction roles";

    public static String roleReceivedMessage = "You received role %s";

    public static String convertEmojiToUnicode(String emoji) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < emoji.length(); i++) {
            if (Character.isSurrogate(emoji.charAt(i))) {
                int res = Character.codePointAt(emoji, i);
                i++;
                sb.append("U+").append(Integer.toHexString(res).toUpperCase());
            } else {
                sb.append(emoji.charAt(i));
            }
        }

        return sb.toString();
    }
}
