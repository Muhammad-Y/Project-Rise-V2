package muhammadtest;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.MatteBorder;

public class nullBoard2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();
	JPanel p9 = new JPanel();
	JPanel p10 = new JPanel();
	JPanel p11 = new JPanel();
	JPanel p12 = new JPanel();
	JPanel p13 = new JPanel();
	JPanel p14 = new JPanel();
	JPanel p15 = new JPanel();
	JPanel p16 = new JPanel();
	JPanel p17 = new JPanel();
	JPanel p18 = new JPanel();
	JPanel p19 = new JPanel();
	JPanel p20 = new JPanel();
	JPanel p21 = new JPanel();
	JPanel p22 = new JPanel();
	JPanel p23 = new JPanel();
	JPanel p24 = new JPanel();
	JPanel p25 = new JPanel();
	JPanel p26 = new JPanel();
	JPanel p27 = new JPanel();
	JPanel p28 = new JPanel();
	JPanel p29 = new JPanel();
	JPanel p30 = new JPanel();
	JPanel p31 = new JPanel();
	JPanel p32 = new JPanel();
	JPanel p33 = new JPanel();
	JPanel p34 = new JPanel();
	JPanel p35 = new JPanel();
	JPanel p36 = new JPanel();
	JPanel p37 = new JPanel();
	JPanel p38 = new JPanel();
	JPanel p39 = new JPanel();
	JPanel p40 = new JPanel();

	JPanel[] panelarray = { p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20,
			p21, p22, p23, p24, p25, p26, p27, p28, p29, p30, p31, p32, p33, p34, p35, p36, p37, p38, p39, p40 };

	JLabel player = new JLabel(new ImageIcon("images\\playerBlue.jpg"));

	JLabel lblNewLabel = new JLabel("New label");

	

	
	public nullBoard2() {
		setPreferredSize(new Dimension(1000, 1000));
		setLayout(null);

		p1.setOpaque(false);
		p1.setBounds(865, 865, 135, 135);
		add(p1);

		p2.setOpaque(false);
		p2.setBounds(783, 865, 81, 135);
		add(p2);

		p3.setOpaque(false);
		p3.setBounds(702, 865, 81, 135);
		add(p3);

		p4.setOpaque(false);
		p4.setBounds(623, 865, 81, 135);
		add(p4);

		p5.setOpaque(false);
		p5.setBounds(542, 865, 81, 135);
		add(p5);

		p6.setOpaque(false);
		p6.setBounds(462, 865, 81, 135);
		add(p6);

		p7.setOpaque(false);
		p7.setBounds(381, 865, 81, 135);
		add(p7);

		p8.setOpaque(false);
		p8.setBounds(300, 865, 81, 135);
		add(p8);

		p9.setOpaque(false);
		p9.setBounds(220, 865, 81, 135);
		add(p9);

		p10.setOpaque(false);
		p10.setBounds(138, 865, 81, 135);
		add(p10);

		p11.setOpaque(false);
		p11.setBounds(0, 865, 135, 135);
		add(p11);

		p12.setOpaque(false);
		p12.setBounds(0, 785, 135, 81);
		add(p12);

		p13.setOpaque(false);
		p13.setBounds(0, 705, 135, 81);
		add(p13);

		p14.setOpaque(false);
		p14.setBounds(0, 625, 135, 81);
		add(p14);

		p15.setOpaque(false);
		p15.setBounds(0, 545, 135, 81);
		add(p15);

		p16.setOpaque(false);
		p16.setBounds(0, 460, 135, 81);
		add(p16);

		p17.setOpaque(false);
		p17.setBounds(0, 378, 135, 81);
		add(p17);  

		p18.setOpaque(false);
		p18.setBounds(0, 297, 135, 81);
		add(p18);

		p19.setOpaque(false);
		p19.setBounds(0, 218, 135, 81);
		add(p19);

		p20.setOpaque(false);
		p20.setBounds(0, 136, 135, 81);
		add(p20);

		p21.setOpaque(false);
		p21.setBounds(0, 0, 135, 135);
		add(p21);

		p22.setOpaque(false);
		p22.setBounds(135, 0, 84, 135);
		add(p22);

		p23.setOpaque(false);
		p23.setBounds(217, 0, 84, 135);
		add(p23);

		p24.setOpaque(false);
		p24.setBounds(297, 0, 84, 135);
		add(p24);

		p25.setOpaque(false);
		p25.setBounds(381, 0, 84, 135);
		add(p25);

		p26.setOpaque(false);
		p26.setBounds(459, 0, 84, 135);
		add(p26);

		p27.setOpaque(false);
		p27.setBounds(539, 0, 84, 135);
		add(p27);

		p28.setOpaque(false);
		p28.setBounds(620, 0, 84, 135);
		add(p28);

		p29.setOpaque(false);
		p29.setBounds(702, 0, 84, 135);
		add(p29);

		p30.setOpaque(false);
		p30.setBounds(780, 0, 84, 135);
		add(p30);

		p31.setOpaque(false);
		p31.setBounds(865, 0, 135, 135);
		add(p31);

		p32.setOpaque(false);
		p32.setBounds(865, 136, 135, 81);
		add(p32);

		p33.setOpaque(false);
		p33.setBounds(865, 218, 135, 81);
		add(p33);

		p34.setOpaque(false);
		p34.setBounds(865, 297, 135, 81);
		add(p34);

		p35.setOpaque(false);
		p35.setBounds(865, 378, 135, 81);
		add(p35);

		p36.setOpaque(false);
		p36.setBounds(865, 460, 135, 81);
		add(p36);

		p37.setOpaque(false);
		p37.setBounds(865, 545, 135, 81);
		add(p37);

		p38.setOpaque(false);
		p38.setBounds(865, 625, 135, 81);
		add(p38);

		p39.setOpaque(false); 
		p39.setBounds(865, 705, 135, 81);
		add(p39);

		p40.setOpaque(false);
		p40.setBounds(865, 785, 135, 81);
		add(p40);

		player.setOpaque(true);
		player.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		player.setPreferredSize(new Dimension(50, 50));
		player.setForeground(Color.RED);
		player.setAlignmentX(Component.CENTER_ALIGNMENT);
		player.setBackground(Color.MAGENTA);
		// player.setIcon(new ImageIcon("images\\playerBlue.jpg"));

		lblNewLabel.setBounds(0, 0, 1050, 1000);
		lblNewLabel.setIcon(new ImageIcon("images\\monopoly 1000.png"));
		add(lblNewLabel);

	}
	
	public void move(int start,int end) {
		
			
			
				
				for(int i = start; i <=end; i++) {
					if (i==40) {
						i=0;
					}
					panelarray[i].add(player);
					
					
					
				}
			
		
		
	

	}

	public static void main(String[] args) {
		nullBoard2 ui = new nullBoard2();
		//plzwork u = new plzwork();

		JFrame frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(ui);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		ui.move(0,20);

	}
}
