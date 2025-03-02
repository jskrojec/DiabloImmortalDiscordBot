# Diablo Immortal Discord Bot

Discord Bot for Diablo Immortal. Sends a message on events. Also has features like reaction roles and custom
notifications. Support and more on discord: https://discord.gg/ta4HxP6nz4

### Installation:

You can skip step 2 and 3 if you're the server owner.

1. Add the Bot to your Discord Server
   using: https://discord.com/api/oauth2/authorize?client_id=527511535309029407&permissions=543850757184&scope=bot%20applications.commands
2. Create a role on your discord server called "Bot Admin". People with that role can control the bot.
3. Assign the created role (Bot Admin) to yourself! The bot checks on that role.
4. Create a textchannel you like to get the notifications in.
5. Use /timezone [timezone] to set your timezone. You can see what GMT timezone matches your time using /timezones.
6. Register your created channel as notifier-channel using /register. On Default all messages are enabled.
7. You can enable or disable an event using /event [game_event] on/off. See all events using /listevents.
8. See what events are enabled using /info.
9. On default the bot will mention @everyone, change that using /mentionrole [role].
10. That's it. use /help to see all commands. And to unregister a channel use /unregister.

#### How do I create a custom notification?

Custom Notifications are created with the command /createcustommessage and it has 4 parameters. 1. Weekday 2. Time 3.
Should the message be repeated every week 4. Your notification message.

Here's a command example:
/createcustommessage custommessageweekday:Monday custommessagetime:11:11 custommessagerepeating:True
custommessagemessage:test

This creates a custom notification on Monday at 11:11 (24hrs time) which repeats every monday with the message "test".
The message will be send in the channel where the command is executed.

#### How do I create a reaction role?

Reaction roles are created with the command /createreactionrole and it has 3 parameters. 1. The message ID 2. The role

3. The emoji

Here's a command example:
/createreactionrole messageid:1010156270117990450 role:@Role emote::Umbreon:

This creates a reaction role with the emoji :Umbreon:  and it gives the role @Role.

Here's a discord article on how you can get any ID'
s. https://support.discord.com/hc/en-us/articles/206346498-Where-can-I-find-my-User-Server-Message-ID-

## Commands:

| Command | Description |
|------|------|
|/register [CHANNEL] | Register the channel you send the message in using /register and to register a different channel using /register #channel.
|/unregister [CHANNEL] | Unregister the channel you send the message in using /unregister and to unregister a different channel using /unregister #channel.
|/mentionrole [ROLE] | Change the mentioned role in that channel you send the message in. You do not need to mention the role. Just write the exact name.
|/info [CHANNEL] | Shows the info of the channel where the message is send in or using /info #channel to see a different channels information.
|/createcustommessage [WEEKDAY] [TIME] [BOOL_REPEATING] [MESSAGE] | Guides you through the creating process of creating an own notification message
|/listcustommessages | Shows you all in the guild existing custom messages.
|/custommessageinfo [ID] | Shows you all information about that custom message. Use >cm list to see all your custom messages
|/deletecustommessage [ID] | Deletes that custom message with the given ID. See all your custom messages ID's using /cm list.
|/event [event] on/off | Enables or disables that event for this channel the message is send in. Use /event list to see all events.
|/listevents | Shows all currently Diablo Immortal Events you can disable or enable.
|/timezone [Timezone] | Default timezone is GMT. GMT is known as a working timezone for this bot.
|/server headup on/off | Enables or disables the 15 minutes pre warning message.
|/server messsage on/off | Enables or disables the starting event message.
|/config | Shows you all server configs.
|/help | Shows bot commands.
|/install | Shows bot instructions.
|/languages | Shows all available languages.
|/timezones | Shows all the GMT timezones so you can pick that timezone what matches you.
|/today | Shows all current date's events
|/upcoming | Shows all upcoming events from current date

## Languages

English, French, German, Indonesia, Italian, Russian, Spain & Brazilian Portuguese

All languages will be added with the help of the community. Hit me up on Discord if you want to add a new language.
