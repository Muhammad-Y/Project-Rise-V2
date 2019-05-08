package combinedPanels;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import board.Board;
import board.PlayerList;
import dice.BetterDice;
import eastSidePanels.EastSidePanel;
import eastSidePanels.PlayerPanel;
import eastSidePanels.TabPanel;
import menu.Menu;
import westSidePanel.WestSidePanel;

/**
 * @author Abdulkhuder Muhammad
 *
 */
public class NullMain extends JPanel {
	private PlayerList playerList;

	private EastSidePanel eastPanel = new EastSidePanel();

	private Menu m = new Menu();

	private WestSidePanel westPanel = new WestSidePanel();
	private Board board = new Board(westPanel);

	private TabPanel TPanel = new TabPanel();
;

	private BetterDice dice = new BetterDice(board, playerList);
	private JFrame frame = new JFrame();

	public NullMain() {

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(1440, 860));
		setLayout(null);
		
		
		TPanel.setBounds(1095, 0, 345, 860);
		add(TPanel);
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
		frame.setPreferredSize(new Dimension(750, 750));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(this);
		frame.pack();
	}

	public void addPlayer(PlayerList playerList) {
		this.playerList = playerList;

		board.addPlayers(playerList);

		board.setPlayers();
		TPanel.addPlayerList(playerList);

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
