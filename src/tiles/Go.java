package tiles;

import java.awt.Color;


import player.Player;

/**
 * Simple Go tile class. Pays the player 200 gold coins when landing or passing by.
 * @author AevanDino, SebastianViro
 */
public class Go implements Tile {
	
	private String info;
	private String name = "GO";
	private static Player player; //Only static cuz we dumb yall and we use it in main

//	public Go(Player player) {
//		this.player=player;
//	}
	public Go(String str) {
		this.name = str;
	}
	
	public void onLanding() {
		payOut();
	}
	
	public void payOut() {
		player.increaseBalance(200);
	}
	
	public String getName() {
		return this.name;
	}

	public Boolean getPurchaseable() {
		return Boolean.FALSE;
	}

	public Color getColor() {
		return Color.WHITE;
	}

	public String getTileInfo() {
		info = name + "\n"
				+ "Every time a player passes by, he or she \nis rewarded 200 gold coins";
		return info;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getTitleColor() {
		// TODO Auto-generated method stub
		return null;
	}
}
