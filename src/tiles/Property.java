package tiles;

import java.awt.Color;


import player.Player;


/**
 * name, price, defRent, renPH, color
 */
public class Property implements Tile {

	private String name, info;
	private int price, rentPerLevel, defaultRent, levels;
	private Boolean purchaseable;
	private Color color;
	private Player owner ;


	public Property(String name, int price, int defaultRent, int rentPerLevel, Color color) {
		setName(name);
		setPrice(price);
		setDefaultRent(defaultRent);
		setRentPerHouse(rentPerLevel);
		setColor(color);
		purchaseable=true;
		owner = null;
	}

	public String getTileInfo() {
		info =    "\nOwner: \t" + owner + "\n"
				+ "Price:\t\t" + price + "\n"
				+ "Default rent:\t" + defaultRent + "\n"
				+ "Rent with Levels:\t" 	+ rentPerLevel + "\n"
				+ "Total rent:\t" 		+ getTotalRent();
		return info;
	}
	public String getTitle() {
		return name;
	}
	public Color getTitleColor() {
		return color;
	}
	
	
//	public static void main(String[] args) {
//		Property p = new Property("MomoSuger gatan", 200, 35, 20, Color.BLUE);
//		p.setNumberOfHouses(3);
////		System.out.println(p.getTileInfo());
//	}

	public void onLanding() {

	}

	public void setName(String tileName) {
		this.name = tileName;
	}

	public String getName() {
		return this.name;
	}

	public void setPurchaseable(Boolean canBeBought) {
		this.purchaseable=canBeBought;
	}

	public Boolean getPurchaseable() {
		return this.purchaseable;
	}

	public void setColor(Color colorOfTile) {
		this.color=colorOfTile;
	}

	public Color getColor() {
		return this.color;
	}

	public void setPrice(int price) {
		this.price=price;
	}

	public int getPrice() {
		return this.price;
	}

	
	public void setOwner(Player newOwner) {
		this.owner = newOwner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	
	public void setDefaultRent(int defRent) {
		this.defaultRent = defRent;
	}

	public int getDefaultRent() {
		return this.defaultRent;
	}

	public void setRentPerHouse(int rentPerHouse) {
		this.rentPerLevel = rentPerHouse;
	}

	public int getRentPerHouse() {
		return this.rentPerLevel;
	}
	
	public int getTotalRent() {
		return this.defaultRent + (this.rentPerLevel * this.levels);
	}
	
	public void setNumberOfHouses(int num) {
		this.levels=num;
	}
	
	public int getNumberOfHouses() {
		return this.levels;
	}
	
	public void setPurchaseable(boolean b) {
		this.purchaseable = b;
	}
	
	
	//Ej klar!!!
	public void clearProperty() {
		purchaseable = true; 
		setNumberOfHouses(0);
	}
	
	
}
