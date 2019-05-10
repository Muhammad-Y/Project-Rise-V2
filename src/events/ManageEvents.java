package events;

import player.Player;
import player.PlayerList;
import tiles.Property;
import tiles.Tax;
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
		
		if(tile instanceof Tax) {
			taxEvent(tile, player);
		}
		
	}
	
	
	/**
	 * This method is supposed to be called from any class that requires the current player to pay any amount,
	 * if the user does not have the amount required they should be removed from the game
	 */
	public void control(Player player, int amount) {
		
		if(player.getBalance() < amount) {
//			playerList.eliminatePlayer(int index); 
			//In playerList.eliminatePlayer call isAlive == false;
		}
		
	}
	
	
	public void propertyEvent(Tile tile, Player player) {
		Property tempProperty = (Property) tile; 
		int tempInt = 0; 
		
		
		//Boolean isOwned should be added to property
//		if(tempProperty.isOwned == true) {
		    tempInt = player.getBalance() - tempProperty.getTotalRent();
			player.setBalance(player.getBalance() - tempProperty.getTotalRent());
//			propertyOwner.addMoney(tempProperty.getTotalRent());
//		}
		
		
//		if(tempProperty.isOwned == false) {
			/*
			 * At this point the current player will get a pop-up menu asking if the user wants to purchase a property
			 * (if they have sufficent funds). The menu will say something like:
			 * This property is avaliable, do you want to purchase it? with the option of either yes or no
			 * In the future an auction function could be added in this step as well 
			 * 
			 * A method call to this point could loop something like 
			 * popUpMenu.purchaseProperty(tile, player);
			 */
			
			
//		}
			
//		control();
	}
	
	public void taxEvent(Tile tile, Player player) {
		Tax tempTaxObject = (Tax) tile;
		int chargePlayer = tempTaxObject.getTax();
		
		control(player, chargePlayer);
		
		if(player.isAlive()) {
			
		}
		
	}
	
	
	
	
}
