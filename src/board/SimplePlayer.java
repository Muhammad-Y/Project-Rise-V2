package board;

import javax.swing.ImageIcon;

public class SimplePlayer {
	private ImageIcon playerIcon;
	private int counter;
	private int playerIndex; 
	
	public SimplePlayer(ImageIcon playerIconColor, int newPlayerIndex) {
		playerIcon = playerIconColor;
		counter = 0;
	}
	
	public SimplePlayer(int newPlayerIndex) {
		counter = 0;
	}
	
	public int getIndex() {
		return playerIndex;
	}
	
	public void setCounter(int amountOfStepsToMove) {
		
		for(int i = 0; i < amountOfStepsToMove; i++ ) {
			
			if(counter < 39) {
				counter++;
			}
			else {
				counter = 0;
			}
			
			
		}
	}
	
	
	public String getImage() {
		return playerIcon.toString();
	}
	
//	public int getCounter() {
//		return counter;
//	}
	
	
//	public static void main(String [] args) {
//		SimplePlayer testPlayer = new SimplePlayer(new ImageIcon("images/playerBlue.jpg"));
//		testPlayer.setCounter(3);
//		System.out.println(testPlayer.getCounter());
//		testPlayer.setCounter(30);
//		System.out.println(testPlayer.getCounter());
//		testPlayer.setCounter(4);
//		System.out.println(testPlayer.getCounter());
//		testPlayer.setCounter(4);
//		System.out.println(testPlayer.getCounter()); 
//	}
	
	
}
