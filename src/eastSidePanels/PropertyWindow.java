package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import eastSidePanels.EastSidePanel;
import eastSidePanels.PlayerInfoPanel;
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

		add(tab);

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

	public static void main(String[] args) {

	}

}
