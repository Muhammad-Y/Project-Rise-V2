package westSidePanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import player.Player;;



public class ManageWindow extends JFrame{
	private JPanel  pnlProp1, pnlLblProp1, pnlInfo1, pnlProp2, pnlProp3;
	private JLabel lblProp1, lblLevel1, lblProp2, lblProp3, lblProp4, lblSpace, lblColor;
	private String prop1, level1, prop2, prop3;
	private JButton btnPropUp1, btnPropUp2, btnPropUp3;
	private JButton btnPropDown1, btnPropDown2, btnPropDown3;
	private JButton btnSell1, btnSell2, btnSell3;
	private Border border = BorderFactory.createLineBorder(Color.darkGray);
	private Font font = new Font("ALGERIAN", Font.BOLD, 14);
	private Player player;
	
	// Main frame
	public ManageWindow() {
		this.player = player;
		setSize(505, 630);
		setLocation(200, 150);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		
		showGUI();
		setResizable(false);
		setVisible(true);
	}
	 
	// main Panel
	private void showGUI() {
		
		// Creates a background image
		ImageIcon bGround = new ImageIcon("images/wall.png");
		Image img = bGround.getImage();
		Image tempImage = img.getScaledInstance(500, 600, Image.SCALE_SMOOTH);
		bGround = new ImageIcon(tempImage);
		JLabel lblWindow = new JLabel("", bGround, JLabel.CENTER);		
		panels();		
		lblWindow.setBorder(border);
		lblWindow.setBounds(0,0,500,600);
		lblWindow.add(pnlProp1);
		
		add(lblWindow);
	} 
	
	private void panels() {
		
		// the for sats does not work yet.  
		for(int i=0; i<4; i++) {
			
		// Panel property 1
		pnlProp1 = new JPanel();
		
		pnlLblProp1 = new JPanel();
		pnlLblProp1.setBackground(Color.GRAY);
		
		// Color shall be changeable
		lblColor = new JLabel();
		lblColor.setPreferredSize(new Dimension(40, 80));
		lblColor.setOpaque(true);
		lblColor.setBackground(Color.green);
		// You should be able to change the text. Not done yet
		prop1 = "Rohans Land";
		level1 = " 3";
		lblProp1 = new JLabel(prop1, SwingConstants.CENTER);
		lblLevel1 = new JLabel("Level: " + level1, SwingConstants.CENTER);
		lblLevel1.setFont(font);
		lblProp1.setPreferredSize(new Dimension(130, 80));
		lblProp1.setFont(font);
		lblProp1.add(lblLevel1);
		
		// Two lablels on this panel. One for title and one for which level the player is on
		pnlInfo1 = new JPanel(new GridLayout(2,1));
		pnlInfo1.setOpaque(false);
		pnlInfo1.setPreferredSize(new Dimension(130, 80));
		pnlInfo1.add(lblProp1);
		pnlInfo1.add(lblLevel1);
		
		lblSpace = new JLabel("             ");
		
		// The panel includes all of the property one
		pnlLblProp1.setPreferredSize(new Dimension(185, 90));
		pnlLblProp1.setBackground(new Color(255, 255, 255, 80));
		pnlLblProp1.setBorder(border);
		pnlLblProp1.add(lblColor);
		pnlLblProp1.add(pnlInfo1);
		pnlProp1.setBorder(border);
		
		// Buttons
		btnPropUp1 = new JButton("Upgrade");
		btnPropDown1 = new JButton("Downgrade");
		btnSell1 = new JButton("Sell");
		pnlProp1.setBounds(5,25, 490, 100);
		pnlProp1.setBackground(new Color(0,0,0,30));
		pnlProp1.add(pnlLblProp1);
		pnlProp1.add(lblSpace);
		pnlProp1.add(btnPropUp1);
		pnlProp1.add(btnPropDown1);
		pnlProp1.add(btnSell1);
		}
	}
	
	
	
	public static void main(String[] args) {
//		Player p1 = new Player("Momo", new ImageIcon("images/playerYellow.jpg"), 0);
//		p1.addNewProperty(newProperty);
//		new ManageWindow(p1);
		new ManageWindow();
	}
}
