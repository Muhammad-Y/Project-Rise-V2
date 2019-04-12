package rohansTest;

/**
 * BoardClass creates a GUI and calls the methods in other classes to run/move the player.
 * @author Rohan
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Board extends JPanel {
	
	private Dice diceClass = new Dice();
	private GridPanel[] gridSpaces = new GridPanel[4];
	private SpaceTest[] spaces = new SpaceTest[40];  
	private int indexCounter = 0; 
	private JPanel pnlBtn = new JPanel();
	
	private int value1, value2, value3, value4;
	private int p1counter = 0;
	private int p1counter2 = 0;
	private int p2counter = 0;
	private int p2counter2 = 0;
	private int p3counter = 0;
	private int p3counter2 = 0;
	private int p4counter = 0;
	private int p4counter2 = 0;
	private int hajj = 0;
	
	private ImageIcon imagee = new ImageIcon("images/monoPolyPic.jpg");	
	private JButton dice = new JButton(new ImageIcon(imagee.getImage()));
	
	private GridPanel northPanel = new GridPanel(11); 
	private GridPanel eastPanel = new GridPanel(9); 
	private GridPanel southPanel = new GridPanel(11);
	private GridPanel westPanel = new GridPanel(9); 
	
	public Board() {
		addPanelsToArray();
		paintNewBoard();
		addEmptyGridPanels();
		paintNewBoard(spaces);
		setPlayerInIndex();
	}	
	public void addEmptyGridPanels() {		
		for (int i = 0; i < spaces.length; i++) {
			
			if(10 < i && i < 20 || 30 < i && i < 40) {
				spaces[i] = new SpaceTest(2); 
			}
			else {
				spaces[i] = new SpaceTest();
			}			
		}		
	}	
	public void setPlayerInIndex() {
		spaces[0].setPlayer1(0);
		spaces[0].setPlayer2(1);
		spaces[0].setPlayer3(2);
		spaces[0].setPlayer4(3);
	}	
	public void setPlayerInIndex(int index, int player) {
		spaces[index].setPlayer1(player);
	}	
	
	public void paintNewBoard() { 
		setPreferredSize(new Dimension(620, 620)); 
		setLayout(new BorderLayout());		
		northPanel.colPanel();
//		northPanel.setBackground(Color.magenta);
		southPanel.colPanel();
		//southPanel.setBackground(Color.cyan);
		eastPanel.rowPanel();
		//eastPanel.setBackground(Color.orange);
		westPanel.rowPanel();
		//westPanel.setBackground(Color.green);				
		dice.setEnabled(true);
		dice.setLayout(null);
		dice.setPreferredSize(new Dimension(100,30));
		dice.setBackground(Color.GREEN);
		dice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				move();				
			}					
		});
		pnlBtn.add(dice);	
		add(dice, BorderLayout.CENTER);		
		add(northPanel, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.EAST);	
	}	
	public void addPanelsToArray() {
		gridSpaces[0] = southPanel;
		gridSpaces[1] = westPanel;
		gridSpaces[2] = northPanel;
		gridSpaces[3] = eastPanel; 
	}	
	//Problem index 0 är index 10, grid object hanteras i fel ordning
	public void paintNewBoard(SpaceTest[] spaces) {		
		for(int i = 0; i < gridSpaces.length; i++) {
			hajj = gridSpaces[i].getNumberOfGrids();			
			for(int j = hajj; j > 0; j--) {
				gridSpaces[i].add(spaces[indexCounter]);
				if(i == 0 || i == 1) {
					gridSpaces[i].setComponentZOrder(spaces[indexCounter], 0 );
				}				
//				setComponentZOrder(spaces[indexCounter], j);
				indexCounter++;
			}
		}		
	}
	public void move() {
		value1 = diceClass.totalDice1();
		value2 = diceClass.totalDice2();
		value3 = diceClass.totalDice3();
		value4 = diceClass.totalDice4();
//		Player1
		p1counter2 = p1counter;
		p1counter += value1;
		if (p1counter > 39) {
			p1counter = p1counter - 40;
		}		
		spaces[p1counter].setPlayer1(0);
		spaces[p1counter2].removePlayer(0);
//		Player2
		p2counter2 = p2counter;
		p2counter += value2;
		if (p2counter > 39) {
			p2counter = p2counter - 40;
		}		
		spaces[p2counter].setPlayer2(1);
		spaces[p2counter2].removePlayer(1);
//		Player3
		p3counter2 = p3counter;
		p3counter += value3;
		if (p3counter > 39) {
			p3counter = p3counter - 40;
		}		
		spaces[p3counter].setPlayer3(2);
		spaces[p3counter2].removePlayer(2);
//		Player4
		p4counter2 = p4counter;
		p4counter += value4;
		if (p4counter > 39) {
			p4counter = p4counter - 40;
		}		
		spaces[p4counter].setPlayer4(3);
		spaces[p4counter2].removePlayer(3);		
	}	
	
	public static void main(String [] args) {
		BoardStarter boardStarter = new BoardStarter();
		boardStarter.showBoard();
	}
}
