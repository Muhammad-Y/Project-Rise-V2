package dice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.Board;
import cheat.CheatGui;
import eastSidePanels.EastSidePanel;
import events.ManageEvents;
import javafx.scene.control.TabPane;
import player.PlayerList;
import westSidePanel.WestSidePanel;

/**
 * @author Muhammad Abdulkhuder ,Aevan Dino, Sebastian Virola, Seth �berg
 *
 */
public class Dice extends JPanel implements ActionListener {

//	private ShowPlayersTurn showPlayer;
	private CheatGui cheat = new CheatGui(this);
	private ShowPlayersTurn showPlayer;
	private Board board;
	private PlayerList testPlayers;
	private WestSidePanel wsp;
	private EastSidePanel tabPanel = new EastSidePanel();
	private JButton finishTurn = new JButton("End Turn");
	private int newIndex;
	private Thread movePlayerThread;

	private JButton btnThrow = new JButton("Roll Dice");

	private JLabel lblDice1 = new JLabel();
	private JLabel lblDice2 = new JLabel();
	private JPanel centerPanel = new JPanel();

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private int diceWidth = (screenSize.width) / 20;
	private int diceHeight = (screenSize.height) / 10;

	ImageIcon faceToShow, showDice;
	Image resizedImage;

	// Nytt 13e maj
	private ManageEvents manageEvents;
	private int roll;

	public void addPlayerList(PlayerList list) {

		this.testPlayers = list;
		manageEvents = new ManageEvents(board, list);

	}

	public Dice(Board board, PlayerList allPlayers, WestSidePanel wsp, EastSidePanel tabPanel) {
		this.board = board;
		testPlayers = allPlayers;
		this.wsp = wsp;
		this.tabPanel = tabPanel;

		initializePanel();
		addButtonsAndListeners();

	}

	// We can remove it after we are done with cheat
	public Dice() {

		initializePanel();
		addButtonsAndListeners();
	}

	public void initializePanel() {
		setPreferredSize(new Dimension(650, 120));
		setLayout(new FlowLayout());
		setOpaque(false);
	}

	public void addButtonsAndListeners() {
		showPlayer = new ShowPlayersTurn("Hej", "RED");
		add(showPlayer);
		add(lblDice1);

		add(lblDice2);

		add(btnThrow);

		btnThrow.addActionListener(this);

		faceToShow = new ImageIcon("DicePictures/faceValue1.png");
		resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
		showDice = new ImageIcon(resizedImage);
		lblDice2.setIcon(showDice);
		lblDice1.setIcon(showDice);

		finishTurn.addActionListener(this);

		add(finishTurn);
		add(cheat);
		finishTurn.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnThrow) {
			int faceValueDiceOne = (int) (Math.random() * (7 - 1) + 1);
			int faceValueDiceTwo = (int) (Math.random() * (7 - 1) + 1);

			switch (faceValueDiceOne) {
			case 1:
				faceToShow = new ImageIcon("DicePictures/faceValue1.png");
				break;

			case 2:
				faceToShow = new ImageIcon("DicePictures/faceValue2.png");
				break;

			case 3:
				faceToShow = new ImageIcon("DicePictures/faceValue3.png");
				break;

			case 4:
				faceToShow = new ImageIcon("DicePictures/faceValue4.png");
				break;

			case 5:
				faceToShow = new ImageIcon("DicePictures/faceValue5.png");
				break;

			case 6:
				faceToShow = new ImageIcon("DicePictures/faceValue6.png");
				break;
			}

			resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
			showDice = new ImageIcon(resizedImage);
			lblDice1.setIcon(showDice);

			switch (faceValueDiceTwo) {
			case 1:
				faceToShow = new ImageIcon("DicePictures/faceValue1.png");
				break;

			case 2:
				faceToShow = new ImageIcon("DicePictures/faceValue2.png");
				break;

			case 3:
				faceToShow = new ImageIcon("DicePictures/faceValue3.png");
				break;

			case 4:
				faceToShow = new ImageIcon("DicePictures/faceValue4.png");
				break;

			case 5:
				faceToShow = new ImageIcon("DicePictures/faceValue5.png");
				break;

			case 6:
				faceToShow = new ImageIcon("DicePictures/faceValue6.png");
				break;
			}

			if (faceValueDiceOne == faceValueDiceTwo) {
				setRoll(((faceValueDiceOne + faceValueDiceTwo) * 2));
				wsp.append(testPlayers.getActivePlayer().getName() + " Rolled a dubble: " + getRoll() + "\n");
			} else {
				setRoll(((faceValueDiceOne + faceValueDiceTwo)));
				wsp.append(testPlayers.getActivePlayer().getName() + " Rolled a: " + getRoll() + "\n");
			}
			resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
			showDice = new ImageIcon(resizedImage);
			lblDice2.setIcon(showDice);

			testPlayers.getActivePlayer().checkPlayerRank();
			manageEvents.setRoll(this);
			movePlayerThread = new Thread(new LoopThread(getRoll()));
			movePlayerThread.start();
			

			goEvent();
			
			
			
			tabPanel.addPlayerList(testPlayers);
			btnThrow.setEnabled(false);
			finishTurn.setEnabled(true);

		}

		if (e.getSource() == finishTurn) {

			testPlayers.switchToNextPlayer();
			new ShowPlayersTurn(testPlayers.getActivePlayer().getName(), "GREEN");
//			System.out.println(
//					"Next player turn" + "\n" + "Aktic playerindex: " + testPlayers.getActivePlayer().getPlayerIndex());
			btnThrow.setEnabled(true);
			finishTurn.setEnabled(false);
			tabPanel.setTab();

		}

	}

	public void moveWCheat(int i) {
		setRoll(i);
		testPlayers.getActivePlayer().checkPlayerRank();
		board.removePlayer(testPlayers.getActivePlayer());
		testPlayers.getActivePlayer().setPosition(getRoll());
		board.setPlayer(testPlayers.getActivePlayer());

		// För att testa händelser
		// Koppling mellan spelares index och TileCollection funkar
		manageEvents.setRoll(this);
		goEvent();
		manageEvents.newEvent(board.getDestinationTile(testPlayers.getActivePlayer().getPosition()),
				testPlayers.getActivePlayer());
		tabPanel.addPlayerList(testPlayers);
	}

	private class LoopThread implements Runnable {

		public LoopThread(int index) {
			setRoll(index);
		}

		public void run() {

			for (int i = 0; i < getRoll(); i++) {
				board.removePlayer(testPlayers.getActivePlayer());
				testPlayers.getActivePlayer().setPosition(1);
				board.setPlayer(testPlayers.getActivePlayer());

				if (i == (getRoll() - 1)) {
					manageEvents.newEvent(board.getDestinationTile(testPlayers.getActivePlayer().getPosition()),
							testPlayers.getActivePlayer());
				}

				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}

	private void goEvent() {

		if (testPlayers.getActivePlayer().passedGo()) {
			

			testPlayers.getActivePlayer().increaseBalance(200);
			testPlayers.getActivePlayer().increaseNetWorth(200);
			
			wsp.append("Passed Go \nand recived 200 Gold coins \n");
			testPlayers.getActivePlayer().resetPassedGo();
		}
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

//	public static void main(String[] args) {
//		Dice ui = new Dice();
//		JFrame frame = new JFrame();
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(ui);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//	}
}