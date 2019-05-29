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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import board.Rules;
import combinedPanels.GamePanels;
import startMenu.BackgroundMusic;
import startMenu.StartingScreen;

/**
 * This class displays the game board as well as what the players are called and
 * how much they own.
 * 
 * @autho Muhammad Hasan, Rohan Samandari
 */

public class Menu extends JPanel {
	private BackgroundMusic music;
	// Menu
	private JMenu jmMenu = new JMenu("Menu");
	private JMenuBar jmMenuBar = new JMenuBar();
	private JMenuItem jmExit = new JMenuItem("Exit");
	private JMenuItem jmOptions = new JMenuItem("Pause Music");
	private JMenuItem jmRestart = new JMenuItem("Restart Game");
	private JMenuItem jmRules = new JMenuItem("Read Rules");
	
	private Rules rules = new Rules();
//	private StartingScreen ss = new StartingScreen();
	/**
	 * Constructor used to create and draw in the frame.
	 */
	public Menu() {
		setOpaque(false);
		setPreferredSize(new Dimension(400, 40));
		setLayout(new BorderLayout());
		//jmMenuBar.setAlignmentX(LEFT_ALIGNMENT);
		jmMenuBar.setPreferredSize(new Dimension(100,5));
		jmExit.addActionListener(new ButtonListener()); 
		jmOptions.addActionListener(new ButtonListener()); 
		jmRules.addActionListener(new ButtonListener());
		jmRestart.addActionListener(new ButtonListener());
		jmMenu.add(jmOptions);
		jmMenu.add(jmRules);
		jmMenu.add(jmRestart);
		jmMenu.add(jmExit);
		jmMenuBar.add(jmMenu);
		
		add(jmMenuBar, BorderLayout.WEST);
		setBackground(Color.black);
	}
	public Menu(BackgroundMusic music) {
		this.music = music;
	}
	
	public class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==jmOptions) {
				JOptionPane.showInputDialog("Hello");
			} else if (e.getSource()==jmRestart) {
				StartingScreen ss = new StartingScreen();
				ss.initializeGUI();
				GamePanels gp = new GamePanels();
				gp.Dispose();
			} else if (e.getSource()==jmExit) {
				System.exit(0);
			} else if (e.getSource()==jmRules) {
				rules.showRules();
			}
		}
		
	}
	

//	public static void main(String[] args) {
//
//		Menu panelTest = new Menu();
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setVisible(true);
//		frame.getContentPane().add(panelTest);
//		frame.pack();
//		
//	}

}
