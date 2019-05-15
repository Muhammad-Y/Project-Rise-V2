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
		colorMap.put("MAGENTA", Color.MAGENTA);
		colorMap.put("RED", Color.RED); 
		colorMap.put("ORANGE", Color.ORANGE);
		colorMap.put("YELLOW", Color.YELLOW); 
		colorMap.put("GREEN", Color.GREEN);
		colorMap.put("CYAN", Color.CYAN);
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
