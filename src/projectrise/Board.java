package projectrise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This class displays the game board as well as what the players
 * are called and how much they own.
 * @author AevanDino, Muhammad
 */

public class Board extends JPanel {
	//Menu
	private JMenu jmMenu =new JMenu("Menu");
	private JMenuBar jmMenuBar = new JMenuBar();
	private JMenuItem jmExit = new JMenuItem("Exit");
	private JMenuItem jmOptions = new JMenuItem("Options");
	private  JPanel menupanel = new JPanel();
	
	private JLabel lblBoard;
	private ImageIcon boardImage, showImage;
	private JPanel centerPanel = new JPanel();
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	// ratio related
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private int picwidth = (width-(width/2)+width/10);
	private int picHeight = (height-(height/10));
	
	// Graphics2d
	private static Graphics2D g;


	/**
	 * Constructor used to create and draw in the frame.
	 */
	public Board() {
		setLayout(new BorderLayout());		
		setPreferredSize(new Dimension(width, height));
		menupanel.setLayout(new BorderLayout());

		boardImage = new ImageIcon("images/monopoly 3.0.png");

		lblBoard = new JLabel();

		Image img = boardImage.getImage().getScaledInstance(picwidth, picHeight, Image.SCALE_SMOOTH);
		showImage = new ImageIcon(img);
		lblBoard.setIcon(showImage);
		lblBoard.setBounds(0, 0, 900, 900);
		centerPanel.add(lblBoard);
		jmMenu.add(jmExit);
		jmMenu.add(jmExit);
		   jmExit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        });
		jmMenuBar.add(jmMenu);
		menupanel.add(jmMenuBar, BorderLayout.WEST);
		menupanel.setBackground(Color.black);
		this.add(menupanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
				
	}

	public static void main(String[] args) {
		Board ui = new Board();
		JFrame frame = new JFrame("Chat");
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setUndecorated(true);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(ui);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
