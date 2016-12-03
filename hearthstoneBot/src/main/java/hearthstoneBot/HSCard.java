package hearthstoneBot;

public class HSCard {

	private String name;
	private String cardSet;
	private String type;
	private String rarity;
	private int cost;
	private int attack;
	private int health;
	private String abilityText;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getAbilityText() {
		return abilityText;
	}
	public void setAbilityText(String abilityText) {
		this.abilityText = abilityText;
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
		
		feedback = new String(
				"Name: " + getName() + "\n" + 
				"Set: " + getCardSet() + "\n" + 
				"Rarity: " + getRarity() + "\n" +
				"Image: " + getImgURL()
				);
		
		return feedback;
	}

}
