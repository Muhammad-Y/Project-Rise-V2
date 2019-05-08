package board;

import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ColorIconMap {
	private HashMap<String, ImageIcon> colorMap = new HashMap<String, ImageIcon>();
	
	
	public ColorIconMap() {
		addColorsToMap();
	}
	
	
	private void addColorsToMap() { 
		colorMap.put("MAGENTA", new ImageIcon("images/playerMagenta.jpg"));
		colorMap.put("RED", new ImageIcon("images/playerRed.jpg")); 
		colorMap.put("ORANGE", new ImageIcon("images/playerOrange.jpg"));
		colorMap.put("YELLOW", new ImageIcon("images/playerYellow.jpg")); 
		colorMap.put("GREEN", new ImageIcon("images/playerGreen.jpg"));
		colorMap.put("CYAN", new ImageIcon("images/playerCyan.jpg"));
		colorMap.put("PURPLE", new ImageIcon("images/playerPurple.jpg"));
	}
	 
	
	public ImageIcon getColorFromMap(String chosenColor) {
		return colorMap.get(chosenColor);
	}
	
	
//	public static void main(String [] args) {
//		ColorIconMap hej = new ColorIconMap();
//		
//		JOptionPane.showMessageDialog(null, hej.getColorFromMap("CYAN"));
//	}
	
	
}
