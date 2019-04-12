package muhammadtest;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.Color;

public class nullBoard extends JPanel {
	
	
	
	public nullBoard() {
		setPreferredSize(new Dimension(1000, 1000));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1050, 1000);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\muham\\OneDrive\\Desktop\\git\\Project-Rise\\images\\monopoly 1000.png"));
		add(lblNewLabel);
		
		JPanel goPanel = new JPanel();
		goPanel.setBounds(865, 865, 135, 135);
		add(goPanel);
		 
		JPanel woodChopper = new JPanel();
		woodChopper.setBounds(783, 865, 81, 135);
		add(woodChopper);
		
		JPanel FortuneTeller1 = new JPanel();
		FortuneTeller1.setBounds(702, 865, 81, 135);
		add(FortuneTeller1);
		  
		JPanel stoneMason = new JPanel();
		stoneMason.setBounds(623, 865, 81, 135);
		add(stoneMason);
		
		JPanel kingsTaxSouth = new JPanel();
		kingsTaxSouth.setBounds(542, 865, 81, 135);
		add(kingsTaxSouth);
		
		JPanel workSouth = new JPanel();
		workSouth.setBounds(462, 865, 81, 135);
		add(workSouth);
		
		JPanel fishStall = new JPanel();
		fishStall.setBounds(381, 865, 81, 135);
		add(fishStall);
		
		JPanel fortuneTeller2 = new JPanel();
		fortuneTeller2.setBounds(300, 865, 81, 135);
		add(fortuneTeller2);
		
		JPanel veggieStall = new JPanel();
		veggieStall.setBounds(220, 865, 81, 135);
		add(veggieStall);
		
		JPanel bakerStall = new JPanel();
		bakerStall.setBounds(138, 865, 81, 135);
		add(bakerStall);
		
		JPanel jail = new JPanel();
		jail.setBounds(0, 865, 135, 135);
		add(jail);
		
		JPanel tanner = new JPanel();
		tanner.setBounds(0, 785, 135, 81);
		add(tanner);
		
		JPanel tavernWest = new JPanel();
		tavernWest.setBounds(0, 705, 135, 81);
		add(tavernWest);
		
		JPanel mill = new JPanel();
		mill.setBounds(0, 625, 135, 81);
		add(mill);
		
		JPanel blacksmith = new JPanel();
		blacksmith.setBounds(0, 545, 135, 81);
		add(blacksmith);
		
		JPanel workWest = new JPanel();
		workWest.setBounds(0, 460, 135, 81);
		add(workWest);
		
		JPanel bathHouse = new JPanel();
		bathHouse.setBounds(0, 378, 135, 81);
		add(bathHouse);
		
		JPanel fotunetellerWest = new JPanel();
		fotunetellerWest.setBounds(0, 297, 135, 81);
		add(fotunetellerWest);
		
		JPanel bakerStore = new JPanel();
		bakerStore.setBounds(0, 218, 135, 81);
		add(bakerStore);
		
		JPanel butcher = new JPanel();
		butcher.setBounds(0, 136, 135, 81);
		add(butcher);
		
		JPanel sundayChurch = new JPanel();
		sundayChurch.setBounds(0, 0, 135, 135);
		add(sundayChurch);
		
		JPanel warehouse = new JPanel();
		warehouse.setBounds(135, 0, 84, 135);
		add(warehouse);
		
		JPanel fortuneTellerNorth = new JPanel();
		fortuneTellerNorth.setBounds(217, 0, 84, 135);
		add(fortuneTellerNorth);
		
		JPanel alchemist = new JPanel();
		alchemist.setBounds(297, 0, 84, 135);
		add(alchemist);
		
		JPanel stable = new JPanel();
		stable.setBounds(381, 0, 84, 135);
		add(stable);
		
		JPanel workNorth = new JPanel();
		workNorth.setBounds(459, 0, 84, 135);
		add(workNorth);
		
		JPanel cobbler = new JPanel();
		cobbler.setBounds(539, 0, 84, 135);
		add(cobbler);
		
		JPanel trader = new JPanel();
		trader.setBounds(620, 0, 84, 135);
		add(trader);
		
		JPanel tavernNorth = new JPanel();
		tavernNorth.setBounds(702, 0, 84, 135);
		add(tavernNorth);
		
		JPanel goldSmith = new JPanel();
		goldSmith.setBounds(780, 0, 84, 135);
		add(goldSmith);
		
		JPanel goToJail = new JPanel();
		goToJail.setBounds(865, 0, 135, 135);
		add(goToJail);
		
		JPanel armorer = new JPanel();
		armorer.setBounds(865, 136, 135, 81);
		add(armorer);
		
		JPanel tailor = new JPanel();
		tailor.setBounds(865, 218, 135, 81);
		add(tailor);
		
		JPanel fortuneTellerEast1 = new JPanel();
		fortuneTellerEast1.setBounds(865, 297, 135, 81);
		add(fortuneTellerEast1);
		
		JPanel weaponShop = new JPanel();
		weaponShop.setBounds(865, 378, 135, 81);
		add(weaponShop);
		
		JPanel workEast = new JPanel();
		workEast.setBounds(865, 460, 135, 81);
		add(workEast);
		
		JPanel fortuneTellerEast2 = new JPanel();
		fortuneTellerEast2.setBounds(865, 545, 135, 81);
		add(fortuneTellerEast2);
		
		JPanel Church = new JPanel();
		Church.setBounds(865, 625, 135, 81);
		add(Church);
		
		JPanel KingsTaxEast = new JPanel();
		KingsTaxEast.setBounds(865, 705, 135, 81);
		add(KingsTaxEast);
		
		JPanel castle = new JPanel();
		castle.setBounds(865, 785, 135, 81);
		add(castle);
	} 
	 
	
	public static void main(String[] args) {
		nullBoard ui = new nullBoard();
		JFrame frame = new JFrame();
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
