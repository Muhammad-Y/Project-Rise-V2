package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;
/**
 * 
 * @author Sebastian Viro, Aevan Dino
 *
 */
public class GoToJail implements Tile {

	private ImageIcon img = new ImageIcon("tilePics/gojail.png");


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getPurchaseable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTileInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public ImageIcon getPicture() {
		return img;
	}
}
