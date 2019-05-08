package tiles;

import java.awt.Color;

import player.Player;

public class Tavern implements Tile{
	
	private final static String TAVERN = "Tavern";
	private String info = "";
	private boolean purchasable;
	private Player owner;
	private Color color; 
	private int price;
	

	public Tavern(int price) {
		this.price = price;
		this.purchasable = true;
		this.owner = null;
	}
	public void onLanding() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return this.TAVERN;
	}

	@Override
	public Boolean getPurchaseable() {
		return this.purchasable;
	}

	@Override
	public Color getColor() {
		return null;
	}

	@Override
	public String getTileInfo() {
		return this.info + "name\n" + "Owner: " + "";
		
	}

}
