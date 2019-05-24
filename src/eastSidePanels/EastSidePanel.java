package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import player.PlayerList;

/**
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 *
 */
public class EastSidePanel extends JPanel {

	private PlayerList playerList;
	private JTabbedPane tab;
	private PlayerInfoPanel p;

	private int currentPlayer = 0;

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
		UIManager.put("TabbedPane.contentOpaque",false);
		UIManager.put("TabbedPane.selected",Color.cyan);

		tab = new JTabbedPane();
		
		tab.setBounds(0, 0, 355, 860);
		tab.setBackground(new Color(0, 0, 0));
		
		add(tab);

	}

	public void addtabs() {

		tab.removeAll();

		for (int i = 0; i < playerList.getLength(); i++) {
			new EastSidePanel();
			p = new PlayerInfoPanel(playerList, i);
			p.setOpaque(false);
			tab.addTab("Player " + (i + 1), p);
			tab.setOpaque(false);

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
//			tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));
			tab.setBackgroundAt(currentPlayer, playerList.getPlayerFromIndex(currentPlayer).getPlayerColor());

		} else

			tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157, 0, 0));
//		tab.setBackgroundAt(currentPlayer, new Color(0, 157, 0));
		tab.setBackgroundAt(currentPlayer, playerList.getPlayerFromIndex(currentPlayer).getPlayerColor());
	}

	public int getTab() {
		return currentPlayer;
	}

}
