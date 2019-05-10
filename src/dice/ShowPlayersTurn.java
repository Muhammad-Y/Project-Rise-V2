package dice;
/**
 * A Lable which shows current player's turn
 * @author Rohan
 */
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class ShowPlayersTurn extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String playerName;
	private JLabel lblPlayer;
	private String playerColor;
	private Color 
	
	public ShowPlayersTurn(String playerName, String playerCol) {
		this.playerName = playerName;
		this.playerColor = playerCol;
		showTheLabel();
	}
	
	private void showTheLabel() {
		setPreferredSize(new Dimension(100,50));
		setBackground(playerColor);
		
		lblPlayer = new JLabel(playerName + "'s turn");
		lblPlayer.setForeground(Color.white);
		lblPlayer.setPreferredSize(new Dimension(100,25));
		add(lblPlayer);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setPreferredSize(new Dimension(220, 100));
		frame.add(new ShowPlayersTurn("Rohan", Color.green));
		frame.pack();
		frame.setVisible(true);
		
		
		
//		new ShowPlayersTurn("Rohan", Color.green);
	}
}
