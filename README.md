# HSBot
A Hearthstone Bot for Discord

This bot fetches basic Hearthstone card information from the API provided by HearthstoneAPI.com


# Setup

Extract the contents of the ZIP file into the folder of your choice.

This bot requires a Bot User to be created.  You can do this by going here - https://discordapp.com/developers/applications/me and
create a "New Application".  After that is completed, you will need click the "Create a Bot User" button.  There will then be a "Click to reveal"
option to get your bot's Token.  

Open the included config.properties file and put in the Bot User token you created.

Next, you will need to invite the bot to your server.  To do this, you will need your bot's Client ID, which is found on the same page as the Token.

Paste this link into your browser, making sure to replace the client_id value in the URL with your bot's Client ID.
https://discordapp.com/api/oauth2/authorize?client_id=xxxxxxxxx&scope=bot&permissions=0

Follow the prompts to add the bot to your server.


Finally, run the bot!


# Command Usage

!HS
	- Follow this command up with the name of a card.  The bot will return a list of possible matches.
	  If there is an exact match, the bot will display the detailed information for that card.  Otherwise,
	  the bot will display the first matching card.
	  
	  
	  
# Displayed Information

###Card Matches
###Detailed Information
* Card Name
* Set
* Rarity
* Image
