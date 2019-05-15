package eastSidePanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import player.PlayerList;

/**
 * @author Abdulkhuder Muhammad, Sebastian Viro.
 *
 */ 
public class PlayerInfoPanel extends JPanel {
	
	//private PlayerList playerList;

    private JLabel lblName = new JLabel("");
    private JLabel lblRank = new JLabel("");

    private JLabel lblGold = new JLabel("100G");
    private JLabel lblNetworth = new JLabel("1000G");
    private JLabel lblProperty = new JLabel();
    private JLabel lblISAlive = new JLabel();
    private JLabel lblPropertyList = new JLabel();
//    private String name ;
    
   // private JLabel background = new JLabel(new ImageIcon("images/paperbg"));

    
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();
    private JPanel p6 = new JPanel();
    private JPanel p7 = new JPanel();


    
    private Font font = new Font("ALGERIAN", Font.BOLD, 14);
//    private JPanel lblISAlive = new JPanel();
//    private JPanel lblISAlive = new JPanel();
//    private JPanel lblISAlive = new JPanel();

    
    
    
    
    public PlayerInfoPanel(PlayerList playerList, int playa) {
 
    	
    	setPreferredSize(new Dimension(350,400));
    	setBackground(Color.DARK_GRAY);
    	setLayout(new GridLayout(7, 0));
    	
    //border shiet
    	
    	p1.setBorder(BorderFactory.createLineBorder(Color.black));
    	p2.setBorder(BorderFactory.createLineBorder(Color.black));
    	p3.setBorder(BorderFactory.createLineBorder(Color.black));
    	p4.setBorder(BorderFactory.createLineBorder(Color.black));
    	p5.setBorder(BorderFactory.createLineBorder(Color.black));
    	p6.setBorder(BorderFactory.createLineBorder(Color.black));

//    	p1.setOpaque(false);
//    	p2.setOpaque(false);
//    	p3.setOpaque(false);
//    	p4.setOpaque(false);
//    	p5.setOpaque(false);
//    	p6.setOpaque(false);

    	
    	
    	lblName.setText("Player name: " +playerList.getPlayerFromIndex(playa).getName().toUpperCase());
    	lblName.setFont(font);
    	lblName.setHorizontalAlignment(SwingConstants.CENTER);
    	lblName.setOpaque(true);
//    	p1.setBackground(p.getColor());
//    	lblName.setBackground(p.getColor());

    	p1.add(lblName);
    	add(p1);
    	
    	lblGold.setText("Amount of gold: " + playerList.getPlayerFromIndex(playa).getBalance() );
    	lblGold.setFont(font);
    	lblGold.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	
    	
    	p2.add(lblGold);
    	add(p2);

    	lblNetworth.setText("Total wealth: " + playerList.getPlayerFromIndex(playa).getNetWorth());
    	lblNetworth.setFont(font);
    	lblNetworth.setHorizontalAlignment(SwingConstants.CENTER);
    	p3.add(lblNetworth);
    	add(p3);

    	
    	
    	lblISAlive.setText(playerList.getPlayerFromIndex(playa).isAliveString());
    	lblISAlive.setFont(font);
    	lblISAlive.setHorizontalAlignment(SwingConstants.CENTER);
    	p4.add(lblISAlive);
    	add(p4);

    	lblRank.setText("Player Rank: "+playerList.getPlayerFromIndex(playa).getPlayerRank()); 
    	lblRank.setFont(font);
    	lblRank.setHorizontalAlignment(SwingConstants.CENTER);
    	p5.add(lblRank);
    	add(p5);
    	
    	lblProperty.setText("Properties"); 
    	lblProperty.setFont(font);
    	lblProperty.setHorizontalAlignment(SwingConstants.CENTER);
    	p6.add(lblProperty);
    	add(p6);

    	String pList=""+ playerList.getPlayerFromIndex(playa).getProperties() + "\n";
    	pList = pList.substring(1, pList.length()-1);
    	lblPropertyList.setText("" + pList); 
    	lblPropertyList.setFont(font);
    	lblPropertyList.setHorizontalAlignment(SwingConstants.CENTER);
    	p7.add(lblPropertyList);    	
    	add(p7);



    	
    	
	}
    


//	public static void main(String[] args) {
//		PlayerPanel ui = new PlayerPanel(1);
//		JFrame frame = new JFrame();
////		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
////		frame.setUndecorated(true);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.add(ui);
//		frame.pack();
//		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
//
//	}
}
