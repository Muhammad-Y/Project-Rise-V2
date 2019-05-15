package dice;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cheat.CheatGui;


public class DiceGui extends JPanel implements ActionListener{
	
	private JButton finishTurn = new JButton("End Turn");
	private JButton btnThrow = new JButton("Roll Dice");

	private JLabel lblDice1 = new JLabel();
	private JLabel lblDice2 = new JLabel();
	private JPanel centerPanel = new JPanel();
	private ShowPlayersTurn showPlayer ;
	private CheatGui cheat = new CheatGui(this);


	ImageIcon faceToShow, showDice;
	Image resizedImage;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int diceWidth = (screenSize.width) / 20;
	private int diceHeight = (screenSize.height) / 10;
	

	
	public void addButtonsAndListeners() {
		
		showPlayer = new ShowPlayersTurn("Hej", "RED");
		add(showPlayer);
		add(lblDice1);

		add(lblDice2);
		add(btnThrow);
		faceToShow = new ImageIcon("DicePictures/faceValue1.png");
		resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
		showDice = new ImageIcon(resizedImage);
		lblDice2.setIcon(showDice);
		lblDice1.setIcon(showDice);


		add(finishTurn);
		add(cheat);
		
		
		finishTurn.addActionListener(this);

		btnThrow.addActionListener(this);

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

//			if (faceValueDiceOne == faceValueDiceTwo) {
//				setRoll(((faceValueDiceOne + faceValueDiceTwo) * 2));
//				wsp.append("\n" + testPlayers.getActivePlayer().getName() + " Rolled a dubble: " + getRoll());
//			} else {
//				setRoll(((faceValueDiceOne + faceValueDiceTwo)));
//				wsp.append("\n" + testPlayers.getActivePlayer().getName() + " Rolled a: " + getRoll());
			}
			resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
			showDice = new ImageIcon(resizedImage);
			lblDice2.setIcon(showDice);

//			testPlayers.getActivePlayer().checkPlayerRank();
//			manageEvents.setRoll(this);
//			movePlayerThread = new Thread(new LoopThread(getRoll()));
//			movePlayerThread.start();
			

//			goEvent();
			
			
			
//			tabPanel.addPlayerList(testPlayers);
			btnThrow.setEnabled(false);
			finishTurn.setEnabled(true);

//		}

		if (e.getSource() == finishTurn) {

//			testPlayers.switchToNextPlayer();
//			new ShowPlayersTurn(testPlayers.getActivePlayer().getName(), "GREEN");
//			System.out.println(
//					"Next player turn" + "\n" + "Aktic playerindex: " + testPlayers.getActivePlayer().getPlayerIndex());
			btnThrow.setEnabled(true);
			finishTurn.setEnabled(false);
//			tabPanel.setTab();

		}

	}

}
