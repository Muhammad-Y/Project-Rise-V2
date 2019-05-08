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
		
		info = new String[]{"                GO 1 \nCash in 200GLD \n\nBut not in the first round",
				
				"Hello Rohan 2", 
				
				"Hello Seth 3", 
				
				"Hello Sebbe 4", 
				
				"Hello Aevan 5", 
				
				"6",				
				"7", 
				"8", 
				"9", 
				"10", 
				"11", 
				"12", 
				"13", 
				"14", 
				"15", 
				"16", 
				"17", 
				"18",
				"19", 
				"20", 
				"21", 
				"22",				
				"23", 
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
				"34", 
				"35", 
				"36", 
				"37", 
				"38", 
				"39", 
				"40"};
		return info[tile];
	}
	
	public String getTitle(int i) {
		title = new String[] {"{   Go   }", "{   Wood Cutter   }", "{   Treasure Chest   }", "Title4", 
				"Title5", "Title6", "Title7", "Title8", "Title9", "Title10",
				"{ Jail }", "Title12", "Title13", "Title14", "Title15", 
				"Title16", "Title17", "Title18", "Title19", "Title20", 
				"Title21", "Title22", "Title23", "Title24", "Title25", 
				"Title26", "Title27", "Title28", "Title29", "Title30", 
				"{   Go To Jail   }", "Title32", "Title33", "Title34", "Title35", 
				"Title36", "Title37", "Title38", "Title39", "Title40"}; 
				
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
