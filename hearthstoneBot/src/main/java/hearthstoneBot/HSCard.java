package hearthstoneBot;

import java.util.Properties;

public class HSCard {

	private String name;
	private String cardSet;
	private String type;
	private String rarity;
	private String imgURL;
	private String goldImgURL;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardSet() {
		return cardSet;
	}
	public void setCardSet(String cardSet) {
		this.cardSet = cardSet;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public String getGoldImgURL() {
		return goldImgURL;
	}
	public void setGoldImgURL(String goldImgURL) {
		this.goldImgURL = goldImgURL;
	}



	@Override
	public String toString(){
		String feedback;

		Properties prop = HSBot.prop;

		if(prop.getProperty("useGoldCardImages").equals("true")){
			feedback = new String(
					"Name: " + getName() + "\n" + 
					"Set: " + getCardSet() + "\n" + 
					"Type: " + getType() + "\n" +
					"Rarity: " + getRarity() + "\n" +
					"Image: " + getGoldImgURL()
			);
		} else {
			feedback = new String(
					"Name: " + getName() + "\n" + 
					"Set: " + getCardSet() + "\n" + 
					"Type: " + getType() + "\n" +
					"Rarity: " + getRarity() + "\n" +
					"Image: " + getImgURL()
			);
		}

		return feedback;
	}

}
