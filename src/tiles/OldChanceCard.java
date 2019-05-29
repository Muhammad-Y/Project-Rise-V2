package tiles;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * This class picks and shows a chance card. All cards are always available and
 * each card is picked randomly.
 * 
 * @author AevanDino, SebastianViro
 */
public class OldChanceCard implements Tile {

	private Color color = Color.WHITE;
	private static final String NAME = "Fortune Teller";

	private static final Boolean PURCHASEABLE = false;
	private FortuneTeller[] chanceCard = { new FortuneTeller(Boolean.TRUE, "F�rsta Kortet", 50),
			new FortuneTeller(Boolean.FALSE, "Andra Kortet", -50) };
	private ImageIcon img = new ImageIcon("tilePics/fortune.png");
	/**
	 * Generates a random number between 0 and chanceCard.length and returns it to
	 * the caller.
	 * 
	 * @return Random integer between 0 and chanceCards.length
	 */
	public int getRandomNumber() {
		return (int) (Math.random() * chanceCard.length);
	}

	/**
	 * Displays the chosen chance card in an JOptionPane
	 */
	public FortuneTeller getChanceCard() {
		return chanceCard[getRandomNumber()];
	}

	public void onLanding() {
//		displayCard(getChanceCard()); // displayCard needs to be implemented in GUI.
	}

	public String getName() {
		return this.NAME;
	}

	public Boolean getPurchaseable() {
		return PURCHASEABLE;
	}

	public Color getColor() {
		return this.color;
	}

	public String getTileInfo() {
		return "There are two types of cards, blessings and curses." + "\nBlessing affect the player in a positive way."
				+ "\nCurses affect the player in a negative way.";
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