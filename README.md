# Diablo Immortal Discord Bot
Discord Bot for Diablo Immortal. Sends a message on events.

📄 License
MIT © [Umbreon Majora](https://github.com/UmbreonMajora/DiabloImmortalDiscordBot/blob/main/LICENSE.md)

Install:
1. Add the Bot to your Discord Server using: https://discord.com/oauth2/authorize?client_id=527511535309029407&scope=bot&permissions=8
2. Create a role on your discord server called "Bot Admin". People with that role can control the bot.
3. Assign the created role (Bot Admin) to yourself! Not to the bot!
4. Create a textchannel u like to get the notifications in.

Commands:
- '>notifier - Register that channel as "Notifier-Channel"'
- '>unnotifier - Unregisters that channel.'
- '>timezone EST - Set your timezone'
- '>status 0 to select what messages you like to get.'
```
Possible Codes for status:
0 = All messages.
1 = Only overworld.
2 = Only Immortal
3 = Only Shadow
4 = Immortal with overworld
5 = Shadow with overworld
```
- '>role @Role to set what role should be mentioned in this textchannel. If you dont set the role @everyone will be mentioned.'
- '>debug on/off Sets a channel as debug mode (You don't need that, it's just for me to help me finding and fixing bugs.'
