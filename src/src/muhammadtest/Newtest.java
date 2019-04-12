package muhammadtest;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * Board klassen ska vara själva brädan, brädan innehåller en boardLayout med 40 rutor.
 * Centret innehåller bakgrundsbilden
 * North och South innehåller en grid layout med 11 rutor (Space objekt).
 * West och east innehåller varsin grid layout med 9 rutor (Space objekt).
 * Kommentarerna i koden är markers och tas bort då koden fungerar
 * @author sethoberg
 *
 */

public class Newtest extends JPanel {
	private JPanel[] gridSpaces = new JPanel[4];
	//private Space[] spaces;
	private ImageIcon boardImage ,showImage;
	
	//Ful lösning
	private GridLayout loop;
	private int longestLength;
	
	//Ta bort rad under detta.
	//nej! Denna fungerar... ish
	private JLabel haj = new JLabel();
	//private JLabel haj = new JLabel();
	//private TestImagePanel haj;
	
	
	//Jpanels med grid layouts för att lägga till alla Space objekt 
	//Dessa behöver på något sätt läggas in i en array så att man kan loopa igenom dem
	private JPanel northPanel = new JPanel(); //11 rutor
	private JPanel eastPanel = new JPanel(); //9 rutor
	private JPanel southPanel = new JPanel(); //11 rutor
	private JPanel westPanel = new JPanel(); //9 rutor
	
	private JPanel picPanel = new JPanel();
	
	//private PicturePanel picPanel = new PicturePanel();
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private int picwidth = (width-(width/2)+width/10);
	private int picHeight = (height-(height/10));

	
	
	//Skapar gridlayoutsen, används för att senare loopa igenom alla grids
	private int longGrid = 11;
	private int shortGrid = 9;
	
	//Basic default/tom konstruktor?
	public Newtest() {
		paintNewBoard();
		
		//Kan orsaka fel, lägger till alla paneler (med gridlyouts i en array)
		addPanelsToArray();
	}
	
	//När det riktiga board objektet skapas måste man lägga in alla Space objekten på rätt plats på brädan
//	public Newtest(Space[] spaces) {
//		paintNewBoard(spaces);
//	}
	
	
	
	
	//Metod som kallas på i konstruktorn (helst?) för att måla upp själva fönstret 
	public void paintNewBoard() { 
		
		
		
		
		//Graphics hola = haj.getGraphics();
		
		//Huvud JPanel objektet
		setPreferredSize(new Dimension(700,700)); 
		//setBackground(Color.RED);
		setLayout(new BorderLayout());
		
		
		//JLabel objektet ska vara i mitten och används för att måla upp bakgrunden
		//haj.setPreferredSize(new Dimension(500, 500));
		//haj.setIcon(null);
		//haj.setIcon(icon);
	    //haj.setOpaque(true);
		//haj.setIconTextGap(0);
		//haj.setSize(new Dimension(icon.getIconHeight(), icon.getIconWidth() ));

		//picPanel.setLayout(new BorderLayout());
		
		//North och South
		//haj.setIcon(icon);
		
		northPanel.setPreferredSize(new Dimension(80,80));
		northPanel.setLayout(new GridLayout(longGrid,1));
		northPanel.setBackground(Color.YELLOW);
		
		
		
		
		southPanel.setPreferredSize(new Dimension(80,80));
		southPanel.setLayout(new GridLayout(longGrid,1));
		southPanel.setBackground(Color.YELLOW); 
		
		//West och East
		westPanel.setPreferredSize(new Dimension(80,80));
		westPanel.setLayout(new GridLayout(1,shortGrid));
		westPanel.setBackground(Color.RED);
		
		eastPanel.setPreferredSize(new Dimension(80,80));
		eastPanel.setLayout(new GridLayout(1,shortGrid));
		eastPanel.setBackground(Color.pink);
		
		
		//Här läggs alla JPanels in på rätt ställe
//		 haj.setBackground(Color.black);
//		 haj.setOpaque(true);
//		 haj.revalidate();
//		 haj.repaint();
	   // haj.setPreferredSize(new Dimension(600,600));
		
		
		
		
		//picPanel.add(haj, BorderLayout.CENTER);

		boardImage = new ImageIcon("images/monopoly 3.0.png");
		haj = new JLabel();
		Image img = boardImage.getImage().getScaledInstance(picwidth, picHeight, Image.SCALE_SMOOTH);
		showImage = new ImageIcon(img);
		
		showImage = new ImageIcon(img);
		haj.setIcon(showImage);
		haj.setBounds(0, 0, 900, 900);
		picPanel.add(haj);
		
	//	picPanel.add();
		//picPanel.setPreferredSize(getMaximumSize());
		add(picPanel, BorderLayout.CENTER);
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
	
//	public void paintNewBoard(Space[] spaces) {
//		
//		
//		for(int i = 0; i < gridSpaces.length; i++) {
//			loop = (GridLayout) gridSpaces[i].getLayout();
//			
//			if(loop.getColumns() < loop.getRows()) {
//				longestLength = loop.getRows();
//			}
//			else {
//				longestLength = loop.getColumns();
//			}
//			
//			for(int j = 0; j < longestLength; j++) {
//				
//			}
//	}
		
	//}
	
	

}
