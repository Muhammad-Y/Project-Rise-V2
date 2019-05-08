package startMenu;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import board.Board;
import board.ColorIconMap;
import combinedPanels.NullMain;
import player.PlayerList;

/**
 * 
 * @author AevanDino, SethOberg
 *
 */

public class StartUpScreen extends JFrame {

	private static final long serialVersionUID = 1L;

//	private PlayerList playerList = new PlayerList(); 
//	private Board board;

	private BackgroundMusic bgm = new BackgroundMusic();

	private PlayerList playerList = new PlayerList();
	private Board board;
	private NullMain mainWindow = new NullMain();

	private ColorIconMap colorMap = new ColorIconMap();

	// width and height
	private static final int SCREENWIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	private static final int SCREENHEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	// Buttons
	private JButton btnConfirm = new JButton("Confirm");
	private JButton btnStartGame = new JButton("Start Game");
	private JButton btnReset = new JButton("Reset");

	// Background image
	private ImageIcon imgBackground = new ImageIcon(new ImageIcon("images/fancyRoll.jpg").getImage()
			.getScaledInstance(SCREENWIDTH / 2, SCREENHEIGHT, Image.SCALE_SMOOTH));

	// Different fonts for different things
	private Font fontRadioButtons = new Font("Gabriola", Font.PLAIN, 24);
	private Font fontHeader = new Font("Gabriola", Font.BOLD, 72);
	private Font fontLabel = new Font("Gabriola", Font.BOLD, 30);

	// Jpanels used
	private JPanel pnlPlayer = new JPanel();
	private JPanel pnlPlayerInfo = new JPanel();

	private JRadioButton[] radioButtons = new JRadioButton[4];
	ButtonGroup groupPlayers = new ButtonGroup();

	// Labels
	private JLabel lblPlayer = new JLabel("How many players?");
	private JLabel lblBackground = new JLabel("", imgBackground, JLabel.CENTER);
	private JLabel lblRise = new JLabel("RISE");

	private JTextField tfPlayer1 = new JTextField("Insert Name1...");
	private JTextField tfPlayer2 = new JTextField("Insert Name2...");
	private JTextField tfPlayer3 = new JTextField("Insert Name3...");
	private JTextField tfPlayer4 = new JTextField("Insert Name4...");
	private JTextField[] playerTf = new JTextField[] { tfPlayer1, tfPlayer2, tfPlayer3, tfPlayer4 };

	private JLabel lblPlayerIndex1 = new JLabel("Player 1:");
	private JLabel lblPlayerIndex2 = new JLabel("Player 2:");
	private JLabel lblPlayerIndex3 = new JLabel("Player 3:");
	private JLabel lblPlayerIndex4 = new JLabel("Player 4:");
	private JLabel[] playerLabels = new JLabel[] { lblPlayerIndex1, lblPlayerIndex2, lblPlayerIndex3, lblPlayerIndex4 };

	// Array of colors
	private String[] colors = new String[] { "RED", "GREEN", "ORANGE", "YELLOW", "CYAN", "MAGENTA" };
	private JComboBox<String> playerColors1 = new JComboBox<String>(colors);
	private JComboBox<String> playerColors2 = new JComboBox<String>(colors);
	private JComboBox<String> playerColors3 = new JComboBox<String>(colors);
	private JComboBox<String> playerColors4 = new JComboBox<String>(colors);
	private JComboBox[] playerColors = new JComboBox[] { playerColors1, playerColors2, playerColors3, playerColors4 };

	private int amountOfPlayers;

	public static void main(String[] args) {
		StartUpScreen su = new StartUpScreen();
		su.initializeGUI();
	}

	private StartUpScreen(int amountOfPlayers) {
		this.amountOfPlayers = amountOfPlayers;
	}

	public StartUpScreen() {
	}

