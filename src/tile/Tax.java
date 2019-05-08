package tile;

import java.awt.Color;


import player.Player;
import player.PlayerRanks;

public class Tax implements Tile {

	private final static String NAME = "Kings tax";
	private final static Boolean PURCHASABLE = false;
	private final static Color COLOR = Color.WHITE;
	private String info;
	private static Player player;
	private int taxToPay;
	
//	public Tax(Player player) {
//		this.player = player;
//	}
	
	public Tax() {
		
	}
	public void onLanding() {
		taxToPay =  player.getPlayerRank().calculateTax();
	}
	
	public int getTax() {
		return this.taxToPay;
	}

	public String getName() {
		return this.NAME;
	}

	public Boolean getPurchaseable() {
		return this.PURCHASABLE;
	}

	public Color getColor() {
		return this.COLOR;
	}
	
	public String getTileInfo() {
		info = getName() + "\n"
				+ "Owner: \t \t" 			+ "The king" + "\n"
				+ "Peasant tax: \t" 		+ "100 gold coins" + "\n"
				+ "Knight tax: \t" 		+ "150 gold coins" + "\n"
				+ "Lord tax: \t" 	        + "200 gold coins"+ "\n"
				+ "\n"
				+ "Your tax: \t" 		    + player.getPlayerRank().calculateTax() + "\n";
		return info;
	}

	public static void main(String args[]) {
		Tax t = new Tax(new Player("Momo", Color.BLACK));
		System.out.println(t.getTileInfo());
		player.setPlayerRank(player.KNIGHT);
		System.out.println(t.getTileInfo());
		player.setPlayerRank(player.LORD);
		System.out.print(t.getTileInfo());
	}
}
