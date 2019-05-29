package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Jail implements Tile {
	private ImageIcon img = new ImageIcon("tilePics/jail.png");
	public void onLanding() {
				
	}

	public String getName() {
		return "JAIL";
	}

	public Boolean getPurchaseable() {
		return Boolean.FALSE;
	}

	public Color getColor() {
		return Color.WHITE;
	}

	public String getTileInfo() {
		return "JAIL + \nPlayer can choose to spend three rounds here"
				+ "\nor pay the bail.\nFirst day costs 50 gold coins"
				+ "\nSecond time costs 100 gold coins"
				+ "\nThird time player has to pay 200 and is set free";
	}
	
//	public static void main(String[] args) {
//		Jail j = new Jail();
//		System.out.println(j.getTileInfo());
//	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageIcon getPicture(){
		return img;
	}
}
