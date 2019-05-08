package tile;

import java.awt.Color;

import player.Player;

public class Tavern implements Tile{
	
	private final static String TAVERN = "Tavern";
	private String info = "";
	private boolean purchasable;
	private Player owner;
	private Color color; 
	

	public Tavern() {
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
		return this.info + "name\n" + "Owner: " + ;
		
	}

}
