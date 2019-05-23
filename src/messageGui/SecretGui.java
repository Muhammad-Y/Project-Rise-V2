package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class SecretGui extends JFrame {
	
    private JLabel lblSecret = new JLabel();
    private Thread thread;

	public SecretGui() {
		
	
	    	setLayout(new BorderLayout());
	     
	        setPreferredSize(new Dimension(320, 180));
	        setBackground(Color.black);
	        setForeground(Color.black);

	        lblSecret.setPreferredSize(new Dimension(320, 180));
	        lblSecret.setIcon(new ImageIcon("images/$$$.jpg"));
	       
	        add(lblSecret);
	        
	        
	    

	    
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			pack();
			setVisible(true);
//			setLocationRelativeTo(null);
			thread  = new Thread(new Sleeper());
		       thread.start();
		
	}
	
	 private class Sleeper extends Thread {
	    	
	    	public void run() {
	    		try { 
	    			thread.sleep(15000);
	    		} catch (Exception e) {
	    			e.printStackTrace();
	    		} finally {
					dispose();
				}
	    	}
	    }

}
