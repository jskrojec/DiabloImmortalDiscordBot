package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.cache.*;
import me.umbreon.diabloimmortalbot.commands.channel_commands.InfoCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.RegisterCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.RoleCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.UnregisterCommand;
import me.umbreon.diabloimmortalbot.commands.custom_messages.CreateCustomMessageCommand;
import me.umbreon.diabloimmortalbot.commands.custom_messages.CustomMessageInfo;
import me.umbreon.diabloimmortalbot.commands.custom_messages.DeleteCustomMessage;
import me.umbreon.diabloimmortalbot.commands.custom_messages.ListCustomMessagesCommand;
import me.umbreon.diabloimmortalbot.commands.event_commands.ChangeEventValueCommand;
import me.umbreon.diabloimmortalbot.commands.event_commands.EventListCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ConfigCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.HelpCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.InstructionCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.LanguagesCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.TimezonesCommand;
import me.umbreon.diabloimmortalbot.commands.reaction_commands.CreateReactionMessageCommand;
import me.umbreon.diabloimmortalbot.commands.reaction_commands.RemoveReactionCommand;
import me.umbreon.diabloimmortalbot.commands.server_commands.LanguageCommand;
import me.umbreon.diabloimmortalbot.commands.server_commands.TimezoneCommand;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * @author Umbreon Majora
 */
public class SlashCommandInteraction extends ListenerAdapter {

    private final ClientCache clientCache;
    private final ReactionRolesCache reactionRolesCache;
    private final DatabaseRequests databaseRequests;
    private final GuildsCache guildsCache;
    private final NotificationChannelsCache notificationChannelsCache;

    // channel commands
    private final RegisterCommand registerCommand;
    private final UnregisterCommand unregisterCommand;
    private final RoleCommand roleCommand;
    private final InfoCommand infoCommand;

    // help commands
    private final HelpCommand helpCommand;
    private final TimezonesCommand timezonesCommand;
    private final LanguagesCommand languagesCommand;
    private final InstructionCommand instructionCommand;

    // custom messages commands
    private final DeleteCustomMessage deleteCustomMessage;
    private final CustomMessageInfo customMessageInfo;
    private final ListCustomMessagesCommand listCustomMessagesCommand;
    private final CreateCustomMessageCommand createCustomMessageCommand;

    // event commands
    private final EventListCommand eventListCommand;
    private final ChangeEventValueCommand changeEventValueCommand;

    // server commands
    private final ConfigCommand configCommand;
    private final TimezoneCommand timezoneCommand;
    private final LanguageCommand languageCommand;

    // reaction roles commands
    private final CreateReactionMessageCommand createReactionMessageCommand;
    private final RemoveReactionCommand removeReactionCommand;

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    public SlashCommandInteraction(final ClientCache clientCache,
                                   final DatabaseRequests databaseRequests,
                                   final ReactionRolesCache reactionRolesCache,
                                   final GuildsCache guildsCache,
                                   final NotificationChannelsCache notificationChannelsCache,
                                   final CustomMessagesCache customMessagesCache) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;
        this.reactionRolesCache = reactionRolesCache;
        this.guildsCache = guildsCache;
        this.notificationChannelsCache = notificationChannelsCache;


        // channel commands
        this.registerCommand = new RegisterCommand(databaseRequests, guildsCache, notificationChannelsCache);
        this.unregisterCommand = new UnregisterCommand(databaseRequests, clientCache, guildsCache, notificationChannelsCache);
        this.roleCommand = new RoleCommand(databaseRequests, clientCache, guildsCache, notificationChannelsCache);
        this.infoCommand = new InfoCommand(guildsCache, notificationChannelsCache);

        // help commands
        this.helpCommand = new HelpCommand(clientCache, guildsCache);
        this.instructionCommand = new InstructionCommand(clientCache, guildsCache);
        this.timezonesCommand = new TimezonesCommand(clientCache, guildsCache);
        this.languagesCommand = new LanguagesCommand();

        // custom messages commands
        this.customMessageInfo = new CustomMessageInfo(clientCache, customMessagesCache);
        this.deleteCustomMessage = new DeleteCustomMessage(clientCache, databaseRequests, guildsCache, customMessagesCache);
        this.listCustomMessagesCommand = new ListCustomMessagesCommand(clientCache, guildsCache, customMessagesCache);
        this.createCustomMessageCommand = new CreateCustomMessageCommand(clientCache, databaseRequests, customMessagesCache, guildsCache);

