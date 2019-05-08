package tiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardTest extends JPanel { 

	private ImageIcon imgCenter;
	private JLabel lblShowImage;

	private JPanel northPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel controlPanelWest = new JPanel();
	private JPanel controlPanelEast = new JPanel();

	
	private JPanel gamePanel = new JPanel();

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	// ratio related
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private int picwidth = ((width/2));
	private int picHeight = (height - (height/3)+height/10);

	public BoardTest() {
		
		setPreferredSize(screenSize);
		setLayout(new BorderLayout());
		
		gamePanel.setPreferredSize(new Dimension(width/2, width/2)); 
		gamePanel.setLayout(new BorderLayout());
		
		controlPanelWest.setPreferredSize(new Dimension(width/5, height));
		controlPanelWest.setLayout(null);
		
		controlPanelEast.setPreferredSize(new Dimension(width/5, height));
		controlPanelEast.setLayout(null);
		
		Image img = new ImageIcon("images/monopolyPic.jpg").getImage().getScaledInstance(picwidth, picHeight, Image.SCALE_SMOOTH);
		imgCenter = new ImageIcon(img);
		lblShowImage = new JLabel();
		lblShowImage.setIcon(imgCenter);

		//North och South
		northPanel.setPreferredSize(new Dimension(width,height/7));
		northPanel.setLayout(new GridLayout(11,1));
		northPanel.setBackground(Color.YELLOW);

		southPanel.setPreferredSize(new Dimension(width,height/7));
		southPanel.setLayout(new GridLayout(11,1));
		southPanel.setBackground(Color.BLUE); 

		//West och East
		westPanel.setPreferredSize(new Dimension(width/10,height));
		westPanel.setLayout(new GridLayout(1,9));
		westPanel.setBackground(Color.GREEN);

		eastPanel.setPreferredSize(new Dimension(width/10,height));
		eastPanel.setLayout(new GridLayout(1,9));
		eastPanel.setBackground(Color.RED);


		gamePanel.add(lblShowImage, BorderLayout.CENTER);
		gamePanel.add(northPanel, BorderLayout.NORTH);
		gamePanel.add(southPanel, BorderLayout.SOUTH);
		gamePanel.add(westPanel, BorderLayout.WEST);
		gamePanel.add(eastPanel, BorderLayout.EAST);
//		gamePanel.add(controlPanelWest);
		
		add(gamePanel, BorderLayout.CENTER);
		add(controlPanelWest, BorderLayout.WEST);
		add(controlPanelEast, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		BoardTest b = new BoardTest();
		JFrame frame = new JFrame("BoardTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(b);
		frame.pack();
		frame.setVisible(true);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	}
}