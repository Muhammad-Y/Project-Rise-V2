package colorsAndIcons;

import java.awt.Color;
import java.util.HashMap;


/**
 * Returnerna färger med en string 
 * @author sethoberg
 *
 */
public class StringColorMap {
	private HashMap<String, Color> colorMap = new HashMap<String, Color>();
	
	
	public StringColorMap() {
		addColorsToMap();
	}
	
	
	private void addColorsToMap() { 
		colorMap.put("MAGENTA", new Color(255, 15, 226));
		colorMap.put("RED", new Color(255, 0, 10, 255)); 
		colorMap.put("ORANGE", new Color(254, 119, 14, 255));
		colorMap.put("YELLOW", new Color(206, 183, 51, 255)); 
		colorMap.put("GREEN", new Color(35, 254, 14, 255));
		colorMap.put("CYAN", new Color(93, 188, 210, 255));
		colorMap.put("PURPLE", Color.decode("#9542f4")); //purple
	}
	 
	
	/**
	 * Antingen magenta, red, orange, yellow, green, cyan, purple
	 * @param chosenColor färg att hämta
	 * @return
	 */
	public Color getColorFromMap(String chosenColor) {
		return colorMap.get(chosenColor);
	}
	
	
}
