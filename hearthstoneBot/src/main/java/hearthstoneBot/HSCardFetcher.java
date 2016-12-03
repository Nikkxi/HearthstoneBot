package hearthstoneBot;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HSCardFetcher {

/*
	public static void main(String[] args) throws UnirestException{
		String cardName = "Ysera";
		
		List<HSCard> cards = searchForCard(cardName);

		if(cards.isEmpty()){
			System.out.println("No cards found");
		}
		
		boolean cardMatches = false;
		int matchedIndex = 0;
		String matchedCards = new String("Matches found: \n  ");
		for(HSCard card:cards){
			if(card.getName().equals(cardName)){
				cardMatches = true;
				matchedIndex = cards.indexOf(card);
			}
			matchedCards = matchedCards.concat(card.getName() + "\n  ");
		}
		
		System.out.println(matchedCards);
		System.out.println(cards.get(matchedIndex).toString());
		
	}

*/
	public static List<HSCard> searchForCard(String cardName) throws UnirestException{

		HSCard card;

		HttpResponse<JsonNode> response = Unirest.get("https://omgvamp-hearthstone-v1.p.mashape.com/cards/search/" + cardName.replace(" ", "%20"))
				.header("X-Mashape-Key", "WrwFYlcva6mshU7aK8smbwxHz2dlp10f9tljsn0ifg6RwirehJ")
				.asJson();

		List<HSCard> list = new ArrayList<HSCard>();

		int numCards = response.getBody().getArray().length();
		System.out.println("Number of cards found: " + numCards);

		try{
			
			if(response.getBody().getObject().has("error"))
				return list;
			//System.out.println(response.getBody().getObject().has("error"));
			
		}catch(NullPointerException e){
			
		}

		for(int i = 0; i < numCards; i++){
			JSONObject obj = response.getBody().getArray().getJSONObject(i);

			//System.out.println(obj.toString());

			card = new HSCard();

			if(obj.has("name")){
				card.setName((String)obj.get("name"));
			}
			if(obj.has("cardSet")){
				card.setCardSet((String)obj.get("cardSet"));
			}
			if(obj.has("type")){
				card.setType((String)obj.get("type"));
			}
			if(obj.has("rarity")){
				card.setRarity((String)obj.get("rarity"));
			}
			if(obj.has("cost")){
				card.setCost((int)obj.getInt("cost"));
			}
			if(obj.has("attack")){
				card.setAttack((int)obj.getInt("attack"));
			}
			if(obj.has("health")){
				card.setHealth((int)obj.getInt("health"));
			}
			if(obj.has("text")){
				card.setAbilityText((String)obj.get("text"));
			}
			if(obj.has("img")){
				card.setImgURL((String)obj.get("img"));
			}
			if(obj.has("imgGold")){
				card.setGoldImgURL((String)obj.get("imgGold"));
			}

			list.add(card);

		}

		return list;
	}

}
