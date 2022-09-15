package me.umbreon.diabloimmortalbot.events;

import me.umbreon.diabloimmortalbot.commands.DebugCommand;
import me.umbreon.diabloimmortalbot.commands.TimezoneCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.InfoCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.RegisterCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.RoleCommand;
import me.umbreon.diabloimmortalbot.commands.channel_commands.UnregisterCommand;
import me.umbreon.diabloimmortalbot.commands.custom_messages.CreateCustomMessageCommand;
import me.umbreon.diabloimmortalbot.commands.custom_messages.CustomMessageInfo;
import me.umbreon.diabloimmortalbot.commands.custom_messages.DeleteCustomMessage;
import me.umbreon.diabloimmortalbot.commands.custom_messages.ListCustomMessagesCommand;
import me.umbreon.diabloimmortalbot.commands.event_commands.EventCommand;
import me.umbreon.diabloimmortalbot.commands.guilds_commands.ServerCommand;
import me.umbreon.diabloimmortalbot.commands.help_commands.*;
import me.umbreon.diabloimmortalbot.data.GuildInformation;
import me.umbreon.diabloimmortalbot.database.DatabaseRequests;
import me.umbreon.diabloimmortalbot.utils.ClientCache;
import me.umbreon.diabloimmortalbot.utils.StringAssistant;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.exceptions.InsufficientPermissionException;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Umbreon Majora
 */
public class SlashCommandInteraction extends ListenerAdapter {

    private final ClientCache clientCache;
    private final DatabaseRequests databaseRequests;

    private final RegisterCommand registerCommand;
    private final UnregisterCommand unregisterCommand;
    private final RoleCommand roleCommand;
    private final InfoCommand infoCommand;
    private final HelpCommand helpCommand;
    private final TimezonesCommand timezonesCommand;
    private final LanguagesCommand languagesCommand;
    private final InstructionCommand instructionCommand;
    private final DeleteCommand deleteCommand;
    private final TimezoneCommand timezoneCommand;

    //CustomMessage
    private final DeleteCustomMessage deleteCustomMessage;
    private final CustomMessageInfo customMessageInfo;
    private final ListCustomMessagesCommand listCustomMessagesCommand;
    private final CreateCustomMessageCommand createCustomMessageCommand;

    private final EventCommand eventCommand;
    private final ServerCommand serverCommand;

    private final DebugCommand debugCommand;

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    public SlashCommandInteraction(final ClientCache clientCache, final DatabaseRequests databaseRequests) {
        this.clientCache = clientCache;
        this.databaseRequests = databaseRequests;

        this.registerCommand = new RegisterCommand(databaseRequests, clientCache);
        this.unregisterCommand = new UnregisterCommand(databaseRequests, clientCache);
        this.roleCommand = new RoleCommand(databaseRequests, clientCache);
        this.infoCommand = new InfoCommand(clientCache);
        this.helpCommand = new HelpCommand(clientCache);
        this.instructionCommand = new InstructionCommand(clientCache);
        this.timezonesCommand = new TimezonesCommand(clientCache);
        this.languagesCommand = new LanguagesCommand();
        this.deleteCommand = new DeleteCommand(databaseRequests, clientCache);
        this.timezoneCommand = new TimezoneCommand(databaseRequests, clientCache);

        //CustomMessage
        this.deleteCustomMessage = new DeleteCustomMessage(clientCache, databaseRequests);
        this.customMessageInfo = new CustomMessageInfo(clientCache);
        this.listCustomMessagesCommand = new ListCustomMessagesCommand(clientCache);
        this.createCustomMessageCommand = new CreateCustomMessageCommand(clientCache, databaseRequests);

        this.eventCommand = new EventCommand(clientCache, databaseRequests);
        this.serverCommand = new ServerCommand(clientCache, databaseRequests);

        this.debugCommand = new DebugCommand(clientCache);
    }

    @Override
    public void onSlashCommandInteraction(@NotNull final SlashCommandInteractionEvent event) {
        try {
            if (!isChannelTypeTextChannel(event.getChannel().getType())) {
                return;
            }

            String[] args = transformNewCommandStyleToOld(event.getCommandString().split(" "));
            String guildID = event.getGuild().getId();
            registerGuildIfDoNotExist(guildID);
            Member member = event.getMember();
            TextChannel textChannel = event.getTextChannel();
            Guild guild = event.getGuild();

            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(args).forEach(s -> stringBuilder.append(s).append(" "));
            LOGGER.info(Objects.requireNonNull(event.getMember()).getEffectiveName() + " " +
                    event.getUser().getDiscriminator() + " used " + stringBuilder);

            if (hasUserAdminPrivileges(member) || isServerOwner(member)) {
                executeCommand(event, args, guildID, member, textChannel, guild);
                return;
            }

            if (hasUserManageMessagesPrivileges(member)) {
                executeNonPermsNeededCommands(event, args, textChannel);
            }
        } catch (InsufficientPermissionException e) {
            event.getUser().openPrivateChannel().queue(privateChannel ->
                    privateChannel.sendMessage(e.getMessage()).queue()
            );
        }
    }

