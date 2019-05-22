package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import player.PlayerList;
import tiles.Property;

/**
 * @author Muhammad Abdulkhuder, Aevan Dinola sebastian rohan.
 *
 */
public class PlayerProperties extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblName = new JLabel("Name");
	private JLabel lblColor = new JLabel("");

	private JButton btnUpgrade = new JButton("Upgrade");
	private JButton btnDowngrade = new JButton("Downgrade");
	private JButton btnSell = new JButton("Sell");
	
	private Boolean change= false;

	
	
	public Boolean getChange() {
		return change;
	}

	public void setChange(Boolean change) {
		this.change = change;
	}

	private Font font = new Font("ALGERIAN", Font.BOLD, 16);

	public PlayerProperties(PlayerList playerList, int playerAtI, int propertyAtI) {
		lblName.setOpaque(false);
		lblName.setForeground(Color.white);
		lblName.setText(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getName());
//		lblColor.setBackground(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getColor());
		
		lblColor.setIcon(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getPicture());
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(330, 566));
		setLayout(null);

		btnDowngrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnDowngrade.setBounds(158, 381, 150, 54);
		add(btnDowngrade);
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSell.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnSell.setBounds(39, 484, 255, 74);
		btnSell.setForeground(Color.red);
		add(btnSell);

		btnUpgrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnUpgrade.setBounds(10, 381, 150, 54);
		add(btnUpgrade);

		lblColor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblColor.setBounds(62, 80, 218, 302);
		add(lblColor);

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblName.setBounds(0, 0, 330, 82);
		add(lblName);

		lblColor.setFont(font);
		lblColor.setOpaque(true);

		lblName.setFont(font);
		btnDowngrade.setFont(font);
		btnUpgrade.setFont(font);
		btnSell.setFont(font);

		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property tempProperty =  playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);
										
				playerList.getPlayerFromIndex(playerAtI).removeProperty(tempProperty);
				setChange(true);
				
			}
		});

		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnDowngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

	}
	
	
	

}