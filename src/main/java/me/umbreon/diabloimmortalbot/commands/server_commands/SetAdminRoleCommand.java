package me.umbreon.diabloimmortalbot.commands.server_commands;

import me.umbreon.diabloimmortalbot.cache.GuildsCache;
import me.umbreon.diabloimmortalbot.commands.ClientCommand;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientLogger;
import me.umbreon.diabloimmortalbot.utils.StringUtils;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static me.umbreon.diabloimmortalbot.utils.StringUtils.*;

/**
 * @author Umbreon Majora
 * <p>
 * Command: /adminrole @Role
 * <p>
 * Description: Allow's the user to set a custom bot admin role.
 */
public class SetAdminRoleCommand implements ClientCommand {

    private final Logger LOGGER = LoggerFactory.getLogger(SetAdminRoleCommand.class);

    private final GuildsCache guildsCache;
    private final DatabaseRequests databaseRequests;

    public SetAdminRoleCommand(GuildsCache guildsCache, DatabaseRequests databaseRequests) {
        this.guildsCache = guildsCache;
        this.databaseRequests = databaseRequests;
    }

    @Override
    public void runCommand(SlashCommandInteraction event) {
        String guildID = event.getGuild().getId();
        String commandExecutor = event.getUser().getName() + "#" + event.getUser().getDiscriminator();
        String logMessage;

        OptionMapping optionMapping = event.getOption("role");
        if (optionMapping == null) {
            logMessage = String.format(ADMIN_ROLE_UPDATE_FAILED_LOG_MESSAGE, commandExecutor, guildID);
            LOGGER.info(logMessage);
            ClientLogger.createNewServerLogEntry(guildID, logMessage);

            replyEphemeralToUser(event, ADMIN_ROLE_UPDATE_FAILED_USER_MESSAGE);
            return;
        }

        Role newAdminRole = optionMapping.getAsRole();
        String newAdminRoleID = newAdminRole.getId();

        guildsCache.updateGuildAdminRole(guildID, newAdminRoleID);
        databaseRequests.updateGuildAdminRole(guildID, newAdminRoleID);

        logMessage = String.format(ADMIN_ROLE_UPDATED_LOG_MESSAGE, commandExecutor, guildID, newAdminRole);
        LOGGER.info(logMessage);
        ClientLogger.createNewServerLogEntry(guildID, logMessage);

        replyEphemeralToUser(event, String.format(StringUtils.updatedAdminRoleMessage, newAdminRole));
    }

}
