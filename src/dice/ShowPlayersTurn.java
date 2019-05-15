package dice;
/**
 * A Lable which shows current player's turn
 * @author Rohan
 */
import java.awt.Color;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.*;

import board.ColorIconMap;
import player.Player;
import player.PlayerList;

public class ShowPlayersTurn extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblPlayer;
	private String playerColor, playerName = "Player";
	private Color players;
	private PlayerList playerList;
	
	public ShowPlayersTurn() {
		
	}
	public ShowPlayersTurn(String player, String playerCol) {
		this.playerName = player;
		this.playerColor = playerCol;
		if (playerCol == "GREEN") {
			players = Color.green;
		}
		if (playerCol == "RED") {
			players = Color.red;
		}
		showTheLabel();
	}
	
	
	
	private void showTheLabel() {
		setPreferredSize(new Dimension(100,50));
		setBackground(players);
		
		lblPlayer = new JLabel(playerName);
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setForeground(Color.white);
		lblPlayer.setPreferredSize(new Dimension(100,25));
		add(lblPlayer);
	}
	public void addNewPlayer(String name, String color) {
//		 playerName = name;
	}
	
	public void activePlayer() {
		Player tempPlayer = playerList.getActivePlayer();
	    playerName = tempPlayer.getName();
//		tempPlayer.getImage();
		
	}
}
