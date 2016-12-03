package hearthstoneBot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.google.common.util.concurrent.FutureCallback;
import com.mashape.unirest.http.exceptions.UnirestException;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class HSBot {
	
	public static Properties prop;

	public static void main(String[] args){

		prop = new Properties();
		String propFileName = "./config.properties";


		// LOAD PROPERTIES
		try {

			File file = new File(propFileName);
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			in.close();

		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}

		// GET BOT TOKEN
		String token = prop.getProperty("token");

		DiscordAPI api = Javacord.getApi(token, true);
		api.setGame("HearthstoneBot");

		// CONNECT BOT
		api.connect(new FutureCallback<DiscordAPI>(){
			public void onSuccess(final DiscordAPI api){


				//----------------------------
				// MAIN BOT CODE HERE!
				//----------------------------


				api.registerListener(new MessageCreateListener(){
					public void onMessageCreate(DiscordAPI api, Message message){

						// CARD SEARCH
						if (message.getContent().toUpperCase().startsWith("!HS")){

							String cardName;

							try{
								cardName = message.getContent().substring(4);
								//System.out.println("Searching for cards matching '" + cardName + "'");

								List<HSCard> list = HSCardFetcher.searchForCard(cardName);

								if(list.isEmpty()){
									message.reply("No cards found");
								}
								
								boolean cardMatches = false;
								int matchedIndex = 0;
								String matchedCards = new String("Matches found: \n");
								
								for(HSCard card:list){
									if(card.getName().equalsIgnoreCase(cardName)){
										cardMatches = true;
										matchedIndex = list.indexOf(card);
									}
									matchedCards = matchedCards.concat("  "+card.getName() + "\n");
								}
								
								message.reply(matchedCards + "------------------\nBest match: \n\n" + list.get(matchedIndex).toString()); 

							}catch (IndexOutOfBoundsException e){
								message.reply("No card was specified");
							} catch (UnirestException e) {
								message.reply("There was an error processing your search");
								e.printStackTrace();
							}

						} 
					}
				});

				//----------------------
				// END MAIN BOT CODE
				//----------------------

			}

			public void onFailure(Throwable t){
				t.printStackTrace();
			}
		});

	}

}
