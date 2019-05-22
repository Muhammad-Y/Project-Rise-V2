package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * Player does not have to pay anything and doesn't get paid for it.
 * @author AevanDino, SebastianViro
 */
public class SundayChurch implements Tile {
	private ImageIcon img = new ImageIcon("tilePics/church.png");
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
	
	public ImageIcon getPicture(){
		return img;
	}

}
