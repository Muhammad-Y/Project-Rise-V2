package muhammadtest;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PicturePanel extends JPanel {
	private BufferedImage bi;

	public PicturePanel() {

		try {
			bi = ImageIO.read(new File("images/monopoly 3.000 .png"));
		} catch (IOException ex) {
			Logger.getLogger(PicturePanel.class.getName()).log(Level.SEVERE, null, ex);
		}

		final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics g) {
				Graphics g2 = g.create();
				g2.drawImage(bi, 0, 0, getWidth(), getHeight(), null);
				g2.dispose();
			}

			
			public Dimension getPreferredSize() {
				return new Dimension(bi.getWidth(), bi.getHeight());

				// return new Dimension(200, 200);
			}
		};

		add(panel);
	}

	public static void main(String args[]) {
//		SwingUtilities.invokeLater(new Runnable() {
//
//			public void run() {
//				PicturePanel imgPanel = new PicturePanel();
//				JOptionPane.showMessageDialog(null, imgPanel, "Image Panel", JOptionPane.PLAIN_MESSAGE);
//			}
//
//		});

		PicturePanel ui = new PicturePanel();
		JFrame frame = new JFrame("Chat");

		// fullscreen
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(ui);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}
}
