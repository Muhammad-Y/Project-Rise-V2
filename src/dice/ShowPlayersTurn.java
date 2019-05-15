package dice;
/**
 * A Lable which shows current player's turn
 * @author Rohan
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
	
	public ShowPlayersTurn(String player) {
		
		this.playerName = player;
		players = Color.DARK_GRAY;
		showTheLabel();
	}
	
	
	
	private void showTheLabel() {
		setPreferredSize(new Dimension(200,50));
		setBackground(players);
		
		lblPlayer = new JLabel(playerName);
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setForeground(Color.white);
		lblPlayer.setPreferredSize(new Dimension(200,45));
		lblPlayer.setFont(new Font("ALGERIAN", Font.BOLD, 14 ));
		lblPlayer.setBorder(BorderFactory.createLineBorder(Color.white));
		add(lblPlayer);
	}
//	public void addNewPlayer(String name, String color) {
////		 playerName = name;
//	}
	
//	public void activePlayer() {
//		Player tempPlayer = playerList.getActivePlayer();
//	    playerName = tempPlayer.getName();
//		
//	}
	public void uppdateGUI(String playerName, String color) {
		
		if (color == "RED") {
			players = Color.red;
		}
		lblPlayer.setBackground(players);
		lblPlayer.setText(playerName+"'s turn");
		
		
	}
}
