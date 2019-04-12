package muhammadtest;

import java.awt.Dimension;


import javax.swing.JFrame;

public class BoardStarter {
	private JFrame frame;
	private Newtest board = new Newtest();

	
	public BoardStarter() {
		
	}
	
	public void showBoard() {
		frame = new JFrame("Test av bräde");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(board);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String [] args) {
		BoardStarter boardStarter = new BoardStarter();
		boardStarter.showBoard();
	}
}
