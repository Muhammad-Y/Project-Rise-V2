package westSidePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;


/**
 * The WestPanel on the GUIwindow which will show information about each game tiles. The meaning is to show- 
 * - an image of the tile/box. and information with text shall be shown in a separate panel/textArea.
 * @author Rohan
 *
 */ 


// Vi kan uppdatera panelen så den visar en bild på spelrutan på den centrala panelen och en beskrivning(text)-
// - som visas i under panelen. 


public class InfoPanel extends JFrame{
	
	private JLabel lblInfo, lblSpace;
	private JPanel pnlHeading, pnlInfo, pnlMessage, pnlBtn, pnlInBtn;
	private Font font = new Font("ALGERIAN", Font.BOLD, 24);
	private JTextArea txtTileInfo = new JTextArea();
	private JTextArea txtMessage = new JTextArea();
	private JScrollPane scroller = new JScrollPane(txtMessage);
//	private Border border = BorderFactory.createLineBorder(new Color(165,42,42, 225));
	private Border border = BorderFactory.createLineBorder(Color.darkGray);
	// test
	private JButton btn = new JButton("......"); 
	private JButton btnHelp = new JButton("Help");
	private JButton btnManage = new JButton("Manage \nProperties");

	
	/**
	 * Sets the location, size other stuffs of JFrame.
	 */
	public InfoPanel(){		
		setSize(418, 902);
		setLocation(-8, 0);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		showGUI();
		setResizable(true);
		setVisible(true);
	}
	
	/**
	 * Creates the other panels and boxes in the FrameWindow.
	 */
	private void showGUI() {		
		
		ImageIcon bGround = new ImageIcon("images/wall.png");
		Image img = bGround.getImage();
		Image tempImage = img.getScaledInstance(400, 900, Image.SCALE_SMOOTH);
		bGround = new ImageIcon(tempImage);
		JLabel lblWindow = new JLabel("", bGround, JLabel.CENTER);

		
		lblSpace = new JLabel();
		lblSpace.setPreferredSize(new Dimension(45, 30));
		
		
		lblInfo = new JLabel();
		lblInfo.setText("Information");
		lblInfo.setBackground(new Color(102,102,102,140));
		lblInfo.setOpaque(true);
		lblInfo.setFont(font);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setPreferredSize(new Dimension(300, 40));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlHeading = new JPanel();
		pnlHeading.setBackground(new Color(0,0,0,20));
		pnlHeading.setBounds(35,20,325,100);
		pnlHeading.setBorder(border);
		pnlHeading.add(lblSpace);
		pnlHeading.add(lblInfo);
		
		pnlInfo = new JPanel();
		txtTileInfo.setFont(new Font("ALGERIAN", Font.BOLD, 18));
		txtTileInfo.setMargin(new Insets(10, 10, 10, 10));
		txtTileInfo.setText("           Rohans land \n\nRent		  $14\nRent with color set	  $28\n"
				+ "Rent with 1 house	  $70\nRent with 2 houses	  $200\nRent with 3 houses	  $550\n"
				+ "Rent with a hotel	  $950\nHouses costs       $100 each\nHotels costs       $100 each\n              "
				+ "              +4Houses");
		txtTileInfo.setEditable(false);
		txtTileInfo.setPreferredSize(new Dimension(300, 315));
		txtTileInfo.setBackground(Color.white);
		txtTileInfo.setForeground(new Color(71,60,50,225));
		pnlInfo.setBackground(new Color(0,0,0,30));
		pnlInfo.setBounds(35, 130, 325, 330 );
		pnlInfo.setBorder(border);
		pnlInfo.add(txtTileInfo);
		
		pnlInBtn = new JPanel(new GridLayout());
		pnlInBtn.setPreferredSize(new Dimension(300,60));
		pnlBtn = new JPanel();
		pnlBtn.setBounds(35, 470, 325, 100);
		pnlBtn.setBackground(new Color(0,0,0,20));
		pnlBtn.setBorder(border);
		
		btnManage.setForeground(new Color(71,60,50,225));
		btnManage.setFont(font);
		btnManage.setPreferredSize(new Dimension(300, 80));
		
		
		btnHelp.setForeground(new Color(71,60,50,225));
		btnHelp.setPreferredSize(new Dimension(80,40));
		btnHelp.setFont(new Font("Algerian", Font.BOLD, 14));
		btnManage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ManageWindow();
			}			
		});
		
		pnlInBtn.add(btnManage);
		JLabel space = new JLabel();
		space.setPreferredSize(new Dimension(30,10) );
		pnlBtn.add(space);
		pnlBtn.add(pnlInBtn);
		
		
		pnlMessage = new JPanel();
		txtMessage.setFont(new Font("ALGERIAN", Font.BOLD, 18));
		txtMessage.setMargin(new Insets(10,10,10,10));
		txtMessage.setText("Game History\nshows here..");
		scroller.setPreferredSize(new Dimension(300,250));
		scroller.setBackground(Color.white);
		scroller.setForeground(new Color(71,60,50,225));
//		txtMessage.setEditable(false);
		
		pnlMessage.setBackground(new Color(0,0,0,20));
		pnlMessage.setBounds(35, 580, 325,265);
		pnlMessage.setBorder(border);
		pnlMessage.add(scroller);
				
		lblWindow.setPreferredSize(new Dimension(400, 900));	
		lblWindow.setBorder(border);
		lblWindow.setBounds(0,0,400,855);		
		lblWindow.add(pnlHeading);
		lblWindow.add(pnlInfo);
		lblWindow.add(pnlBtn);
		lblWindow.add(pnlMessage);

		add(lblWindow);			
	}
	
	public static void main(String[] args) {
		new InfoPanel();
		
	}
}
