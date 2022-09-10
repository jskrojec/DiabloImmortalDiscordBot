# Diablo Immortal Discord Bot

Discord Bot for Diablo Immortal. Sends a message on events.

## Installation:

You can skip step 2 and 3 if you're the server owner.

1. Add the Bot to your Discord Server
   using: https://discord.com/oauth2/authorize?client_id=527511535309029407&scope=bot&permissions=8
2. Create a role on your discord server called "Bot Admin". People with that role can control the bot.
3. Assign the created role (Bot Admin) to yourself! The bot checks on that role.
4. Create a textchannel you like to get the notifications in.
5. Use /server timezone <timezone> to set your timezone. You can see what GMT timezone matches your time using
   /timezones.
6. Register your created channel as notifier-channel using /register. On Default all messages are enabled.
7. You can enable or disable an event using /event <event> on/off. See all events using /event list.
8. See what events are enabled using /info.
9. On default the bot will mention @everyone, change that using /role <Role>.
10. That's it. use /help to see all commands. And to unregister a channel use /unregister.

## Commands:

| Command | Description |
|------|------|
|/register #channel | Register the channel you send the message in using /register and to register a different channel using /register #channel.
|/unregister #channel | Unregister the channel you send the message in using /unregister and to unregister a different channel using /unregister #channel.
|/role @role | Change the mentioned role in that channel you send the message in. You do not need to mention the role. Just write the exact name.
|/info #channel | Shows the info of the channel where the message is send in or using /info #channel to see a different channels information.
|/cm create | Guides you through the creating process of creating an own notification message
|/cm list | Shows you all in the guild existing custom messages.
|/cm info [ID] | Shows you all information about that custom message. Use >cm list to see all your custom messages
|/cm delete [ID] | Deletes that custom message with the given ID. See all your custom messages ID's using /cm list.
|/event [event] on/off | Enables or disables that event for this channel the message is send in. Use /event list to see all events.
|/event list | Shows all currently Diablo Immortal Events you can disable or enable.
|/server autodelete on/off | Enables or disables auto delete messages. Sent notification message will automatically deleted after a given amount of time.
|/server autodelete 24/48/72 | Sets the amount of hours for the auto delete. Available:  24, 48 & 72
|timezone [Timezone] | Default timezone is GMT. GMT is known as a working timezone for this bot.
|/server headup on/off | Enables or disables the 15 minutes pre warning message.
|/server messsage on/off | Enables or disables the starting event message.
|/server config | Shows you all server configs.
|/help | Shows bot commands.
|/install | Shows bot instructions.
|/languages | Shows all available languages.
|/timezones | Shows all the GMT timezones so you can pick that timezone what matches you.

## Languages

English, French, German, Indonesia, Italian, Russian, Spain

All languages will be added with the help of the community. Hit me up on Discord if you want to add a new language.

## Permissions the bot need:

Manage Messages, Send Messages,