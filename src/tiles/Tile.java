package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;
/**
 * All tiles will implement this interface. Methods listed are
 * commong methods for alla types of tiles.
 * @author AevanDino, SebastianViro
 */
public interface Tile {
	/**
	 * Thing to do when landing on tile. Should be able to be called
	 * through out the game. Consider possible outcomes (bought/owned/notOwned etc).
	 */
	public void onLanding();

	/**
	 * @return tileName, name of current tile.
	 */
	public String getName();

	/**
	 * @return if tile can be bought.
	 */
	public Boolean getPurchaseable();


	/**
	 * @return color, returns a color-object representing color of tile.
	 */
	public Color getColor();

	/**
	 * @return info, information about tile. (Price, owner, stuff).
	 */
	public String getTileInfo();
	
	public String getTitle();
	
	public Color getTitleColor();
	
	public ImageIcon getPicture();

}
