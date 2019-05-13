package events;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import player.Player;
import player.PlayerList;
import tiles.Go;
import tiles.GoToJail;
import tiles.Jail;
import tiles.Property;
import tiles.SundayChurch;
import tiles.Tavern;
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
		
		if(tile instanceof Jail) {
			
		}
		
		if(tile instanceof GoToJail) {
			
		}
		
		if(tile instanceof Tavern) {
			tavernEvent(tile, player);
		}
		
		
		if(tile instanceof Go) {
			//Detta sköts just nu i dice klassen?
		}
		
		if(tile instanceof SundayChurch) {
			
		}
		
		
	}
	
	
	/**
	 * This method is supposed to be called from any class that requires the current player to pay any amount,
	 * if the user does not have the amount required they should be removed from the game
	 */
	public void control(Player player, int amount) {
		
		if(player.getBalance() < amount) {
//			playerList.eliminatePlayer(int index); 
//			playerList.eliminatePlayer call isAlive == false;
//			board.removePlayer(player);
		}
		
	}
	
	
	public void propertyEvent(Tile tile, Player player) {
		Property tempProperty = (Property) tile; 
		int tempInt = 0; 
		
		if(tempProperty.getPurchaseable() == false) {
			propertyDialog(tempProperty, player);
		} 
		else {
			
		}

	}
	
	public void taxEvent(Tile tile, Player player) {
		Tax tempTaxObject = (Tax) tile;
		int chargePlayer = tempTaxObject.getTax();
		
//		control(player, chargePlayer);
		
//		if(player.isAlive()) {
//			
//		}
		
		player.decreaseBalace(chargePlayer);
		player.decreaseNetWorth(chargePlayer);
		
	}
	
	
	public void tavernEvent(Tile tile, Player player) {
		Tavern tempTavernObj = (Tavern) tile;
		
		
		if(tempTavernObj.getPurchaseable() == false) {
			tavernDialog(tempTavernObj, player);
		} 
		else {
			
		}
		
	}
	
	

	public void propertyDialog(Property property, Player player) {
		int yesOrNo = JOptionPane.showConfirmDialog(null,
				"Do you want to purchase this property", "JOption", JOptionPane.YES_NO_OPTION);

		if(yesOrNo == 0 && (property.getPrice() <= player.getBalance()) ) {
			System.out.println("Owner of property: " + property.getOwner());
			property.setOwner(player);
			System.out.println("Owner of property: " + property.getOwner());
			player.decreaseBalace(property.getPrice());

		}
		else {
			//Behövs inte fixas
			//Skriv ut typ "player passed"
		}
	}
	
	public void tavernDialog(Tavern tavern, Player player) {
		int yesOrNo = JOptionPane.showConfirmDialog(null,
				"Do you want to purchase this property", "JOption", JOptionPane.YES_NO_OPTION);

		if(yesOrNo == 0 && (tavern.getPrice() <= player.getBalance()) ) {
			System.out.println("Owner of tavern: " + tavern.getOwner());
			tavern.setOwner(player);
			System.out.println("Owner of tavern: " + tavern.getOwner());
			player.decreaseBalace(tavern.getPrice());
			
		}
		else {
			//Behövs inte fixas
			//Skriv ut typ "player passed"
		}
	}
	
	
}
