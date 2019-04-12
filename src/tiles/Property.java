package tiles;

import java.awt.Color;

import projectrise.Player;

/**
 * name, price, defRent, renPH, color
 */
public class Property implements Tile {

	private String name, info;
	private int price, rentPerHouse, defaultRent, numberOfHouses;
	private Boolean purchaseable;
	private Color color;
	private Player owner;


	public Property(String name, int price, int defaultRent, int rentPerHouse, Color color) {
		setName(name);
		setPrice(price);
		setDefaultRent(defaultRent);
		setRentPerHouse(rentPerHouse);
		setColor(color);
		purchaseable=true;
		owner = null;
	}

	public String getTileInfo() {
		info = name + "\n"
				+ "Owner: " 			+ owner + "\n"
				+ "Price: " 			+ price + "\n"
				+ "Default rent: " 		+ defaultRent + "\n"
				+ "Rent with Houses: " 	+ rentPerHouse + "\n"
				+ "Color: " 			+ color + "\n"
				+ "Total rent: " 		+ getTotalRent();
		return info;
	}

	public static void main(String[] args) {
		Property p = new Property("MomoSuger gatan", 200, 35, 20, Color.BLUE);
		p.setNumberOfHouses(3);
		System.out.println(p.getTileInfo());
	}

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

	public void setDefaultRent(int defRent) {
		this.defaultRent = defRent;
	}

	public int getDefaultRent() {
		return this.defaultRent;
	}

	public void setRentPerHouse(int rentPerHouse) {
		this.rentPerHouse = rentPerHouse;
	}

	public int getRentPerHouse() {
		return this.rentPerHouse;
	}
	
	public int getTotalRent() {
		return this.defaultRent + (this.rentPerHouse * this.numberOfHouses);
	}
	
	public void setNumberOfHouses(int num) {
		this.numberOfHouses=num;
	}
	
	public int getNumberOfHouses() {
		return this.numberOfHouses;
	}
	
}
