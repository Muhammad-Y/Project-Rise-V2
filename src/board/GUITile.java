package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import player.Player;

import java.awt.font.*;


/**
 * Varje ruta ska vara ett Space objekt. Space objektet ärver JPanel 
 * och har en grid layout (4 stycken max) som spelare kan placeras i med en set metod (I JLabel objekt)
 * @author sethoberg
 */


public class GUITile extends JLabel {
	 
	/**
	 * Behövs ett serialVersionUID?
	 */
	private static final long serialVersionUID = 1L;

	//Dessa imageIcon objekt SKA tas bort och används endast för tester just nu, istället ska man 
    //lägga till spelare med en set metod i varje JLabel objekt 
	
	private Font labelFont = new Font("Arial", Font.BOLD, 10);
	
	private JLabel infoLabel = new JLabel("", SwingConstants.CENTER);
	private JLabel labelArray = new JLabel();
	private JLabel[] labels = new JLabel[4];
	private JLabel label1 = new JLabel(); 
	private JLabel label2 = new JLabel(); 
	private JLabel label3 = new JLabel(); 
	private JLabel label4 = new JLabel(); 
	
	private int alignment = 1;
	
	private Border tileBorder = BorderFactory.createLineBorder(Color.decode("#ff7723"));
	

	
	/**
	 * 
	 */
	public GUITile() {
		setPreferredSize(new Dimension(200, 300));
		setLayout(new BorderLayout());
		setBorder(tileBorder);
		
		labelArray.setLayout(new GridLayout(2,2));
		labelArray.setOpaque(true);
		labelArray.setBackground(Color.decode("#ffe9c6"));
		
		styleAndAddInfoLabel();
		addLabelsToArray();
		addLabelsToGrid();
	}
	
	
	/**
	 * Konstruktor som tar emot en int för placering av info JLabel objektet 
	 * @param SouthWestNorthEast antingen 1, 2, 3, 4
	 * Kan detta göras med swingConstants.vertical???
	 */
	public GUITile(int SouthWestNorthEast) {
		alignment = SouthWestNorthEast;
		
		setPreferredSize(new Dimension(200, 300));
		setLayout(new BorderLayout());
//		setBorder(tileBorder);
		
		labelArray.setLayout(new GridLayout(2,2));
		labelArray.setOpaque(false);
		labelArray.setBackground(Color.decode("#ffe9c6"));
		
		styleAndAddInfoLabel();
		addLabelsToArray();
		addLabelsToGrid();
	}
	
	

	/**
	 * JLabel objekt för varje Tile som visar vilken nivå en fastighet är i
	 */
	public void styleAndAddInfoLabel() {
		infoLabel.setPreferredSize(new Dimension(200, 20));
		infoLabel.setOpaque(false);
		infoLabel.setForeground(Color.white);
		infoLabel.setFont(labelFont);
		infoLabel.setText("");
		infoLabel.setBackground(Color.magenta);
		
		
		//lägg till label i position beroende på vart på brädan den ligger
		if(alignment == 1) {
			add(infoLabel,BorderLayout.NORTH);
		}
		else if(alignment == 2) {
			infoLabel.setPreferredSize(new Dimension(20, 200));
			add(infoLabel,BorderLayout.EAST);
		}
		else if(alignment == 3) {
			add(infoLabel,BorderLayout.SOUTH);
		}
		else if(alignment == 4) {
			infoLabel.setPreferredSize(new Dimension(20, 200));
			add(infoLabel,BorderLayout.WEST);
		}
		
		
	}
	
	
	/**
	 * Varje grid ruta läggs till, 4st 
	 */
	public void addLabelsToArray() {
		labels[0] = label1;
		labels[1] = label2;
		labels[2] = label3;
		labels[3] = label4;
	}
	
	//Lägga till 4st JLabels
	public void addLabelsToGrid() {
		for(int i = 0; i < labels.length; i++) {
			labels[i].setPreferredSize(new Dimension(200, 200));
			labelArray.add(labels[i]);
		}
		add(labelArray, BorderLayout.CENTER);
	}
	
	
	//uppdatera level på fastighet/gata 
	public void changeLevel(String level) {
		infoLabel.setText(level);
	}
	
	
	/**
	 * Varje ruta har 4 platser där en spelare kan placeras 
	 * @param index är spelarens playerIndex, spelare 1 har index 0, spelare 2 = 1
	 * Detta borde effektiviseras, gör en metod som hämtar spelarens playerIndex 
	 * och sedan placerar det i en av rutorna
	 */
	    
    
    public void setPlayer(Player player) {
		labels[player.getPlayerIndex()].setIcon(player.getImage());
		labels[player.getPlayerIndex()].setHorizontalAlignment(CENTER);
	}
    
    public void removePlayer(Player player) {
		labels[player.getPlayerIndex()].setIcon(null);
		labels[player.getPlayerIndex()].setHorizontalAlignment(CENTER);
	}
    

	
}