    private void executeNonPermsNeededCommands(@NotNull SlashCommandInteractionEvent event, String[] args, TextChannel textChannel) {
        switch (args[0].toLowerCase()) {
            case "/help":
                helpCommand.runHelpCommand(textChannel);
                event.reply("Sent message!").queue();
                break;
            case "/instructions":
            case "/instruction":
            case "/install":
                instructionCommand.runInstructionCommand(textChannel);
                event.reply("Sent message!").queue();
                break;
        }
    }

    private void executeCommand(@NotNull SlashCommandInteractionEvent event, String[] args, String guildID, Member member,
                                TextChannel textChannel, Guild guild) {
        String response;
        switch (args[0].toLowerCase()) {
            //custom messages commands
            case "/createcustommessage":
                event.reply(createCustomMessageCommand.runCreateCustomMessageCommand(args, textChannel)).queue();
                break;
            case "/deletecustommessage":
                event.reply(deleteCustomMessage.runDeleteCustomMessage(args, textChannel)).queue();
                break;
            case "/custommessageinfo":
                event.replyEmbeds(customMessageInfo.runCustomMessageInfoCommand(args)).queue();
                break;
            case "/listcustommessages":
                event.replyEmbeds(listCustomMessagesCommand.runListCustomMessages(textChannel)).queue();
                break;
                //channel commands
            case "/register":
                registerCommand.runRegisterCommand(args, textChannel, event);
                break;
            case "/unregister":
                response = unregisterCommand.runUnregisterCommand(args, textChannel, guild);
                if (response != null) event.reply(response).queue();
                break;
            case "/role":
                response = roleCommand.runRoleCommand(args, textChannel, guild);
                if (response != null) event.reply(response).queue();
                break;
            case "/info":
                infoCommand.runInfoCommand(args, textChannel, event);
                break;
            case "/help":
                helpCommand.runHelpCommand(textChannel);
                event.reply("Sent message!").queue();
                break;
            case "/instructions":
            case "/instruction":
            case "/install":
                instructionCommand.runInstructionCommand(textChannel);
                event.reply("Sent message!").queue();
                break;
            case "/event":
                response = eventCommand.runEventCommand(args, textChannel);
                if (response != null) event.reply(response).queue();
                break;
            case "/server":
                response = serverCommand.runServerCommand(args, textChannel, member);
                if (response != null) event.reply(response).queue();
                break;
            case "/timezones":
                timezonesCommand.runTimezonesCommand(args, textChannel);
                event.reply("Sent message!").queue();
                break;
            case "/timezone":
                response = timezoneCommand.runTimezoneCommand(args, textChannel);
                if (response != null) event.reply(response).queue();
                break;
            case "/languages":
                languagesCommand.runLanguagesCommand(textChannel);
                event.reply("Sent message!").queue();
                break;
            case "/debugone":
                event.reply(debugCommand.debugMessage1(args[1])).queue();
                break;
            case "/debugtwo":
                event.reply(debugCommand.debugMessage2(args[1])).queue();
                break;
            case "/debugthree":
                event.reply(debugCommand.debugMessage3(textChannel.getId())).queue();
                break;
            case "/deleteme":
                deleteCommand.runDeleteCommand(guildID);
                Objects.requireNonNull(event.getMember()).getUser().openPrivateChannel().queue(privateChannel -> {
                    privateChannel.sendMessage("Removed everything.").queue();
                });

                event.reply("Removed everything.").queue();
                event.getJDA().getGuilds().forEach(guild1 -> {
                    if (guild1.getId().equalsIgnoreCase(event.getGuild().getId())) {
                        guild1.leave().queue();
                    }
                });
        }
    }

    private String[] transformNewCommandStyleToOld(final String[] tmpArgs) {
        List<String> tmpList = Arrays.stream(tmpArgs)
                .filter(s -> !s.contains(":") || StringAssistant.isStringInTimePattern(s))
                .collect(Collectors.toList());
        StringBuilder stringBuilder = new StringBuilder();
        tmpList.forEach(string -> stringBuilder.append(string).append(" "));
        return stringBuilder.toString().split(" ");
    }

    private boolean isChannelTypeTextChannel(final ChannelType channelType) {
        return channelType.getId() == 0;
    }

    private void registerGuildIfDoNotExist(final String guildID) {
        if (!clientCache.doGuildExists(guildID)) {
            final GuildInformation guildInformation = new GuildInformation(guildID);
            clientCache.addGuildInformation(guildInformation);
            databaseRequests.createNewGuildEntry(guildInformation);
        }
    }

    private boolean hasUserManageMessagesPrivileges(final Member member) {
        return member.hasPermission(Permission.MESSAGE_MANAGE);
    }

    private boolean hasUserAdminPrivileges(final Member member) {
        final List<Role> roles = member.getRoles();
        final Role tempRole = roles.stream()
                .filter(role -> role.getName().equalsIgnoreCase("Bot Admin"))
                .findFirst()
                .orElse(null);
        return tempRole != null;
    }

    private boolean isServerOwner(final Member member) {
        return member.isOwner();
    }
}
