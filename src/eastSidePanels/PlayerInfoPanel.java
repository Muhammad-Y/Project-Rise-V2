package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import player.PlayerList;

/**
 * @author Abdulkhuder Muhammad, Sebastian Viro, Rohan Samandari
 *
 */
public class PlayerInfoPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	// private PlayerList playerList;
	private JLabel lblName = new JLabel("");
	private JLabel lblRank = new JLabel("");
	private JLabel lblGold = new JLabel("100 Gold coins");
	private JLabel lblNetworth = new JLabel("1000G");
	private JLabel lblISAlive = new JLabel();
    // private String name ;
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();
	private JPanel p4 = new JPanel();
	private JPanel p5 = new JPanel();
	private JPanel p6 = new JPanel();
	private PropertyWindow propertyWindow = new PropertyWindow();

	private Font font = new Font("ALGERIAN", Font.PLAIN, 18);

	public PlayerInfoPanel(PlayerList playerList, int playa) {

		setPreferredSize(new Dimension(345, 860));
		setBackground(Color.DARK_GRAY);
		p6.setBounds(10, 255, 330, 50);
		p1.setBounds(10, 5, 330, 50);

		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p2.setBounds(10, 55, 330, 50);
		p2.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setBounds(10, 105, 330, 50);
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		p4.setBounds(10, 155, 330, 50);
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		p5.setBounds(10, 205, 330, 50);
		p5.setBorder(BorderFactory.createLineBorder(Color.black));
		p6.setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(null);

		lblName.setText(playerList.getPlayerFromIndex(playa).getName().toUpperCase());
		lblName.setFont(font);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(false);
		lblName.setForeground(Color.black);
		lblName.setBackground(Color.white);

		p1.add(lblName);
		add(p1);

		lblGold.setText("Amount of gold: " + playerList.getPlayerFromIndex(playa).getBalance());
		lblGold.setFont(font);
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setForeground(Color.black);

		p2.add(lblGold);
		add(p2);

		lblNetworth.setText("Total wealth: " + playerList.getPlayerFromIndex(playa).getNetWorth());
		lblNetworth.setFont(font);
		lblNetworth.setHorizontalAlignment(SwingConstants.CENTER);
		p3.add(lblNetworth);
		add(p3);

		lblISAlive.setText(playerList.getPlayerFromIndex(playa).isAliveString());
		lblISAlive.setFont(font);
		lblISAlive.setHorizontalAlignment(SwingConstants.CENTER);
		p4.add(lblISAlive);
		add(p4);

		lblRank.setText("Player Rank: " + playerList.getPlayerFromIndex(playa).getPlayerRank());
		lblRank.setFont(font);
		lblRank.setHorizontalAlignment(SwingConstants.CENTER);
		p5.add(lblRank);
		add(p5);
		propertyWindow.setBounds(10, 252, 335, 582);

		propertyWindow.setPlayerAt(playa);
		propertyWindow.addPlayerList(playerList);
		add(propertyWindow);
		

	}

}
