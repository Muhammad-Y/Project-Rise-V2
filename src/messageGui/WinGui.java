package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import events.ManageEvents;

public class WinGui extends JPanel {

	private JLabel lblLblpic = new JLabel("lblPic");

	public WinGui() {
		
		addgui();

	}
	
	public void addgui() {
		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);

		lblLblpic.setBounds(0, 0, 1027, 500);
		lblLblpic.setIcon(
				new ImageIcon("images/Rise Winner.png"));
		add(lblLblpic);
		getFrame();
	}

	public void getFrame() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		WinGui mGUI = new WinGui();
		JFrame frame = new JFrame();
		
		frame.setUndecorated(true);	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mGUI);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
