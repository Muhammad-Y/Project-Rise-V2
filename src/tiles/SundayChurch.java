package tiles;

import java.awt.Color;

/**
 * Player does not have to pay anything and doesn't get paid for it.
 * @author AevanDino, SebastianViro
 */
public class SundayChurch implements Tile {

	String info;

	public void onLanding() {

	}

	public String getName() {
		return "Sunday Church";
	}

	public Boolean getPurchaseable() {
		return Boolean.FALSE;
	}

	public Color getColor() {
		return Color.WHITE;
	}

	public String getTileInfo() {
		info = "Sunday Church \nPlayer attends church, free of charge";
		return info;
	}

	public static void main(String[] args) {
		SundayChurch s = new SundayChurch();
		System.out.println(s.getTileInfo());
		
	}

}
