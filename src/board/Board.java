package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import player.Player;
import player.PlayerList;
import tiles.Property;
import tiles.Tile;
import tileCollection.TileCollection;
import tiles.TileInfo;
import westSidePanel.WestSidePanel;



/**
 * @author Muhammad Abdulkhuder, Seth öberg, Rohan Samandari
 *
 */
public class Board extends JPanel {
	
	private WestSidePanel pnlWest;
	private TileInfo info = new TileInfo();
	
	//Gui Tile klassen borde dÃ¶pas om till typ GUITile sÃ¥ att det blir tydligare 
	private GUITile[] tiles = new GUITile[40]; //skapar tomma Tile objekt med en bakgrund 
	private PlayerList playerList = new PlayerList();
	private Listener listener = new Listener();
	
	//Ny
	private TileCollection tileCollection = new TileCollection();
	private Property property ;
	
	private JFrame hej;
	
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


	JLabel lblNewLabel = new JLabel();

	
	public Board() {
		initializeAllPanels();	
		
		initializeGUI(); 
	}

	public Board(WestSidePanel wp) {
		this.pnlWest = wp;
		initializeAllPanels();	
		
		initializeGUI(); 
	}
	
	
	
	public Board(PlayerList playerList) {
		initializeAllPanels();	
		this.playerList = playerList; 
		
	}

	public Board(PlayerList playerList,WestSidePanel wp) {
		initializeAllPanels();	
		this.playerList = playerList;  
		
	}

	
	public void addPlayers(PlayerList playerList) {
		this.playerList = playerList;
	}
	
	
	//testa sÃ¥ att spelare lÃ¤sts in pÃ¥ rÃ¤tt sÃ¤tt
	public void printPlayers() {
		
		for(int i = 0; i < playerList.getLength(); i++) {
			System.out.println(playerList.getPlayerFromIndex(i).getName() + " " + 
		playerList.getPlayerFromIndex(i).getImage() + " " + playerList.getPlayerFromIndex(i).getPlayerIndex());
		}
		
	}
	
	 
	//Kopiera 
	public void setPlayers() {
		
		for(int i = 0; i < playerList.getLength(); i++) {
			setPlayer(playerList.getPlayerFromIndex(i));
		}
		
	}
	
	
	//Ta bort! 
	public void startboard() {
		hej = new JFrame("Tjena");
		hej.setPreferredSize(new Dimension(750, 750));
		hej.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hej.setVisible(true);
		hej.add(this);
		hej.pack();
	}
	
	
	//initiera alla paneler hÃ¤r istÃ¤llet fÃ¶r att gÃ¶ra det i konstruktor
	public void initializeAllPanels() {
		setPreferredSize(new Dimension(750, 750));
		setLayout(null);

		//Att mÃ¥la upp alla paneler borde gÃ¶ras om till en metod
		p1.setOpaque(false);
		p1.setBounds(649, 650, 101, 100);
		add(p1);

		p2.setOpaque(false);
		p2.setBounds(587, 651, 60, 99);
		add(p2);

		p3.setOpaque(false);
		p3.setBounds(525, 650, 60, 100);
		add(p3);

		p4.setOpaque(false);
		p4.setBounds(467, 650, 60, 100);
		add(p4);

		p5.setOpaque(false);
		p5.setBounds(412, 650, 53, 100);
		add(p5);

		p6.setOpaque(false);
		p6.setBounds(346, 650, 66, 100);
		add(p6);

		p7.setOpaque(false);
		p7.setBounds(283, 650, 66, 100);
		add(p7);

		p8.setOpaque(false);
		p8.setBounds(225, 651, 60, 99);
		add(p8);

		p9.setOpaque(false);
		p9.setBounds(163, 651, 66, 99);
		add(p9);

		p10.setOpaque(false);
		p10.setBounds(103, 650, 60, 100);
		add(p10);

		p11.setOpaque(false);
		p11.setBounds(0, 650, 101, 100);
		add(p11);

		p12.setOpaque(false);
		p12.setBounds(0, 587, 101, 62);
		add(p12);

		p13.setOpaque(false);
		p13.setBounds(0, 527, 101, 62);
		add(p13);

		p14.setOpaque(false);
		p14.setBounds(0, 465, 101, 62);
		add(p14);

		p15.setOpaque(false);
		p15.setBounds(0, 407, 101, 62);
		add(p15);

		p16.setOpaque(false);
		p16.setBounds(0, 345, 101, 62);
		add(p16);

		p17.setOpaque(false);
		p17.setBounds(0, 281, 101, 62);
		add(p17);  

		p18.setOpaque(false);
		p18.setBounds(0, 218, 101, 62);
		add(p18);

		p19.setOpaque(false);
		p19.setBounds(0, 162, 101, 62);
		add(p19);

		p20.setOpaque(false);
		p20.setBounds(0, 103, 101, 62);
		add(p20);

		p21.setOpaque(false);
		p21.setBounds(0, 0, 101, 100);
		add(p21);

		p22.setOpaque(false);
		p22.setBounds(103, 0, 60, 100);
		add(p22);

		p23.setOpaque(false);
		p23.setBounds(163, 0, 60, 100);
		add(p23);

		p24.setOpaque(false);
		p24.setBounds(225, 0, 60, 100);
		add(p24);

		p25.setOpaque(false);
		p25.setBounds(283, 0, 66, 100);
		add(p25);

		p26.setOpaque(false);
		p26.setBounds(346, 0, 60, 100);
		add(p26);

		p27.setOpaque(false);
		p27.setBounds(407, 0, 60, 100);
		add(p27);

		p28.setOpaque(false);
		p28.setBounds(467, 0, 60, 100);
		add(p28);

		p29.setOpaque(false);
		p29.setBounds(525, 0, 60, 100);
		add(p29);

		p30.setOpaque(false);
		p30.setBounds(587, 0, 60, 100);
		add(p30);

		p31.setOpaque(false);
		p31.setBounds(649, 0, 101, 100);
		add(p31);

		p32.setOpaque(false);
		p32.setBounds(649, 103, 101, 62);
		add(p32);

		p33.setOpaque(false);
		p33.setBounds(649, 162, 101, 62);
		add(p33);

		p34.setOpaque(false);
		p34.setBounds(649, 228, 101, 62);
		add(p34);

		p35.setOpaque(false);
		p35.setBounds(649, 281, 101, 62);
		add(p35);

		p36.setOpaque(false);
		p36.setBounds(649, 345, 101, 62);
		add(p36);

		p37.setOpaque(false);
		p37.setBounds(649, 407, 101, 62);
		add(p37);

		p38.setOpaque(false);
		p38.setBounds(649, 465, 101, 62);
		add(p38);

		p39.setOpaque(false); 
		p39.setBounds(649, 527, 101, 62);
		add(p39);

		p40.setOpaque(false);
		p40.setBounds(649, 587, 101, 62);
		add(p40);
		
		//MouseListener		
		for (int i=0; i<panelarray.length; i++) {
			panelarray[i].addMouseListener(listener);
		}

		lblNewLabel.setBounds(0, -136, 1050, 1022);
		lblNewLabel.setIcon(new ImageIcon("images/monopoly 750.png"));
		add(lblNewLabel);
		
		for (int i = 0; i < panelarray.length; i++) {
			panelarray[i].setLayout(new BorderLayout());
		}
	}
	

