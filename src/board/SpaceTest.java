package minaTester2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * Varje ruta ska vara ett Space objekt. Space objektet ärver JPanel 
 * och har en grid layout (4 stycken max) som spelare kan placeras i med en set metod
 * @author sethoberg
 */


public class SpaceTest extends JLabel {
	
	private ImageIcon icon = new ImageIcon("images/tile.jpg");
	private ImageIcon playerIcon1 = new ImageIcon("images/playerGreen.jpg");
	private ImageIcon playerIcon2 = new ImageIcon("images/playerMagenta.jpg");
	private ImageIcon playerIcon3 = new ImageIcon("images/playerOrange.jpg");
	private ImageIcon playerIcon4 = new ImageIcon("images/playerBlue.jpg");
	private JLabel[] labels = new JLabel[4];
	private JLabel label1 = new JLabel(); 
	private JLabel label2 = new JLabel(); 
	private JLabel label3 = new JLabel(); 
	private JLabel label4 = new JLabel(); 
	
	//private Border tileBorder = BorderFactory.createLineBorder(Color.black);
	
	private Border tileBorder = BorderFactory.createLineBorder(Color.decode("#ff7723"));
	

	public SpaceTest() {
		setPreferredSize(new Dimension(100, 100));
		setLayout(new GridLayout(4, 1));
		setIcon(icon);
		setBorder(tileBorder);
		
		addLabelsToArray();
		addLabelsToGrid();
	}
	
	public SpaceTest(int version2) {
		setPreferredSize(new Dimension(100, 100));
		setLayout(new GridLayout(1, 4));
		setIcon(icon);
		setBorder(tileBorder);
		
		addLabelsToArray();
		addLabelsToGrid();
	}
	
	public void addLabelsToArray() {
		labels[0] = label1;
		labels[1] = label2;
		labels[2] = label3;
		labels[3] = label4;
	}
	
	public void addLabelsToGrid() {
		for(int i = 0; i < labels.length; i++) {
			labels[i].setPreferredSize(new Dimension(100, 100));
			add(labels[i]);
		}
	}
	
//	public void setPlayer(int index) {
//		
//		labels[index].setIcon(playerIcon1);
//		labels[index].setHorizontalAlignment(CENTER);
//		
//	}
	
    public void setPlayer1(int index) {
		
		labels[index].setIcon(playerIcon1);
		labels[index].setHorizontalAlignment(CENTER);
		
	}
    
    
    //Varje gång en spelare flyttas måste den tas bort från rutan den flyttas från 
    public void removePlayer1(int index) {
    	labels[index].setIcon(null);
//		labels[index].repaint();
    }
    
    
    public void setPlayer2(int index) {
		
		labels[index].setIcon(playerIcon2);
		labels[index].setHorizontalAlignment(CENTER);
		
	}
 
    public void setPlayer3(int index) {
		
		labels[index].setIcon(playerIcon3);
		labels[index].setHorizontalAlignment(CENTER);
		
	}
    
    public void setPlayer4(int index) {
		
		labels[index].setIcon(playerIcon4);
		labels[index].setHorizontalAlignment(CENTER);
		
	}
	
	
	
//	public static void main(String [] args) {
//		JFrame frame = new JFrame(); 
//		SpaceTest testSpace = new SpaceTest();
//		frame.setPreferredSize(new Dimension(200, 200));
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(testSpace);
//		testSpace.setPlayer(2);
//		testSpace.setPlayer2(1);
//		frame.pack();
//		frame.setVisible(true);
//	}
	
	
}
