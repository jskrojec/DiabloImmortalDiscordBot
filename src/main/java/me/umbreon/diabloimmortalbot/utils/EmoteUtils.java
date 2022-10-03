package me.umbreon.diabloimmortalbot.utils;

import org.jetbrains.annotations.NotNull;

public class EmoteUtils {

    @NotNull
    public static String convertEmoteToUnicode(@NotNull String emote) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < emote.length(); i++) {
            if (Character.isSurrogate(emote.charAt(i))) {
                int res = Character.codePointAt(emote, i);
                i++;
                sb.append("U+").append(Integer.toHexString(res).toUpperCase());
            } else {
                sb.append(emote.charAt(i));
            }
        }

        return sb.toString();
    }
}
