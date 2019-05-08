package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * This class displays the game board as well as what the players are called and
 * how much they own.
 * 
 * @autho Muhammad Hasan
 */

public class Menu extends JPanel {
	// Menu
	private JMenu jmMenu = new JMenu("Menu");
	private JMenuBar jmMenuBar = new JMenuBar();
	private JMenuItem jmExit = new JMenuItem("Exit");
	private JMenuItem jmOptions = new JMenuItem("mute");

	/**
	 * Constructor used to create and draw in the frame.
	 */
	public Menu() {
		setOpaque(false);
		setPreferredSize(new Dimension(400, 40));
		setLayout(new BorderLayout());
		//jmMenuBar.setAlignmentX(LEFT_ALIGNMENT);
		jmMenuBar.setPreferredSize(new Dimension(100,5));
		jmMenu.add(jmExit);
		jmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jmMenu.add(jmOptions);

		jmMenuBar.add(jmMenu);
		
		add(jmMenuBar, BorderLayout.WEST);
		setBackground(Color.black);


	}

	public static void main(String[] args) {

		Menu panelTest = new Menu();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().add(panelTest);
		frame.pack();
		
	}

}