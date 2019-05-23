package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import player.PlayerList;

/**
 * @author Muhammad Abdulkhuder, Aevan Dino.
 */
public class PropertyWindow extends JPanel {

	private PlayerList playerList;
	private JTabbedPane tab = new JTabbedPane();
	private PlayerProperties p;

	private int playerAt;
	
	
	public int getPlayerAt() {
		return playerAt;
	}

	public void setPlayerAt(int playerAt) {
		this.playerAt = playerAt;
	}

	private int[] array;
	private int[] array2;

	public void addPlayerList(PlayerList playerList) {

		this.playerList = playerList;
		addtabs();

	}

	public PropertyWindow() {

		setPreferredSize(new Dimension(330, 600));
		setOpaque(false);
		setLayout(null);
		tab.setBorder(null);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		
		tab.setBounds(0, 0, 330, 600);

		add(tab);
		
		UIManager.getDefaults().put("TabbedPane.lightHighlight", Color.BLACK);
		UIManager.getDefaults().put("TabbedPane.selectHighlight", Color.BLACK);
	}

	public void addtabs() {
		array = new int[playerList.getLength()];

		tab.removeAll();
		
		tab.setForeground(Color.white);


			array2 = new int[playerList.getPlayerFromIndex(getPlayerAt()).getProperties().size()];

			for (int j = 0; j < array2.length; j++) {

				new PropertyWindow();
				p = new PlayerProperties(playerList, getPlayerAt(), j);
				tab.addTab("Property" + (j + 1), p);
				tab.setBackgroundAt(j, playerList.getPlayerFromIndex(getPlayerAt()).getProperty(j).getColor());

			}
		

	}

	

}
