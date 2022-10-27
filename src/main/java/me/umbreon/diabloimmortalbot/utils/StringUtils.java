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
    public static String receivedRoleMessage = "You've got the %s role.";
    public static String lostRoleMessage = "You've lost the role %s.";
    public static String presetSetMessage = "Enabled preset %s on channel %s";
    public static String invalidPresetMessage = "Preset %s do not exists.";
    public static String updatedAdminRoleMessage = "The new bot admin role is %s.";

    public static String ADMIN_ROLE_UPDATED_LOG_MESSAGE = "%s updated admin role id from %s to %s";
    public static String ADMIN_ROLE_UPDATE_FAILED_LOG_MESSAGE = "%s tried to update the admin role id from %s but it " +
            "failed because %s was null.";
    public static String ADMIN_ROLE_UPDATE_FAILED_USER_MESSAGE = "Failed to update admin role, new admin role can't " +
            "be null.";

    private static final String DIABLO_IMMORTAL_LOGO;
    private static final String DIABLO_ANCIENT_NIGHTMARE;
    private static final String DIABLO_HAUNTED_CARRIAGE;
    private static final String DIABLO_ANCIENT_ARENA;
    private static final String DIABLO_DEMON_GATES;

    static {
        DIABLO_IMMORTAL_LOGO = "https://d1oinwhu0i67tc.cloudfront.net/images/nav-icon.c0f6fcf3e2cc6a668469ce3f4661212158627097.png";
        DIABLO_ANCIENT_NIGHTMARE = "https://assets.maxroll.gg/wordpress/ZoneEvents_Ancient_v1.1.jpg";
        DIABLO_HAUNTED_CARRIAGE = "https://assets.maxroll.gg/wordpress/ZoneEvents_Ashwold_v1.1.jpg";
        DIABLO_ANCIENT_ARENA = "https://assets.maxroll.gg/wordpress/ZoneEvents_Arena_v1.1.jpg";
        DIABLO_DEMON_GATES = "https://media.diablofans.com/attachments/23/560/screenshot-2022-05-28-204043.jpg";
    }

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

    public static boolean isStringInTimePattern(final String string) {
        return string.matches("^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$");
    }

    public static boolean isStringSingleDashWithDigits(final String string) {
        return string.matches("-[0-9]+");
    }

    public static String getDiabloImmortalLogo() {
        return DIABLO_IMMORTAL_LOGO;
    }

    public static String getDiabloAncientNightmare() {
        return DIABLO_ANCIENT_NIGHTMARE;
    }

    public static String getDiabloHauntedCarriage() {
        return DIABLO_HAUNTED_CARRIAGE;
    }

    public static String getDiabloAncientArena() {
        return DIABLO_ANCIENT_ARENA;
    }

    public static String getDiabloDemonGates() {
        return DIABLO_DEMON_GATES;
    }
}
