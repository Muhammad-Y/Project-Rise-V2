package combinedPanels;

import java.awt.Color;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Board;
import dice.BetterDice;
import eastSidePanels.TabPanel;
import menu.Menu;
import player.PlayerList;
import westSidePanel.WestSidePanel;

/**
 * @author Abdulkhuder Muhammad
 *
 */
public class NullMain extends JPanel {
	private TabPanel tPanel = new TabPanel();


	private Menu m = new Menu();

	private WestSidePanel westPanel = new WestSidePanel();
	private Board board = new Board(westPanel);


	private PlayerList playerList ;
 
//	private BetterDice dice = new BetterDice(board, playerList);
	private BetterDice dice = new BetterDice(board, playerList, westPanel,tPanel);
	private JFrame frame = new JFrame();

	public NullMain() {

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(1440, 860));
		setLayout(null);
		
		
		tPanel.setBounds(1095, 0, 345, 860);
		add(tPanel);
		westPanel.setBounds(0, 0, 345, 860);
		add(westPanel);
		board.setBounds(346, 0, 750, 750);
		add(board);
		dice.setBounds(346, 751, 750, 109);
		add(dice);
		m.setBounds(0, 0, 50, 18);
		add(m);


	}

	public void startboard() {
		frame = new JFrame("Tjena");
		frame.setPreferredSize(new Dimension(1480, 900));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(this);
		frame.pack();
	}

	public void addPlayer(PlayerList playerList) {
		this.playerList = playerList;

		board.addPlayers(playerList);

		board.setPlayers();
		tPanel.addPlayerList(playerList);

		dice.addPlayerList(playerList);

	}

	public static void main(String[] args) {

		NullMain panelTest = new NullMain();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(panelTest);
		frame.pack();

	}

}
