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

| Command | Description | Aliases |
|------|------|------|
|/register #channel | Register the channel you send the message in using /register and to register a different channel using /register #channel.|
|/unregister #channel | Unregister the channel you send the message in using /unregister and to unregister a different channel using /unregister #channel. |
|/role @role | Change the mentioned role in that channel you send the message in. You do not need to mention the role. Just write the exact name. |
|info #channel | Shows the info of the channel where the message is send in or using /info #channel to see a different channels information.
|

|/server timezone <Timezone> | Default timezone is GMT. GMT is known as a working timezone for this bot. | /server
tz <timezone> | |/

Custom messages create command time must be given in 24hrs format.

## Languages

- ENG
- GER
- ESP
- POL
- ITA
- FRA

## Available Status

- 0 = All messages
- 1 = Only Overworld
- 2 = Immortal event messages
- 3 = Shadow event messages
- 4 = Immortal with overworld messages
- 5 = Shadow with overworld messages
- 6 = Empty. Could be used for custom messages.
- (Embed messages does not ping!)
- 7 = Immortal with overworld embed messages.
- 8 = Shadow with overworld embed messages.
- 9 = Overworld embed messages.
