package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import player.PlayerList;

/**
 * The class displays information about the players in a panel.
 * @author Abdulkhuder Muhammad, Sebastian Viro, Rohan Samandari
 */
public class PlayerInfoPanel extends JPanel {

	private JLabel lblName = new JLabel("");
	private JLabel lblRank = new JLabel("");
	private JLabel lblGold = new JLabel("");
	private JLabel lblNetworth = new JLabel("");
	private JLabel lblProperty = new JLabel();
	private JLabel lblIsAlive = new JLabel();
	
	private JTextArea lblPropertyList = new JTextArea("");

	private JPanel pnl1 = new JPanel();
	private JPanel pnl2 = new JPanel();
	private JPanel pnl3 = new JPanel();
	private JPanel pnl4 = new JPanel();
	private JPanel pnl5 = new JPanel();
	private JPanel pnl6 = new JPanel();
	private JPanel pnl7 = new JPanel();
	
	private Font font = new Font("ALGERIAN", Font.PLAIN, 18);
	private Border border = BorderFactory.createLineBorder(Color.black);


	/**
	 * The constructor draws an information panel with information about a player.
	 * @param playerList the list of player
	 * @param player, a players index
	 */
	public PlayerInfoPanel(PlayerList playerList, int player) {

		setPreferredSize(new Dimension(350, 715));
		setBackground(Color.DARK_GRAY);
		setLayout(null);

		pnl1.setBounds(10, 5, 330, 50);
		pnl2.setBounds(10, 55, 330, 50);
		pnl3.setBounds(10, 105, 330, 50);
		pnl4.setBounds(10, 155, 330, 50);
		pnl5.setBounds(10, 205, 330, 50);
		pnl6.setBounds(10, 255, 330, 50);
		pnl7.setBounds(10, 305, 330, 600);

		pnl1.setBorder(border);
		pnl2.setBorder(border);
		pnl3.setBorder(border);
		pnl4.setBorder(border);
		pnl5.setBorder(border);
		pnl6.setBorder(border);
		pnl7.setBorder(border);
		
		lblName.setText( playerList.getPlayerFromIndex(player).getName().toUpperCase());
		lblName.setFont(font);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(false);
		lblName.setForeground(Color.black);
		lblName.setBackground(Color.white);

		pnl1.add(lblName);
		add(pnl1);

		lblGold.setText("Amount of gold: " + playerList.getPlayerFromIndex(player).getBalance());
		lblGold.setFont(font);
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setForeground(Color.black);

		pnl2.add(lblGold);
		add(pnl2);

		lblNetworth.setText("Total wealth: " + playerList.getPlayerFromIndex(player).getNetWorth());
		lblNetworth.setFont(font);
		lblNetworth.setHorizontalAlignment(SwingConstants.CENTER);
		pnl3.add(lblNetworth);
		add(pnl3);

		lblIsAlive.setText(playerList.getPlayerFromIndex(player).isAliveString());
		lblIsAlive.setFont(font);
		lblIsAlive.setHorizontalAlignment(SwingConstants.CENTER);
		pnl4.add(lblIsAlive);
		add(pnl4);

		lblRank.setText("Player Rank: " + playerList.getPlayerFromIndex(player).getPlayerRank());
		lblRank.setFont(font);
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		pnl5.add(lblRank);
		add(pnl5);

		lblProperty.setText("Properties");
		lblProperty.setFont(font);
		lblProperty.setHorizontalAlignment(SwingConstants.CENTER);
		pnl6.add(lblProperty);
		add(pnl6);

		/**
		 * For-loop iterates through all properties a player owns and displays them in the label.
		 */
		for (int i = 0; i < playerList.getPlayerFromIndex(player).getProperties().size(); i++) {
			lblPropertyList.append(playerList.getPlayerFromIndex(player).getProperty(i).getName() + "\n");
		}
		
		lblPropertyList.setFont(font);
		lblPropertyList.setOpaque(false);

    	pnl7.add(lblPropertyList);    	
		add(pnl7);

	}

}
