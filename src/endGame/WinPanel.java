package endGame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private ImageIcon imgBackground = new ImageIcon("images/win.png");
	private JLabel lblBackground = new JLabel("", imgBackground, JLabel.CENTER);

	public WinPanel() {
		
		createFrame();

		lblBackground.setBounds(0, 0, imgBackground.getIconWidth(), imgBackground.getIconHeight());

		
		add(lblBackground);
		setVisible(true);

	}

	public void createFrame() {
		setSize(imgBackground.getIconWidth(), imgBackground.getIconHeight());
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		WinPanel wp = new WinPanel();
		
	}



}
