package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
	private JLabel lblPicture = new JLabel("");
	private JTextArea taLevel = new JTextArea("");
	private JButton btnUpgrade = new JButton("Upgrade");
	private JButton btnDowngrade = new JButton("Downgrade");
	private JButton btnSell = new JButton("Sell");
	private String res = "+";

	private Font font = new Font("ALGERIAN", Font.BOLD, 22);
	private Font fontLevel = new Font("ALGERIAN", Font.BOLD, 50);

	public PlayerProperties(PlayerList playerList, int playerAtI, int propertyAtI) {
		setBorder(null);

		setOpaque(false);
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(330, 607));
		setLayout(null);

		btnDowngrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnDowngrade.setBounds(163, 481, 167, 53);
		add(btnDowngrade);

		btnUpgrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnUpgrade.setBounds(0, 481, 167, 53);
		add(btnUpgrade);

		btnSell.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnSell.setBounds(0, 532, 330, 46);
		btnSell.setForeground(Color.red);
		add(btnSell);
		btnSell.setFont(font);

		
		taLevel.setEditable(false);
		taLevel.setBounds(57, 31, 263, 53);
		taLevel.setOpaque(false);
		taLevel.setFont(fontLevel);
		taLevel.setForeground(Color.white);
		updateLevels(playerList, playerAtI, propertyAtI);
		add(taLevel);

		lblName.setForeground(Color.white);
		lblName.setOpaque(false);
		lblName.setText(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getName());

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(0, 0, 330, 46);
		add(lblName);
		lblName.setFont(font);
		lblPicture.setForeground(Color.WHITE);

		lblPicture.setBorder(null);
		lblPicture.setBounds(0, 0, 330, 480);
		add(lblPicture);

		lblPicture.setFont(font);
		lblPicture.setOpaque(true);
		btnDowngrade.setFont(font);
		btnUpgrade.setFont(font);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getPicture().toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(lblPicture.getWidth(), lblPicture.getHeight(), Image.SCALE_SMOOTH);

		lblPicture.setIcon(new ImageIcon(dimg));

		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

				playerList.getPlayerFromIndex(playerAtI).removeProperty(tempProperty);

			}
		});

		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

				tempProperty.increaseLevel();
				String tempRes = taLevel.getText();
				
				if (tempRes.length()<tempProperty.getLevel()) {
					taLevel.append(res);

				}

			}
		});

		btnDowngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

				tempProperty.decreaseLevel();

				
				String tempRes = taLevel.getText();
				
				if (tempRes.length()>tempProperty.getLevel()) {
					
					tempRes= tempRes.substring(0, tempRes.length()-1);
					taLevel.setText(tempRes);
				}
				

			}
		});

	}

	public void updateLevels(PlayerList playerList, int p, int pr) {
		int lvl = playerList.getPlayerFromIndex(p).getPropertyAt(pr).getLevel();

		for (int i = 0; i < lvl; i++) {

			taLevel.append(res);
		}

	}

	public void updateLevels(Property property) {
		int lvl = property.getLevel();

		for (int i = 0; i < lvl; i++) {

			taLevel.append(res);

		}

	}

}