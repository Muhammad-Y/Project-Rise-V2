package eastSidePanels;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import player.PlayerList;

/**
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 *
 */
public class TabPanel extends JPanel {
	private PlayerList playerList;

	private JTabbedPane tab = new JTabbedPane();
	private JPanel[] aP;
	private PlayerPanel p;
 
	private int[] array;
	
	public void addPlayerList(PlayerList playerList) {

		this.playerList = playerList;
		addtabs();

	}

	public TabPanel() {

		setPreferredSize(new Dimension(345, 900));
		// setLayout(new BorderLayout());
		setOpaque(false);

		add(tab);
	}

	public void addtabs() {
		
		array = new int[playerList.getLength()];


		
			tab.removeAll();

	

		
		for (int i = 0; i < array.length; i++) {
			new TabPanel();
			p = new PlayerPanel(playerList, i);
			tab.addTab("Player " +( i + 1), p);

		}

	}



	public static void main(String[] args) {
		TabPanel ui = new TabPanel();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ui);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
