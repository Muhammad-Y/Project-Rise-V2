package startMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class StartingScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	// References
	private BackgroundMusic bgm = new BackgroundMusic();
	private PlayerList playerList = new PlayerList();
	private NullMain mainWindow = new NullMain();
	private ColorIconMap colorMap = new ColorIconMap();
	private Board board;

	// JButtons
	private JButton btnConfirm = new JButton("Confirm");
	private JButton btnStartGame = new JButton("Start Game");
	private JButton btnReset = new JButton("Reset");

	// Images
	private ImageIcon imgBackground = new ImageIcon(
			new ImageIcon("images/fancyRoll.jpg").getImage().getScaledInstance(900, 860, Image.SCALE_SMOOTH));

	// Fonts
	private Font fontRadioButtons = new Font("Gabriola", Font.PLAIN, 24);
	private Font fontHeader = new Font("Gabriola", Font.BOLD, 92);
	private Font fontLabel = new Font("Gabriola", Font.BOLD, 42);
	private Font fontLabelPlayer = new Font("Gabriola", Font.BOLD, 30);

	// Panels used
	private JPanel pnlPlayerInfo = new JPanel();

	// Radio buttons
	private JRadioButton[] radioButtons = new JRadioButton[4];
	private ButtonGroup btnGroup = new ButtonGroup();

	// JLabels
	private JLabel lblPlayer = new JLabel("How many players?");
	private JLabel lblBackground = new JLabel("", imgBackground, JLabel.CENTER);
	private JLabel lblRise = new JLabel("RISE");

	// JLabels players
	private JLabel lblPlayerIndex1 = new JLabel("Player 1:");
	private JLabel lblPlayerIndex2 = new JLabel("Player 2:");
	private JLabel lblPlayerIndex3 = new JLabel("Player 3:");
	private JLabel lblPlayerIndex4 = new JLabel("Player 4:");
	private JLabel[] playerLabels = new JLabel[] { lblPlayerIndex1, lblPlayerIndex2, lblPlayerIndex3, lblPlayerIndex4 };

	// JTextFields
	private JTextField tfPlayer1 = new JTextField("Insert Name1...");
	private JTextField tfPlayer2 = new JTextField("Insert Name2...");
	private JTextField tfPlayer3 = new JTextField("Insert Name3...");
	private JTextField tfPlayer4 = new JTextField("Insert Name4...");
	private JTextField[] playerTf = new JTextField[] { tfPlayer1, tfPlayer2, tfPlayer3, tfPlayer4 };

	// JComboBox
	private String[] colors = new String[] { "RED", "GREEN", "ORANGE", "YELLOW", "CYAN", "MAGENTA" };
	private JComboBox<String> playerColors1 = new JComboBox<String>(colors);
	private JComboBox<String> playerColors2 = new JComboBox<String>(colors);
	private JComboBox<String> playerColors3 = new JComboBox<String>(colors);
	private JComboBox<String> playerColors4 = new JComboBox<String>(colors);
	private JComboBox[] playerColors = new JComboBox[] { playerColors1, playerColors2, playerColors3, playerColors4 };

	// Mute button
	private JCheckBox mute = new JCheckBox("Music On");

	// Integers
	private int amountOfPlayers;

	/**
	 * Used to test program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StartingScreen su = new StartingScreen();
		su.initializeGUI();
	}

	/**
	 * Used to determine amount of players
	 * 
	 * @param amountOfPlayers
	 */
	private StartingScreen(int amountOfPlayers) {
		this.amountOfPlayers = amountOfPlayers;
	}

	/**
	 * Empty constructor
	 */
	public StartingScreen() {
	}

	public void initializeGUI() {

		bgm.startMusic();

		createFrame();
		bgm.startMusic();

		// JPanel for information about players
		pnlPlayerInfo.setBounds(0, 0, 900, 830);
		pnlPlayerInfo.setOpaque(false);
		pnlPlayerInfo.setLayout(null);

		// Label used to create a background
		lblBackground.setBounds(0, 0, 900, 830);
		lblBackground.setIcon(imgBackground);
		lblBackground.setLayout(null);

		// Header reading "RISE"
		lblRise.setFont(fontHeader);
		lblRise.setBounds(375, 125, 175, 200);
		lblBackground.add(lblRise);

		// JLabel reading "How many players?"
		lblPlayer.setFont(fontLabel);
		lblPlayer.setBounds(315, 175, 300, 200);

		// Create three JRadioButtons
		createRadioButtons();

		// Confirm button
		btnConfirm.setBounds(375, 315, 150, 30);
		btnConfirm.addActionListener(new ButtonListener());

		// Create players
		CreatePlayers();

		// Start game button
		btnStartGame.setBounds(350, 530, 200, 40);
		btnStartGame.setVisible(false);
		btnStartGame.addActionListener(new ButtonListener());

		// Rest button
		btnReset.setBounds(375, 575, 150, 30);
		btnReset.setVisible(false);
		btnReset.addActionListener(new ButtonListener());

		// Mute button
		mute.setBounds(2, 740, 150, 35);
		mute.setForeground(Color.white);
		mute.setFont(fontRadioButtons);
		mute.setOpaque(false);
		mute.addActionListener(new ButtonListener());

		// Adding stuff to background label
		lblBackground.add(lblRise);
		lblBackground.add(lblPlayer);
		lblBackground.add(btnConfirm);
		lblBackground.add(pnlPlayerInfo);
		lblBackground.add(btnReset);
		lblBackground.add(btnStartGame);
		lblBackground.add(mute);
		add(lblBackground);
	}

	public void createFrame() {
		setSize(900, 830);
		setTitle("THIS");
		setLayout(null);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void createRadioButtons() {
		for (int i = 0; i < 3; i++) {
			JRadioButton btnRadio = new JRadioButton((i + 2) + "");
			btnRadio.setBounds(375 + i * 65, 275, 50, 50);
			btnRadio.setFont(fontRadioButtons);
			btnRadio.setOpaque(false);
			btnGroup.add(btnRadio);
			radioButtons[i] = btnRadio;
			add(btnRadio);
		}
	}

	public void CreatePlayers() {
		for (int i = 0; i < 4; i++) {
			playerLabels[i].setBounds(280, 360 + i * 40, 150, 50);
			playerLabels[i].setFont(fontLabelPlayer);
			playerLabels[i].setVisible(false);

			playerTf[i].setBounds(375, 360 + i * 40, 150, 30);
			playerTf[i].setVisible(false);

			playerColors[i].setBounds(530, 360 + i * 40, 100, 30);
			playerColors[i].setVisible(false);

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

			if (e.getSource() == mute) {
				if (mute.getText().contains("n")) {
					mute.setText("Music Off");
					bgm.pauseMusic();
				} else {
					mute.setText("Music On");
					bgm.startMusic();
				}
			}

			if (e.getSource() == btnConfirm) {

				if (radioButtons[0].isSelected()) {
					btnPressed(2, true);
					amountOfPlayers = 2;
				} else if (radioButtons[1].isSelected()) {
					btnPressed(3, true);
					amountOfPlayers = 3;

				} else if (radioButtons[2].isSelected()) {
					btnPressed(4, true);
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
			for (int i = 0; i < amountOfPlayers; i++) {
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
