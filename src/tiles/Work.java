package tiles;

import java.awt.Color;


import gui.DiceWork;
import dice.DiceGUI;
import player.Player;

/**
 * @author AevanDino, Sebastian Viro
 */
public class Work implements Tile {
	
	private DiceWork dice;
	private static Player player;
	private String info;
	
	public Work (Player player) {
		this.player = player;
	}
	public Work() {
		
	}
	
	public void onLanding() {
		dice = new DiceWork(player);
		dice.startGUI();
	}
	
	public void payPlayer(int nbrOfDots) {
		player.increaseBalance(player.getPlayerRank().getSalary(nbrOfDots));
		System.out.println(player.getBalance());
	}

	public String getName() {
		return null;
	}

	public Boolean getPurchaseable() {
		return null;
	}

	public Color getColor() {
		return null;
	}

	public String getTileInfo() {
		info = getName() + "\nPlayer gets to roll the dice, and depending \n"
				+ "on his or her rank they are rewarded gold coins for their effort. \n"
				+ "Peasant: 20 times the sum of the roll \n"
				+ "Knight: 25 times the sum of the roll \n"
				+ "Lord: 30 times the sum of the roll \n"
				+ "Ruler: 40 times the sum of the roll";
		
		return info;
	}
	
	public Player setPlayer(Player player) {
		return this.player = player;
	}

	public static void main(String[]args) {
		Work work = new Work();
//		work.setPlayer(new Player("momo", Color.BLACK));
		System.out.println(player.getBalance());
		Work w = new Work(player);
		w.onLanding();
	}
}
