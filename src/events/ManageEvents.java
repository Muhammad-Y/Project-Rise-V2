package events;

import player.Player;
import player.PlayerList;
import tiles.Property;
import tiles.Tile;

/**
 * Klass som hanterar alla händelser då en spelare landar på en ruta
 * @author Seth Oberg, Rohan Samandari
 *
 */

public class ManageEvents {
	private PlayerList playerList;
	
	public ManageEvents(PlayerList playerList) {
		this.playerList = playerList;
	}
	
	
	public void newEvent(Tile tile, Player player) {
		
		if(tile instanceof Property) {
			propertyEvent(tile, player);
		}
		
	}
	
	
	//Om spelare inte har råd att betala, eliminera spelare
	public void control() {
		
	}
	
	
	public void propertyEvent(Tile tile, Player player) {
		Property tempProperty = (Property) tile; 
		
		//Boolean isOwned should be added to property
//		if(tempProperty.isOwned == true) {
			player.setBalance(player.getBalance() - tempProperty.getDefaultRent());
//		}
		
		
		
		control();
	}
	
	
	
}
