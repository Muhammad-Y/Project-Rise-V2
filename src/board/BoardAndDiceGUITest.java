package board;
 
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BoardAndDiceGUITest extends JPanel {
	private Board board = new Board();
	private SimplePlayer testPlayer = new SimplePlayer(0); 
	private DiceButton dice = new DiceButton(board, testPlayer);
	
	
	public BoardAndDiceGUITest() {
		setPreferredSize(new Dimension(800, 700));
		setLayout(new BorderLayout());
		
//		dice = new DiceButton(board);
		
		add(board, BorderLayout.CENTER);
		add(dice, BorderLayout.WEST); 
		board.addNewPlayer(testPlayer.getIndex()); 
	}
	
	public static void main(String [] args) {
		BoardAndDiceGUITest panelTest = new BoardAndDiceGUITest();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panelTest);
		frame.pack();
	}
	
	
}