	public void initializeGUI() {
		addEmptyGridPanels();
		paintNewBoard(tiles); //en fÃ¤rdig array med alla 40 tiles mÃ¥ste skickas in till board
		
	}
	
	
	public GUITile getTileAtIndex(int index) {
		return tiles[index];
	}
	
	
	public void addEmptyGridPanels() {
		for (int i = 0; i < tiles.length; i++) {
			
			//Beroende pÃ¥ vart objekt lÃ¤ggs in behÃ¶ver JLabel objektet lÃ¤ggas in pÃ¥ olika platser
			//Denna del BORDE efektiviseras 
			//Olika konstruktorer av NewTile() beroende pÃ¥ vart objekt ska placeras 
			
			//Det behÃ¶vs fler konstruktorer fÃ¶r tomma rutor som besÃ¶k av fÃ¤ngelse
			//stationer/work etc 
			
			//Om index 0-10 ska JLabel lÃ¤ggas in i north
			if(i < 11) {
				tiles[i] = new GUITile(1); 
			}
			//Om index 11-20 ska JLabel lÃ¤ggas i east
			else if(i < 20) {
				tiles[i] = new GUITile(2); 
			}
			//Om index 20-30 ska JLabel lÃ¤ggas i south
			else if(i < 31) {
				tiles[i] = new GUITile(3); 
			}
			//Om index 30-39 ska JLabel lÃ¤ggas i west
			else if(i < 40) {
				tiles[i] = new GUITile(4); 
			}
			
		}
		
	}
	
	
	//skicka in spelar objekt fÃ¶r att fÃ¶rflytta och ta bort spelar objekt
	public void setPlayer(Player player) {
		tiles[player.getIndex()].setPlayer(player); 
	}
	public void removePlayer(Player player) {
		tiles[player.getIndex()].removePlayer(player);
	}
	
	
	//Method called when the user arrives at the destination tile
	public Tile getDestinationTile(int index) {
		return tileCollection.getTileAtIndex(index);
	}
	 
	
	
	//AnvÃ¤nds fÃ¶r att initiera alla space/rutor 
	//HÃ¤r behÃ¶ver en fÃ¤rdig array med alla 40 tile objekt skickas in
	public void paintNewBoard(GUITile[] spaces) {

		for(int i = 0; i < panelarray.length; i ++) {
			panelarray[i].add(spaces[i]);
		}
		
	}
public class Listener implements MouseListener {

		
		public void mouseClicked(MouseEvent e) {
			// nothing will happen by clicking
		}
		
			public void mouseEntered(MouseEvent e) {
				for (int i=0; i<panelarray.length; i++) {
					if (e.getSource()==panelarray[i]) {
						if (i == 0 || i == 2 ||i == 4 || i == 5 ||i == 7 || 
								i == 10 ||i == 12 || i == 15 ||i == 17 || 
								i == 20 ||i == 22 || i == 25 ||i == 28 || i == 30 ||
								i == 33 ||i == 35 || i == 36 || i == 38){
								pnlWest.setTitleText(info.getInfo(i), info.getTitle(i), info.getColor(8), Color.white);
						}else if(i==26 || i==27 || i==29) {
							pnlWest.setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
							tileCollection.getTileAtIndex(i).getTitle(), tileCollection.getTileAtIndex(i).getColor(), Color.white );
							pnlWest.setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
									tileCollection.getTileAtIndex(i).getTitle(), info.getColor(5), Color.black);
						}else {						
							pnlWest.setTitleText(tileCollection.getTileAtIndex(i).getTileInfo(),
								tileCollection.getTileAtIndex(i).getTitle(), tileCollection.getTileAtIndex(i).getColor(), Color.white );
						}
					}
				}		
			}
			public void mouseExited(MouseEvent e) {
				pnlWest.setTextDefault();
			}
			public void mousePressed(MouseEvent e) {
				// Nothing will happen by pressed button
			}
			public void mouseReleased(MouseEvent e) {
				// Nothing will happen by releasing button
			}
}

}
