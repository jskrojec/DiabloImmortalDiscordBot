# Diablo Immortal Discord Bot
Discord Bot for Diablo Immortal. Sends a message on events.

## Installation:
1. Add the Bot to your Discord Server using: https://discord.com/oauth2/authorize?client_id=527511535309029407&scope=bot&permissions=8
2. Create a role on your discord server called "Bot Admin". People with that role can control the bot.
3. Assign the created role (Bot Admin) to yourself! Not to the bot!
4. Create a textchannel u like to get the notifications in.

## Commands:


| Command | Description |
|------|------|
|>register                       |Registers that channel as notifier-channel.| 
|>unregister                     |Unregisters that channel as notifier-channel.| 
|>timezone GMT                   |Sets the timezone of the notifier-channel. Default: GMT
|>status 7                       |Sets what messages will appear. Later that command will be replaced with >notifications. Default: 0|
|>role @Your_role                |Sets what role should get mentioned. Default: @everyone| 
|>language ENG                   |Sets the bot language for your server. See more in 'Languages'| 
|>headup                         |Enabled or disables the 15 minutes warm up message.| 
|>ctz GMT+2                      |Short form for >checktimezone. Returns a message with the time in that timezone.                     | 
|>whatismychannelid              |Returns that channelID. Used for bug reporting!| 
|>instructions                   |Shows how to install the bot on your server.| 
|>help                           |Shows the help message.| 
|>notifications battlegrounds off|Allows you the individually enable or disable events.| 

## Languages

- ENG
- GER
- ESP
- POL
- ITA
- FRA

##Available Status

- 0 = All messages
- 1 = Only Overworld
- 2 = Immortal event messages
- 3 = Shadow event messages
- 4 = Immortal with overworld messages
- 5 = Shadow with overworld messages
- (Embed messages does not ping!)
- 7 = Immortal with overworld embed messages.
- 8 = Shadow with overworld embed messages.
- 9 = Overworld embed messages.
