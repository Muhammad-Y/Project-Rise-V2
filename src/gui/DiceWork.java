package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.Border;
import projectrise.Player;
import tiles.Work;

/**
 * @author AevanDino, SebastianViro
 */
public class DiceWork extends JPanel {
	
	// This is a usless comment
	
	Player player;
	//Changes
	/* Size of screen and width and height of our dice */
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	
	private int diceWidth = (screenSize.width)/20;
	private int diceHeight = (screenSize.height)/10;

	/* Button, and two labels who later are set to dices */
	private JButton btnRollDice = new JButton("Roll Dice");
	private JButton btnCashIn = new JButton("Cash in");
	private JLabel lblDiceOne = new JLabel();
	private JLabel lblDiceTwo = new JLabel();
	private JLabel lblInfo = new JLabel();
	private JPanel centerPanel = new JPanel();
	
	private static int totalValue = 0;
	
	public DiceWork(Player player) {
		this.player = player;
	}
	
//	/* Constructor used to display the graphics */
//	public DiceWork() {
//		setLayout(new BorderLayout());
//		setPreferredSize(new Dimension(200, 250));
//
//		lblDiceOne.setPreferredSize(new Dimension(diceWidth, diceHeight));
//		lblDiceOne.setIcon(new ImageIcon("DicePictures/faceValue1.png"));
//		centerPanel.add(lblDiceOne);
//
//		lblDiceTwo.setPreferredSize(new Dimension(diceWidth, diceHeight));
//		lblDiceTwo.setIcon(new ImageIcon("DicePictures/faceValue1.png"));
//		centerPanel.add(lblDiceTwo);
//		
//		lblInfo .setPreferredSize(new Dimension(diceWidth * 2, 50));
//		
//		btnRollDice.setPreferredSize(new Dimension(100, 30));
//		btnRollDice.addActionListener(new DiceRoller());
//		btnCashIn.setPreferredSize(new Dimension(100, 30));
//		btnCashIn.addActionListener(new DiceRoller());
//		btnRollDice.setEnabled(true);
//		btnCashIn.setEnabled(false);
//		centerPanel.add(btnRollDice);
//		centerPanel.add(lblInfo);
//		centerPanel.add(btnCashIn);
//
//		this.add(centerPanel);
//	}

	/* Class which rolls dice when button is clicked */
	private class DiceRoller implements ActionListener {
		ImageIcon faceToShow, showDice;
		Image resizedImage;
		Work work = new Work();
		/* Whenever button is pressed, this method is ran */
		public void actionPerformed(ActionEvent e) {
			
			if( e.getSource() == btnRollDice ) {
				btnRollDice.setEnabled(false);
				btnCashIn.setEnabled(true);
				int faceValueDiceOne = (int) (Math.random() * (7 - 1) + 1);
				int faceValueDiceTwo = (int) (Math.random() * (7 - 1) + 1);
				totalValue += faceValueDiceOne + faceValueDiceTwo;
				
				switch(faceValueDiceOne) {
				case 1: faceToShow = new ImageIcon("DicePictures/faceValue1.png");
				break;

				case 2: faceToShow = new ImageIcon("DicePictures/faceValue2.png");
				break;

				case 3: faceToShow = new ImageIcon("DicePictures/faceValue3.png");
				break;

				case 4: faceToShow = new ImageIcon("DicePictures/faceValue4.png");
				break;

				case 5: faceToShow = new ImageIcon("DicePictures/faceValue5.png");
				break;

				case 6: faceToShow = new ImageIcon("DicePictures/faceValue6.png");
				break;
				}

				resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
				showDice = new ImageIcon(resizedImage);
				lblDiceOne.setIcon(showDice);

				switch(faceValueDiceTwo) {
				case 1: faceToShow = new ImageIcon("DicePictures/faceValue1.png");
				break;

				case 2: faceToShow = new ImageIcon("DicePictures/faceValue2.png");
				break;

				case 3: faceToShow = new ImageIcon("DicePictures/faceValue3.png");
				break;

				case 4: faceToShow = new ImageIcon("DicePictures/faceValue4.png");
				break;

				case 5: faceToShow = new ImageIcon("DicePictures/faceValue5.png");
				break;

				case 6: faceToShow = new ImageIcon("DicePictures/faceValue6.png");
				break;
				}
				resizedImage = faceToShow.getImage().getScaledInstance(diceWidth, diceHeight, Image.SCALE_SMOOTH);
				showDice = new ImageIcon(resizedImage);
				lblDiceTwo.setIcon(showDice);
				lblInfo.setText("You receive: " + player.getPlayerRank().getSalary(totalValue) + " gold coins");
			}
			
			if(e.getSource() == btnCashIn) {
				work.payPlayer(totalValue);
			}
		}
	}
	
	public void startGUI() {		
		lblDiceOne.setPreferredSize(new Dimension(diceWidth, diceHeight));
		lblDiceOne.setIcon(new ImageIcon("DicePictures/faceValue1.png"));
		centerPanel.add(lblDiceOne);

		lblDiceTwo.setPreferredSize(new Dimension(diceWidth, diceHeight));
		lblDiceTwo.setIcon(new ImageIcon("DicePictures/faceValue1.png"));
		centerPanel.add(lblDiceTwo);
		
		lblInfo .setPreferredSize(new Dimension(diceWidth * 2, 50));
		
		btnRollDice.setPreferredSize(new Dimension(100, 30));
		btnRollDice.addActionListener(new DiceRoller());
		btnCashIn.setPreferredSize(new Dimension(100, 30));
		btnCashIn.addActionListener(new DiceRoller());
		btnRollDice.setEnabled(true);
		btnCashIn.setEnabled(false);
		centerPanel.add(btnRollDice);
		centerPanel.add(lblInfo);
		centerPanel.add(btnCashIn);

		JFrame frame = new JFrame("Dice Roller");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setSize(new Dimension(200, 300));
		
		this.setPreferredSize(new Dimension(200, 250));

		
		frame.add(centerPanel);
	}

}