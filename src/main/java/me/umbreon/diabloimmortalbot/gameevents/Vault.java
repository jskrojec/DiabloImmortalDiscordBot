package me.umbreon.diabloimmortalbot.gameevents;

import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.ClientConfig;
import me.umbreon.diabloimmortalbot.utils.Time;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.Map;

public class Vault {

    private final Map<String, Boolean> listVault;
    private final ClientConfig clientConfig;
    private final ClientCache clientCache;

    public Vault(DatabaseRequests databaseRequests, ClientConfig clientConfig, ClientCache clientCache) {
        this.clientConfig = clientConfig;
        this.listVault = databaseRequests.getEventTimes("event_vault", true);
        this.clientCache = clientCache;
    }

    public void checkVault(TextChannel textChannel, String timezone) {
        String time = Time.getTime(timezone);
        if (listVault.get(time) == null) return;

        String roleId = clientCache.getRoleId(textChannel.getId());
        String mentionMessage = "@everyone, ";

        if (roleId != null) {
            Role role = textChannel.getGuild().getRoleById(roleId);
            mentionMessage = role.getAsMention() + ", ";
        }

        if (listVault.get(time)) {
            textChannel.sendMessage(mentionMessage + clientConfig.getVaultHeadUpMessage()).queue();
        } else {
            textChannel.sendMessage(mentionMessage + clientConfig.getVaultMessage()).queue();
        }
    }

}
