package events;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import board.Board;
import dice.Dice;
import player.Player;
import player.PlayerList;
import player.PlayerRanks;
import tiles.Go;
import tiles.GoToJail;
import tiles.Jail;
import tiles.Property;
import tiles.SundayChurch;
import tiles.Tavern;
import tiles.Tax;
import tiles.Tile;
import tiles.Work;

/**
 * Klass som hanterar alla händelser då en spelare landar på en ruta
 * @author Seth Oberg, Rohan Samandari
 *
 */

public class ManageEvents {
	private PlayerList playerList;
	private Board board; 
	private Dice dice;
	private int roll;

	
	public ManageEvents(Board board, PlayerList playerList) {
		this.board = board;
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
		
		if (tile instanceof Work) {
			workEvent(tile, player);
		}

		
		
		
	}
	
	
		
		

	
	
	/**
	 * This method is supposed to be called from any class that requires the current player to pay any amount,
	 * if the user does not have the amount required they should be removed from the game
	 */
	public void control(Player player, int amount) {
		
		if(player.getBalance() < amount) {
			player.setIsAlive(false); 
			board.removePlayer(player);
		}
		
	}
	
	
	public void propertyEvent(Tile tile, Player player) {
		Property tempProperty = (Property) tile; 
		int tempInt = 0; 
		
		if(tempProperty.getPurchaseable() == true) {
			propertyDialog(tempProperty, player);
		} 
		else if (tempProperty.getPurchaseable() == false){
			
			if(tempProperty.getNumberOfHouses() == 0) {
				tempInt = tempProperty.getDefaultRent();
				player.decreaseBalace(tempInt);
				tempProperty.getOwner().increaseBalance(tempInt);
			}
			else {
				tempInt = tempProperty.getTotalRent();
				player.decreaseBalace(tempInt);
				tempProperty.getOwner().increaseBalance(tempInt);
			}
			
		}
		 
	}
	
	public void workEvent(Tile tile, Player player) {
		int pay=0;
		int totalEarnings;
		if (player.getPlayerRank() == PlayerRanks.PEASANT) {

			pay = 20;

		}
		if (player.getPlayerRank() == PlayerRanks.KNIGHT) {

			pay = 25;

		}
		if (player.getPlayerRank() == PlayerRanks.LORD) {

			pay = 30;

		}
		totalEarnings = (getRoll() * pay);
		JOptionPane.showMessageDialog(null,"the roll is"+ roll+ "\n" +"you got: " + totalEarnings +"G for your hard work");
		player.increaseBalance(totalEarnings);
		player.increaseNetWorth(totalEarnings);

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
		
		 
		if(tempTavernObj.getPurchaseable() == true) {
			tavernDialog(tempTavernObj, player); 
		} 
		else {
			
		}
		
	}
	
	

	public void propertyDialog(Property property, Player player) {
		int yesOrNo = JOptionPane.showConfirmDialog(null,
				"Do you want to purchase this property", "Choose!", JOptionPane.YES_NO_OPTION);

		if(yesOrNo == 0 && (property.getPrice() <= player.getBalance()) ) {
			
			//Visa en MessageDialog med "You cannot afford this property" om spelaren klickar på ja men inte har råd
			property.setOwner(player);
			player.addNewProperty(property);
			property.setPurchaseable(false);
			player.decreaseBalace(property.getPrice());
			// Lägg till ny rad

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
			
			//Visa en MessageDialog med "You cannot afford this property" om spelaren klickar på ja men inte har råd
			tavern.setOwner(player);
			player.addNewTavern(tavern);
			tavern.setPurchaseable(false);
			player.decreaseBalace(tavern.getPrice());
			
		}
		else {
			//Behövs inte fixas
			//Skriv ut typ "player passed"
		}
		
	}
	
	public int getRoll() {
		return roll;
	}

	public void setRoll(Dice dice) {
		this.roll = dice.getRoll();
	}

}
