package board;
 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class DiceButton extends JPanel {
	private Board board;
	private SimplePlayer testPlayer;
	private JButton randomNumber = new JButton("Slå tärning");
	private int newIndex;
	private ButtonListener buttonListener = new ButtonListener();
//	private Font font = new Font(name, style, size);
	
	Random rand = new Random();
	
	public DiceButton(Board board, SimplePlayer player) {
		this.board = board;
		this.testPlayer = player;
		initializePanel();
		addButtonAndListener(); 
	}
	
//	public DiceButton(Board board) {
//		this.board = board;
//		initializePanel();
//		addButtonAndListener();
//	}
	
	public DiceButton() {
		initializePanel();
		addButtonAndListener();
	}
	
	
	public void initializePanel() {
		setPreferredSize(new Dimension(100, 800));
		
	}
	
	public void addButtonAndListener() {
//		randomNumber.setFont(font);
		randomNumber.addActionListener(buttonListener);
		add(randomNumber);
	}
	
	
	
	private class ButtonListener implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == randomNumber) {
				
				board.removePlayer1(0);
				board.movePlayer1(3);
				
				System.out.println(rand.nextInt(11)+2);
				newIndex = rand.nextInt(11)+2;
				board.removePlayer1(testPlayer.getIndex());
				testPlayer.setCounter(newIndex);
				board.movePlayer1(testPlayer.getIndex());
			}
		}
		
	}
	
	
//	public static void main(String[] args) {
//		DiceButton hej = new DiceButton();
//		JFrame frame = new JFrame("Visa tärning"); 
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.add(hej);
//		frame.pack();
//	}
	
	

}