	public void initializeGUI() {
		createFrame();
		bgm.startMusic();

		int frameWidth = this.getWidth();
		int frameHeight = this.getHeight();

		// pnl for players
		pnlPlayerInfo.setBounds(0, 0, frameWidth, frameHeight);
		pnlPlayerInfo.setOpaque(false);
		pnlPlayerInfo.setLayout(null);

		// Label used to create a background
		lblBackground.setBounds(0, 0, SCREENWIDTH / 2, SCREENHEIGHT);
		lblBackground.setIcon(imgBackground);
		lblBackground.setLayout(null);

		// Header, title of game
		lblRise.setFont(fontHeader);
		lblRise.setBounds(frameWidth / 2 - frameWidth / 12, frameHeight / 5, frameWidth / 5, frameHeight / 5);
		lblBackground.add(lblRise);

		// Label asking a question
		lblPlayer.setFont(fontLabel);
		lblPlayer.setBounds(frameWidth / 3 + frameWidth / 28, frameHeight / 4, frameWidth / 3 + frameWidth / 5,
				frameHeight / 5);
		lblBackground.add(lblPlayer);

		// Confirm button
		btnConfirm.setBounds(6 * (frameWidth / 15), 4 * (frameHeight / 10), frameWidth / 5, frameHeight / 30);
		btnConfirm.addActionListener(new ButtonListener());

		// Create four radio buttons
		createRadioButtons(frameWidth, frameHeight);

		// Create players, label, tf and combobox
		createPlayers(frameWidth, frameHeight);

		btnStartGame.setBounds(5 * (frameWidth / 15), 13 * (frameHeight / 20), frameWidth / 3, frameWidth / 18);
		btnStartGame.addActionListener(new ButtonListener());
		btnStartGame.setVisible(false);

		btnReset.setBounds(6 * (frameWidth / 15), 7 * (frameHeight / 10), frameWidth / 5, frameWidth / 30);
		btnReset.addActionListener(new ButtonListener());
		btnReset.setVisible(false);

		lblBackground.add(pnlPlayerInfo);

		add(lblBackground);
		lblBackground.add(btnConfirm);
		lblBackground.add(btnStartGame);
		lblBackground.add(btnReset);

		pnlPlayer.setVisible(true);

	} 

	public void createFrame() {
		setSize(SCREENWIDTH / 2, SCREENHEIGHT-40);
		setTitle("THIS");
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void createRadioButtons(int width, int height) {
		for (int i = 0; i < 4; i++) {
			JRadioButton btnRadio = new JRadioButton((i + 1) + "");
			btnRadio.setBounds(width / 3 + (i * width / 10), height / 3 + height / 50, width / 15, width / 20);
			btnRadio.setFont(fontRadioButtons);
			btnRadio.setOpaque(false);
			groupPlayers.add(btnRadio);
			radioButtons[i] = btnRadio;
			add(btnRadio);
		}
	}

	public void createPlayers(int width, int height) {

		for (int i = 0; i < 4; i++) {
			playerLabels[i].setBounds(3 * (width / 12), 20 * (height / 48) + i * (height / 20), height / 5,
					height / 10);
			playerLabels[i].setFont(fontLabel);
			playerLabels[i].setVisible(false);

			playerTf[i].setBounds(6 * (width / 15), 42 * (height / 96) + i * (height / 20), width / 7, height / 30);
			playerTf[i].setVisible(false);

			playerColors[i].setBounds(width / 2 + width / 20, 42 * (height / 96) + i * (height / 20), width / 7,
					height / 30);
			playerColors[i].setVisible(false);

			// Vi kan ha anrop till getters och setters maybe? Och om det inte g�r s� �r det
			// bara att skapa en array. ez.

			pnlPlayerInfo.add(playerLabels[i]);
			pnlPlayerInfo.add(playerTf[i]);
			pnlPlayerInfo.add(playerColors[i]);
		}

	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btnReset) {
				btnPressed(3, false);
			}

			if (e.getSource() == btnConfirm) {

				if (radioButtons[0].isSelected()) {
					btnPressed(0, true);
					amountOfPlayers = 1;
				} else if (radioButtons[1].isSelected()) {
					btnPressed(1, true);
					amountOfPlayers = 2;

				} else if (radioButtons[2].isSelected()) {
					btnPressed(2, true);
					amountOfPlayers = 3;

				} else if (radioButtons[3].isSelected()) {
					btnPressed(3, true);
					amountOfPlayers = 4;
				}
				
			}

			if (e.getSource() == btnStartGame) {
				for (int i = 0; i == amountOfPlayers; i++) {
					System.out.println(
							"Player One: " + playerTf[i].getText() + " : " + playerColors[i].getSelectedItem());
				}
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				createNewUsers();

				for (int i = 0; i < playerList.getLength(); i++) {
					 System.out.println(playerList.getPlayerFromIndex(i).getPlayerIndex());
				}

				//
//				board = new Board();
//				board.printPlayers();
//				board.addPlayers(playerList);
//				board.setPlayers(); 
//				board .startboard();

				mainWindow.addPlayer(playerList);
				
				
				
				mainWindow.startboard();

			}

		}

		private void createNewUsers() {
			for (int i = 0; i < amountOfPlayers; i++) {
				playerList.addNewPlayer(playerTf[i].getText(), (String) playerColors[i].getSelectedItem());
			}
		}

		public void btnPressed(int amountOfPlayers, boolean bool) {
			for (int i = 0; i <= amountOfPlayers; i++) {
				playerLabels[i].setVisible(bool);
				playerTf[i].setVisible(bool);
				playerColors[i].setVisible(bool);
			}
			btnStartGame.setVisible(bool);
			btnReset.setVisible(bool);
			btnConfirm.setEnabled(!bool);

		}
	}

}
