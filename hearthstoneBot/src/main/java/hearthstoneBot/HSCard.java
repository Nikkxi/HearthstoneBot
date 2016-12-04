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
		String feedback = new String();

		Properties prop = HSBot.prop;
		
		feedback = feedback.concat( "Name: " + getName() + "\n" );
		feedback = feedback.concat( "Set: " + getCardSet() + "\n" );
		feedback = feedback.concat( "Type: " + getType() + "\n" );
		feedback = feedback.concat( "Rarity: " + getRarity() + "\n" );

		if(prop.getProperty("useGoldCardImages").equals("true")){
			feedback = feedback.concat( "Image: " + getGoldImgURL() );
		} else {
			feedback = feedback.concat( "Image: " + getImgURL() );
		}

		return feedback;
	}

}
