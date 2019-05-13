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
		
		
		//Boolean isOwned should be added to property
////		if(tempProperty.isOwned == true) {
//		    tempInt = player.getBalance() - tempProperty.getTotalRent();
//			player.setBalance(player.getBalance() - tempProperty.getTotalRent());
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
			//dialogruta
			//Har spelaren råd att köpa gatan?
			//funkar detta???
			JOptionPane.showConfirmDialog(null,
					"choose one", "choose one", JOptionPane.YES_NO_OPTION);
			
			tempTavernObj.setOwner(player);
		} 
		else {
			
		}
		
	}
	
	
	public int testDialog() {
		Object[] options = {"Buy", "Cancel"};
		 JOptionPane pane = new JOptionPane("hej");
		 pane.setOptions(options);
	     pane.set.Xxxx(...); // Configure
	     JDialog dialog = pane.createDialog(parentComponent, title);
	     dialog.show();
	     Object selectedValue = pane.getValue();
	     if(selectedValue == null)
	       return CLOSED_OPTION;
	     //If there is not an array of option buttons:
	     if(options == null) {
	       if(selectedValue instanceof Integer)
	          return ((Integer)selectedValue).intValue();
	       return CLOSED_OPTION;
	     }
	     //If there is an array of option buttons:
	     for(int counter = 0, maxCounter = options.length;
	        counter < maxCounter; counter++) {
	        if(options[counter].equals(selectedValue))
	        return counter;
	     }
	     return CLOSED_OPTION;
	}
	
	
	public void testDialog2() {
		JOptionPane.showConfirmDialog(null,
				"Buy", "Pass", JOptionPane.YES_NO_OPTION);
	}
	
	
}
