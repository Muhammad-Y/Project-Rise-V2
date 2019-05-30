package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SecretGui extends JFrame {
	
    private JLabel lblSecret = new JLabel();
    private Thread thread;
    private Dimension sSize = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = (int)sSize.getWidth();
    private int height = (int)sSize.getHeight();
    
	public SecretGui() {
			
	   	setLayout(new BorderLayout());
	   	setPreferredSize(new Dimension(320, 180));
	   	setBackground(Color.black);
	   	setForeground(Color.black);
	   	setLocation(width/2 -160, height/2-375);
	        
	   	lblSecret.setPreferredSize(new Dimension(320, 180));
	   	lblSecret.setIcon(new ImageIcon("images/$$$.jpg"));
	       
	   	add(lblSecret);	
	   	setVisible(true);
	   	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	   	pack();
	   	setVisible(true);
	   	thread  = new Thread(new Sleeper());
	   	thread.start();
		
	}
	
	 private class Sleeper extends Thread {
	    	
	    	public void run() {
	    		try { 
	    			Thread.sleep(15000);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		} finally {
					dispose();
				}
	    	}
	    }
}
