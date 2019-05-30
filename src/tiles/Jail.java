package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * Class for jail tile. 
 * @author Sebastian Viro, Aevan Dino	
 */
public class Jail implements Tile {
	private ImageIcon img = new ImageIcon("tilePics/jail.png");

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

	@Override
	public String getTitle() {
		return null;
	}

	public ImageIcon getPicture(){
		return img;
	}
}
