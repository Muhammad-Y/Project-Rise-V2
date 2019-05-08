package tileCollection;

import javafx.scene.paint.Color;
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
		tileArray[1] = new Property("Camp", 60, 2, 15, Color.PURPLE);
		tileArray[2] = new ChanceCard();
		tileArray[3] = new Property("Stone Mason Camp", 60, 4, 15, Lila);
		tileArray[4] = new Tax();
		tileArray[5] = new Work();
		tileArray[6] = new Property("Vegetables Stand", 100, 6, 20, LjBlå);
		tileArray[7] = new ChanceCard();
		tileArray[8] = new Property("Fish Stand", 100, 6, 25, LjBlå);
		tileArray[9] = new Property("Bread Stand", 120, 8, 30, LjBlå);
		tileArray[10] = new Jail();
		tileArray[11] = new Property("Tannery", 140, 10, 35, Pink);
		tileArray[12] = new Tavern(150);
		tileArray[13] = new Property("Mill", 140, 10, 40, Pink);
		tileArray[14] = new Property("Smith", 160, 12, 45, Pink);
		tileArray[15] = new Work();
		tileArray[16] = new Property("Bath House", 180, 14, 50, Orange);
		tileArray[17] = new ChanceCard();
		tileArray[18] = new Property("Bakery", 180, 14, 55, Orange);
		tileArray[19] = new Property("Butcher Shop", 200, 16, 60, Orange);
		tileArray[20] = new SundayChurch();
		tileArray[21] = new Property("Ware House",220 ,18 , 65, Red);
		tileArray[22] = new ChanceCard();
		tileArray[23] = new Property("Alchemy Store", 220,18 ,70 , Red);
		tileArray[24] = new Property("Stable", 240, 20, 75, Red);
		tileArray[25] = new Work();
		tileArray[26] = new Property("Cubbler", 260, 22, 80, Yellow);
		tileArray[27] = new Property("General Store", 260, 22 , 85, Yellow);
		tileArray[28] = new Tavern();
		tileArray[29] = new Property("Silver Smith", 280, 24, 90, Yellow);
		tileArray[30] = new GoToJail();
		tileArray[31] = new Property("Armer", 300, 26, 95, Green);
		tileArray[32] = new Property("Tailor", 300, 26, 100, Green);
		tileArray[33] = new ChanceCard();
		tileArray[34] = new Property("Weapon Smith", 320, 28, 105, Green);
		tileArray[35] = new Work();
		tileArray[36] = new ChanceCard();
		tileArray[37] = new Property("Church", 350, 35, 150, Blue);
		tileArray[38] = new Tax(); 
		tileArray[39] = new Property("Castle", 400, 50, 200, Blue);
		
		

	}
	
}
