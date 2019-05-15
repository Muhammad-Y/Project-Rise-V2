package tiles;

import java.awt.Color;

/**
 * Information about each tiles.
 * @author Rohan
 *
 */
public class TileInfo {
	private String[] info;
	private String[] title;	
	
	public TileInfo() {
		
	}
	
	// An array with all information about each tile/Box.
	public String getInfo(int tile) {
		
		info = new String[]{"\n\n    Cash in 200 Gold coins \n"
				+ "            when you pass ",
				
				"2", "3", "4", 
				
				"5", 
				
				"6",				
				"7", 
				"Chance Card", 
				"9", 
				"10", 
				"11", 
				"12", 
				"13", 
				"14", 
				"15", 
				"16", 
				"17", 
				"Chance Card",
				"19", 
				"20", 
				"21", 
				"22",				
				"Chance Card", 
				"24", 
				"25", 
				"26", 
				"27", 
				"28", 
				"29", 
				"30",	 
				"31", 
				"32", 
				"33", 
				"Chance Card", 
				"35", 
				"36", 
				"Chance Card", 
				"38", 
				"39", 
				"40"};
		return info[tile];
	}
	
	public String getTitle(int i) {
		title = new String[] {"Go", "Wood Cutter", "Fortune Teller", "Title4", 
				"King Tax", "Work", "Title7", "Chance Card", "Title9", "Title10",
				"Jail", "Title12", "Title13", "Title14", "Title15", 
				"Work", "Title17", "Fortune Teller", "Title19", "Title20", 
				"Title21", "Title22", "Fortune Teller", "Title24", "Title25", 
				"Work", "Title27", "Title28", "Title29", "Title30", 
				"Go To Jail", "Title32", "Title33", "Fortune Teller", "Title35", 
				"Work", "Fortune Teller", "Title38", "King Tax", "Title40"}; 
				
		return title[i];
	}
	
	public Color getColor(int color) {
		Color[] tileColor;
		tileColor = new Color[] {new Color(58,20,56,255), new Color(131, 166, 219, 255), new Color(163,61,125,255),
				new Color(191,120,59,255), new Color(169, 60, 48, 255),new Color(254,231,11, 255), new Color(95,178,77, 255),
				new Color(4,74,159, 255), Color.DARK_GRAY};
		return tileColor[color];
	}
//	public static void main(String[] args) {
//		TileInfo t = new TileInfo();
//		System.out.println(t.getInfo(0));
//	}
}
