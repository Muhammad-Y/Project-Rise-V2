package combinedPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import board.Board;
import dice.Dice;
import eastSidePanels.EastSidePanel;
import menu.Menu;
import player.PlayerList;
import startMenu.BackgroundMusic;
import westSidePanel.WestSidePanel;

/**
 * @author Abdulkhuder Muhammad
 *
 */
public class GamePanels extends JPanel {
	private EastSidePanel tPanel = new EastSidePanel();
	private BackgroundMusic music;
	private Menu m = new Menu();
	private WestSidePanel westPanel = new WestSidePanel();
	private Board board = new Board(westPanel);
	private JLabel lblPic = new JLabel();
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();

	private PlayerList playerList;

//	private BetterDice dice = new BetterDice(board, playerList);
	private Dice dice = new Dice(board, playerList, westPanel, tPanel);
	private JFrame frame = new JFrame();

	public GamePanels() {
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.BLACK));

		setBackground(Color.DARK_GRAY);
		setPreferredSize(new Dimension(width, height));
	

	
		
		setLayout(null);
		tPanel.setOpaque(false);
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
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("images/back2jpg.jpg"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		Image bimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		lblPic.setBounds(0, 0, width, height);
		
		lblPic.setIcon(new ImageIcon(bimg));
		add(lblPic);
				

	}

	public void startboard() {
		frame = new JFrame("Change your fate");
		frame.setPreferredSize(new Dimension(width + 18, height + 10));
		frame.setLocation(-9, 0);
//		frame.setPreferredSize(new Dimension(1480, 900));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(this);
		frame.pack();
	}

	public void addPlayer(PlayerList playerList) {
//		this.playerList = playerList;

		board.addPlayers(playerList);

		board.setPlayers();
		tPanel.addPlayerList(playerList);

		dice.addPlayerList(playerList);

	}

	public static void main(String[] args) {

		GamePanels panelTest = new GamePanels();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(panelTest);
		frame.pack();

	}

}
