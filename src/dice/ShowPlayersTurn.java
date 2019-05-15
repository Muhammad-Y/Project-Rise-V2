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
	private String playerName = "Player";
	private Color players;
	
	public ShowPlayersTurn(String player) {
		this.playerName = player;
		players = Color.DARK_GRAY;
		showTheLabel();
	}
	
	private void showTheLabel() {
		setPreferredSize(new Dimension(250,50));
		setBackground(players);
		
		lblPlayer = new JLabel(playerName);
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setForeground(Color.white);
		lblPlayer.setPreferredSize(new Dimension(240,45));
		lblPlayer.setFont(new Font("ALGERIAN", Font.BOLD, 14 ));
		lblPlayer.setBorder(BorderFactory.createLineBorder(Color.white));
		add(lblPlayer);
	}
	public void uppdateGUI(String playerName, Color color) {
		
		lblPlayer.setOpaque(true);
		lblPlayer.setBackground(color);
		lblPlayer.setText(playerName+"'s turn");
		
		
	}
}
