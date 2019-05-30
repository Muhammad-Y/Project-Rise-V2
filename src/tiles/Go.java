package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

import player.Player;

/**
 * Simple Go tile class. 
 * @author AevanDino, SebastianViro
 */
public class Go implements Tile {

	private String info;
	private String name = "GO";
	
	private ImageIcon img = new ImageIcon("tilePics/Go.png");

	public Go(String str) {
		this.name = str;
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
		info = name + "\n" + "Every time a player passes by, he or she \nis rewarded 200 gold coins";
		return info;
	}

	public String getTitle() {
		return null;
	}

	public ImageIcon getPicture() {
		return img;
	}
}
