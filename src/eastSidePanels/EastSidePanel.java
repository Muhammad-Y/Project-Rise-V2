package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import player.PlayerList;

/**
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 *
 */
public class EastSidePanel extends JPanel {

	private PlayerList playerList;
	private JTabbedPane tab = new JTabbedPane();
	private PlayerInfoPanel p;
	private PlayerProperties properties;
	
	private int currentPlayer = 0;

	private int[] array;

	public void addPlayerList(PlayerList playerList) {
		this.playerList = playerList;
//		propertyWindow.addPlayerList(playerList);

		addtabs();


	}

	public EastSidePanel() {

		setPreferredSize(new Dimension(345, 860));
		// setLayout(new BorderLayout());
		setOpaque(false);
		setLayout(null);
		tab.setBounds(0, 0, 345, 860);
		add(tab);

	}

	public void addtabs() {

		array = new int[playerList.getLength()];

		tab.removeAll();

		for (int i = 0; i < array.length; i++) {
			new EastSidePanel();
			p = new PlayerInfoPanel(playerList, i);
			tab.addTab("Player " + (i + 1), p);

		}

		tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157, 0, 0));
		tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));

	}

	public void setTab() {
		tab.setBackgroundAt(currentPlayer, null);

		currentPlayer++;
		if (currentPlayer > playerList.getLength() - 1) {
			currentPlayer = 0;

			tab.setSelectedIndex(currentPlayer);
			tab.setForeground(Color.white);
			tab.setBackground(new Color(157, 0, 0));
			tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));

		} else

			tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157, 0, 0));
		tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));

	}

	public int getTab() {
		return currentPlayer;
	}

	
}
