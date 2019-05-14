package tileCollection;

/** 
 * Informtion about each tiles. 
 * Price, Title, 
 * @author Rohan, Sebastian
 */

import java.awt.Color;

import tiles.ChanceCard;
import tiles.Go;
import tiles.GoToJail;
import tiles.Jail;
import tiles.Property;
import tiles.SundayChurch;
import tiles.Tavern;
import tiles.Tax;
import tiles.Tile;
import tiles.Work;

public class TileCollection {

	private Tile[] tileArray = new Tile[40];

	public TileCollection() {
		
		tileArray[0] = new Go("GO");
		tileArray[1] = new Property("Wood Cutter Camp", 60, 2, 15, new Color(58,20,56,255));
		tileArray[2] = new ChanceCard();
		tileArray[3] = new Property("Stone Mason Camp", 60, 4, 15, new Color(58,20,56,255));
		tileArray[4] = new Tax();
		tileArray[5] = new Work(); 
		tileArray[6] = new Property("Vegetables Stand", 100, 6, 20, new Color(131, 166, 219, 255));
		tileArray[7] = new ChanceCard();
		tileArray[8] = new Property("Fish Stand", 100, 6, 25, new Color(131, 166, 219, 255));
		tileArray[9] = new Property("Bakery Stand", 120, 8, 30, new Color(131, 166, 219, 255));
		tileArray[10] = new Jail();
		tileArray[11] = new Property("Tannery", 140, 10, 35, new Color(163,61,125,255));
		tileArray[12] = new Tavern(150);
		tileArray[13] = new Property("Mill", 140, 10, 40, new Color(163,61,125,255));
		tileArray[14] = new Property("Smith", 160, 12, 45, new Color(163,61,125,255));
		tileArray[15] = new Work();
		tileArray[16] = new Property("Bath House", 180, 14, 50, new Color(191,120,59,255));
		tileArray[17] = new ChanceCard();
		tileArray[18] = new Property("Bakery", 180, 14, 55, new Color(191,120,59,255));
		tileArray[19] = new Property("Butcher Shop", 200, 16, 60, new Color(191,120,59,255));
		tileArray[20] = new SundayChurch();
		tileArray[21] = new Property("Warehouse",220 ,18 , 65, new Color(169, 60, 48, 255));
		tileArray[22] = new ChanceCard();
		tileArray[23] = new Property("Alchemy Store", 220,18 ,70 , new Color(169, 60, 48, 255));
		tileArray[24] = new Property("Stable", 240, 20, 75, new Color(169, 60, 48, 255));
		tileArray[25] = new Work();
		tileArray[26] = new Property("Cobbler", 260, 22, 80,  new Color(254,231,11, 255));
		tileArray[27] = new Property("General Store", 260, 22 , 85,  new Color(254,231,11, 255));
		tileArray[28] = new Tavern(150);
		tileArray[29] = new Property("Silver Smith", 280, 24, 90,  new Color(254,231,11, 255));
		tileArray[30] = new GoToJail();
		tileArray[31] = new Property("Armorer", 300, 26, 95, new Color(95,178,77, 255));
		tileArray[32] = new Property("Tailor", 300, 26, 100, new Color(95,178,77, 255));
		tileArray[33] = new ChanceCard();
		tileArray[34] = new Property("Weapon Smith", 320, 28, 105, new Color(95,178,77, 255));
		tileArray[35] = new Work();
		tileArray[36] = new ChanceCard();
		tileArray[37] = new Property("Church", 350, 35, 150, new Color(4,74,159, 255));
		tileArray[38] = new Tax(); 
		tileArray[39] = new Property("The Castle", 400, 50, 200, new Color(4,74,159, 255));		

	}
	
	
	public Tile getTileAtIndex(int index) {
		return tileArray[index];
	}
	
	
}
