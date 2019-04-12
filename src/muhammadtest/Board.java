package muhammadtest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Board extends JPanel {
	
//	private JLabel lblBoard;
	//private ImageIcon boardImage, showImage;
	
	private JPanel centerPanel = new JPanel();
	private JPanel northPanel = new JPanel();
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	private nullBoard2 br = new nullBoard2();

	
//	private JLabel testlbl = new JLabel();

	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private int width = (int) screenSize.getWidth();
	private int height = (int) screenSize.getHeight();
	private int picwidth = (width-(width/2)+width/10);
	private int picHeight = (height-(height/10));
	
	
	
	public Board() {
		
		System.out.println(picwidth);
		setLayout(new BorderLayout());
	//	centerPanel.setLayout(new BorderLayout());		
		leftPanel.setLayout(new BorderLayout());
		rightPanel.setLayout(new BorderLayout());
		northPanel.setLayout(new BorderLayout());
		
		
		setPreferredSize(new Dimension(width, height));
		
//		boardImage = new ImageIcon("images/monopoly 3.000.png");
//		lblBoard = new JLabel();
//		Image img = boardImage.getImage().getScaledInstance(picwidth, picHeight, Image.SCALE_SMOOTH);
//		
//		showImage = new ImageIcon(img);
//		lblBoard.setIcon(showImage);
//		lblBoard.setBounds(0, 0, 900, 900);
//		centerPanel.add(lblBoard);
		centerPanel.setBackground(Color.DARK_GRAY);
	
		//testlbl.setText("dsdsa");
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setPreferredSize(new Dimension(350, 100));
		
		rightPanel.setBackground(Color.DARK_GRAY);
		rightPanel.setPreferredSize(new Dimension(350, 100));
		
		centerPanel.add(br ,BorderLayout.CENTER);
		add(rightPanel, BorderLayout.EAST);
		add(leftPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		
		
		
		
	}
	
	
	
public static void main(String[] args) {
	Board ui = new Board();
	JFrame frame = new JFrame("Chat");

	
	//fullscreen
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
