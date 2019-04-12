package minaTester2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * Board klassen ska vara själva brädan, brädan innehåller en boardLayout med 40 rutor.
 * Centret innehåller bakgrundsbilden
 * North och South innehåller en grid layout med 11 rutor (Space objekt).
 * West och east innehåller varsin grid layout med 9 rutor (Space objekt).
 * Kommentarerna i koden är markers och tas bort då koden fungerar
 * @author sethoberg
 *
 */

public class Board extends JPanel {
	private GridPanel[] gridSpaces = new GridPanel[4];
	private SpaceTest[] spaces = new SpaceTest[40]; //skapar tomma space objekt med en bakgrund 
	private int indexCounter = 0; //räknar upp rätt index för space objekt i paneler

	private int hajj = 0;
	
	//Marker
	//Ändra så att bild läses in med ImageIO, går 50 gånger snabbare
	private ImageIcon imagee = new ImageIcon("images/monoPolyPic.jpg");
	private JLabel haj = new JLabel(new ImageIcon(imagee.getImage()));
	
	
	private GridPanel northPanel = new GridPanel(11); //11 rutor
	private GridPanel eastPanel = new GridPanel(9); //9 rutor
	private GridPanel southPanel = new GridPanel(11); //11 rutor
	private GridPanel westPanel = new GridPanel(9); //9 rutor
	
	
	//När det riktiga board objektet skapas måste man lägga in alla Space objekten på rätt plats på brädan
	public Board() {
		addPanelsToArray();
		paintNewBoard();
		addEmptyGridPanels();
		paintNewBoard(spaces);
//		setPlayerInIndex();
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
	
	
//	public void setPlayerInIndex() {
//		spaces[0].setPlayer1(0);
//		spaces[0].setPlayer2(1);
//		spaces[0].setPlayer3(2);
//		spaces[0].setPlayer4(3);
//	}
	
	
	//metoder under detta nya och ej färdigTestade
	
	public void addNewPlayer(int playerIndex) {
		spaces[0].setPlayer1(playerIndex);
	}
	
	
	//Metod för att flytta på en spelare, kallas från tärning klassen?
	public void movePlayer1(int amountOfSteps) {
//		spaces[playerCurrentIndex].removePlayer1(0);
		spaces[amountOfSteps].setPlayer1(0);
	}
	
	//Metod för att flytta på en spelare, kallas från tärning klassen?
		public void removePlayer1(int oldIndex) {
			spaces[oldIndex].removePlayer1(0);
		}
	
	
	
	
	
	
	
	public void paintNewBoard() { 
		setPreferredSize(new Dimension(700, 700)); 
		setLayout(new BorderLayout());
		
		
		northPanel.colPanel();
		//northPanel.setBackground(Color.magenta);
		southPanel.colPanel();
		//southPanel.setBackground(Color.cyan);
		eastPanel.rowPanel();
		//eastPanel.setBackground(Color.orange);
		westPanel.rowPanel();
		//westPanel.setBackground(Color.green);
		
		
		//Här läggs alla JPanels in på rätt ställe
		add(haj, BorderLayout.CENTER);
		
		
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
				
				indexCounter++;
			}
		}
		
	}
	
	
	
	
	
	
	
}