        // event commands
        this.eventListCommand = new EventListCommand(clientCache);
        this.changeEventValueCommand = new ChangeEventValueCommand(clientCache, databaseRequests, guildsCache, notificationChannelsCache);

        // server commands
        this.configCommand = new ConfigCommand(clientCache, guildsCache);
        this.timezoneCommand = new TimezoneCommand(databaseRequests, clientCache, guildsCache);
        this.languageCommand = new LanguageCommand(clientCache, databaseRequests, guildsCache);

        // reaction roles commands
        this.createReactionMessageCommand = new CreateReactionMessageCommand(reactionRolesCache, databaseRequests);
        this.removeReactionCommand = new RemoveReactionCommand(reactionRolesCache, databaseRequests);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull final SlashCommandInteractionEvent event) {
        try {

            String guildID = event.getGuild().getId();
            registerGuildIfDoNotExist(guildID);

            if (!isChannelTypeTextChannel(event.getChannel().getType())) {
                return;
            }
            Member member = event.getMember();

            LOGGER.info(member.getEffectiveName() + "#" + event.getUser().getDiscriminator() + " used " + event.getCommandString());

            if (hasUserAdminPrivileges(member) || isServerOwner(member)) {
                switch (event.getName().toLowerCase()) {
                    // custom messages commands
                    case "createcustommessage":
                        createCustomMessageCommand.runCreateCustomMessageCommand(event);
                        break;
                    case "deletecustommessage":
                        deleteCustomMessage.runDeleteCustomMessage(event);
                        break;
                    case "custommessageinfo":
                        customMessageInfo.runCustomMessageInfoCommand(event);
                        break;
                    case "listcustommessages":
                        listCustomMessagesCommand.runListCustomMessages(event);
                        break;
                    //channel commands
                    case "register":
                        registerCommand.runRegisterCommand(event);
                        break;
                    case "unregister":
                        unregisterCommand.runUnregisterCommand(event);
                        break;
                    case "mentionrole":
                        roleCommand.runMentionRoleCommand(event);
                        break;
                    case "info":
                        infoCommand.runInfoCommand(event);
                        break;
                    //help commands
                    case "help":
                        helpCommand.runHelpCommand(event);
                        break;
                    case "install":
                        instructionCommand.runInstructionCommand(event);
                        break;
                    case "languages":
                        languagesCommand.runLanguagesCommand(event);
                        break;
                    case "timezones":
                        timezonesCommand.runTimezonesCommand(event);
                        break;
                    //Event Commands
                    case "event":
                        changeEventValueCommand.runChangeEventValueCommand(event);
                        break;
                    case "listevents":
                        eventListCommand.runEventListCommand(event);
                        break;
                    // server commands
                    case "timezone":
                        timezoneCommand.runTimezoneCommand(event);
                        break;
                    case "language":
                        languageCommand.runLanguageCommand(event);
                        break;
                    case "config":
                        configCommand.runConfigCommand(event);
                        break;
                    // reaction roles commands
                    case "createreactionrole":
                        createReactionMessageCommand.runCreateReactionMessageCommand(event);
                        break;
                    case "removereactionrole":
                        removeReactionCommand.runRemoveReactionCommand(event);
                        break;
                }
            }

        } catch (InsufficientPermissionException e) {
            event.getUser().openPrivateChannel().queue(privateChannel -> {
                privateChannel.sendMessage(e.getMessage()).queue();
            });
        }
    }

    private boolean isChannelTypeTextChannel(final ChannelType channelType) {
        return channelType.getId() == 0;
    }

    private void registerGuildIfDoNotExist(final String guildID) {
        if (!guildsCache.doGuildExists(guildID)) {
            GuildInformation guildInformation = new GuildInformation(guildID);
            guildsCache.addGuildInformation(guildInformation);
            databaseRequests.createNewGuildEntry(guildInformation);
        }
    }

    private boolean hasUserAdminPrivileges(final Member member) {
        List<Role> roles = member.getRoles();
        Role tempRole = roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
        return tempRole != null;
    }

    private boolean isServerOwner(final Member member) {
        return member.isOwner();
    }
}
