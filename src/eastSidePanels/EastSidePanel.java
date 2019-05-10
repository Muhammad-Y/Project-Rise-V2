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
public class EastSidePanel extends JPanel {
	private PlayerList playerList;

	private JTabbedPane tab = new JTabbedPane();
	private JPanel[] aP;
	private PlayerInfoPanel p;
 
	private int[] array;
	
	public void addPlayerList(PlayerList playerList) {

		this.playerList = playerList;
		addtabs();

	}

	public EastSidePanel() {

		setPreferredSize(new Dimension(345, 900));
		// setLayout(new BorderLayout());
		setOpaque(false);

		add(tab);
	}

	public void addtabs() {
		
		array = new int[playerList.getLength()];


		
			tab.removeAll();

	

		
		for (int i = 0; i < array.length; i++) {
			new EastSidePanel();
			p = new PlayerInfoPanel(playerList, i);
			tab.addTab("Player " +( i + 1), p);

		}

	}



	public static void main(String[] args) {
		EastSidePanel ui = new EastSidePanel();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(ui);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}