package eastSidePanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

import player.PlayerList;

/**
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 *
 */
public class EastSidePanel extends JPanel {
	
	private PlayerList playerList;
	private JTabbedPane tab = new JTabbedPane();
	private PlayerInfoPanel p;
	private int currentPlayer= 0;

 
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
		p.setOpaque(false);
		tab.setOpaque(false);
		tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157,0,0));
		tab.setBackgroundAt(currentPlayer, new Color(0,157,0));

		tab.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	
	public void setTab() {
		tab.setBackgroundAt(currentPlayer, null);

		currentPlayer++;
		if (currentPlayer > playerList.getLength()-1 ) {
			currentPlayer=0;
			
			
		}
		tab.setSelectedIndex(currentPlayer);
		tab.setForeground(Color.white);
		tab.setBackground(new Color(157,0,0));
		tab.setBackgroundAt(currentPlayer, new Color(0,157,0));
		tab.setBorder(BorderFactory.createLineBorder(Color.black));

		
		
	}
	
	public int getTab() {
		return currentPlayer;
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
