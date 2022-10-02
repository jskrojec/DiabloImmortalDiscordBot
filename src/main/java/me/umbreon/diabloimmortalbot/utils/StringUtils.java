package me.umbreon.diabloimmortalbot.utils;

public class StringUtils {

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
