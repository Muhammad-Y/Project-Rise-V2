package eastSidePanels;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
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

	private Font font = new Font("ALGERIAN", Font.BOLD, 16);

	public PlayerProperties(PlayerList playerList, int playerAtI, int propertyAtI) {
//		lblColor.setBackground(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getColor());

		// to make the tile pictures fit
		setOpaque(false);
		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(330, 461));
		setLayout(null);

		btnDowngrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnDowngrade.setBounds(245, 143, 85, 137);
		add(btnDowngrade);

		btnUpgrade.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnUpgrade.setBounds(245, 0, 85, 144);
		add(btnUpgrade);
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSell.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		btnSell.setBounds(245, 281, 85, 184);
		btnSell.setForeground(Color.red);
		add(btnSell);
		btnSell.setFont(font);

		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Property tempProperty = playerList.getPlayerFromIndex(playerAtI).getPropertyAt(propertyAtI);

				playerList.getPlayerFromIndex(playerAtI).removeProperty(tempProperty);

			}
		});
		lblName.setForeground(Color.white);
		lblName.setOpaque(false);
		lblName.setText(playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getName());

		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setOpaque(true);
		lblName.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblName.setBounds(0, 0, 246, 74);
		add(lblName);

		lblName.setFont(font);

		lblColor.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		lblColor.setBounds(10, 73, 236, 377);
		add(lblColor);

		lblColor.setFont(font);
		lblColor.setOpaque(true);
		btnDowngrade.setFont(font);
		btnUpgrade.setFont(font);

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(
					playerList.getPlayerFromIndex(playerAtI).getProperty(propertyAtI).getPicture().toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Image dimg = img.getScaledInstance(lblColor.getWidth(), lblColor.getHeight(), Image.SCALE_SMOOTH);

		lblColor.setIcon(new ImageIcon(dimg));

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