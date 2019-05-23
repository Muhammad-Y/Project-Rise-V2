package messageGui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import events.ManageEvents;

public class MessageGUI extends JPanel{

    private JPanel centerPanel = new JPanel();
    private JPanel outerPanel = new JPanel();
    private JLabel type = new JLabel();
    private JTextPane dis = new JTextPane();

    private Color color1 = new Color(102,178,255);
    private Font fontType = new Font("ALGERIAN", Font.BOLD, 30);
    private Font fontDis = new Font("ALGERIAN", Font.ITALIC, 20);

    private ManageEvents me;
    
    public MessageGUI() {
//    	startGUI();
	}
    
    public MessageGUI(ManageEvents me) {
    	this.me = me;
    }
    
    public void startGUI() {
    	setLayout(new BorderLayout());
        outerPanel.setLayout(new BorderLayout());
        centerPanel.setLayout(new BorderLayout());

        setPreferredSize(new Dimension(500, 250));
        setBackground(Color.black);
        setForeground(Color.black);

        setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.black));
        outerPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,Color.DARK_GRAY));
        centerPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,Color.gray));

        type.setPreferredSize(new Dimension(200,70));
        type.setFont(fontType);
        type.setHorizontalAlignment(SwingConstants.CENTER);
        dis.setFont(fontDis);
//        dis.setBackground(color1);

    //    dis.setHorizontalAlignment(SwingConstants.CENTER);

//        centerPanel.setBackground(color1);
        centerPanel.add(type,BorderLayout.NORTH);
        centerPanel.add(dis,BorderLayout.CENTER);

        add(outerPanel, BorderLayout.CENTER);
        outerPanel.add(centerPanel, BorderLayout.CENTER); 
        getFrame();
        
    }
    
    public void newFortune(Boolean b, int amount) {
    	if(b) {
    		type.setText("Blessing");
    		 dis.setText("\n                        Fortune smiles upon you. \n"
    	                + "                            You recived " + amount + " GC");
    		 dis.setBackground(new Color(102,178,255));
    		 centerPanel.setBackground(new Color(102,178,255));
    	} else {
    		type.setText("Curse");
    		dis.setText("\n                        You have been cursed! \n"
	                + "                            You pay " + amount + " GC");
    		dis.setBackground(new Color(209, 13, 10));
    		centerPanel.setBackground(new Color(209, 13, 10));
    	}
//    	new MessageGUI();
    	startGUI();
    }
    
    public void getFrame() {
//		MessageGUI mGUI = new MessageGUI();
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
