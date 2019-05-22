package events;

import java.util.Random;

import javax.swing.JOptionPane;

import board.Board;
import dice.Dice;
import messageGui.WinGui;
import player.Player;
import player.PlayerList;
import player.PlayerRanks;
import tiles.FortuneTeller;
import tiles.Go;
import tiles.GoToJail;
import tiles.Jail;
import tiles.Property;
import tiles.SundayChurch;
import tiles.Tavern;
import tiles.Tax;
import tiles.Tile;
import tiles.Work;
import westSidePanel.WestSidePanel;

/**
 * Klass som hanterar alla händelser då en spelare landar på en ruta
 * 
 * @author Seth Oberg, Rohan Samandari
 *
 */

public class ManageEvents {
	private PlayerList playerList;
	private Board board;
	private Dice dice;
	private WinGui winGui;
	private Random rand = new Random();
	private int roll;
	private int taxCounter = 0;
	private WestSidePanel westPanel;

	public ManageEvents(Board board, PlayerList playerList, WestSidePanel pnlWest, Dice dice) {
		this.dice = dice;
		this.westPanel = pnlWest;
		this.board = board;
		this.playerList = playerList;
	}

	public void newEvent(Tile tile, Player player) {
		player.checkPlayerRank();

		if (player.getPlayerRank() == PlayerRanks.RULER) {
			this.winGui = new WinGui();

		}

		if (tile instanceof Property) {
			propertyEvent(tile, player);
		}

		if (tile instanceof Tax) {
			taxEvent(tile, player);
		}

		if (tile instanceof Jail) {
			jailEvent(tile, player);
		}

		if (tile instanceof GoToJail) {
			goToJailEvent(tile, player);
		}

		if (tile instanceof Tavern) {
			tavernEvent(tile, player);
		}

		if (tile instanceof Go) {
			// Detta sköts just nu i dice klassen?
		}

		if (tile instanceof SundayChurch) {
			churchEvent(player);
		}

		if (tile instanceof Work) {
			workEvent(tile, player);
		}

		if (tile instanceof FortuneTeller) {
			fortuneTellerEvent(tile, player);
		}

	}

	private void fortuneTellerEvent(Tile tile, Player player) {
		FortuneTeller tempCard = (FortuneTeller) tile;
		tempCard.setAmount(rand.nextInt(600) - 300);
		if (tempCard.getAmount() < 0) {
			int pay = (tempCard.getAmount() * -1);
			tempCard.setIsBlessing(false);
			tempCard.setFortune("CURSE");
			control(player, pay);
			if (player.isAlive() == true) {
//				nya ändringar
				westPanel.append(player.getName() + " paid " + pay + "\n");
//				slut på ändringar
				player.decreaseBalace(pay);
				player.decreaseNetWorth(pay);
				JOptionPane.showMessageDialog(null, "You pay" + pay);
			}

		} else {
			tempCard.setIsBlessing(true);
			tempCard.setFortune("BLESSING");
			player.increaseBalance(tempCard.getAmount());
			player.increaseNetWorth(tempCard.getAmount());
//			nya ändringar
			westPanel.append(player.getName() + " received " + tempCard.getAmount() + "\n");
//			slut på ändringar
			JOptionPane.showMessageDialog(null, "You get " + tempCard.getAmount());
		}
	}

	/**
	 * This method is supposed to be called from any class that requires the current
	 * player to pay any amount, if the user does not have the amount required they
	 * should be removed from the game
	 */
	public void control(Player player, int amount) {

		if (player.getBalance() < amount) {
			player.setIsAlive(false);
			playerList.eliminatePlayer(player);
			board.removePlayer(player);
			JOptionPane.showMessageDialog(null, "The plague has taken you\nYou have lost\nTry again in another life");
		} else {
//			System.out.println("Spelaren har råd att betala " + amount);
		}

	}

	public void propertyEvent(Tile tile, Player player) {
		Property tempProperty = (Property) tile;
		int tempInt = 0;

		if (tempProperty.getPurchaseable() == true) {
//			nya ändringar
			if (player.getBalance() < tempProperty.getPrice()) {
				JOptionPane.showMessageDialog(null, "Not enough funds to purchase this ptoperty");
			} else {
				propertyDialog(tempProperty, player);
			}
//			slut på ändringar
		} else if (tempProperty.getPurchaseable() == false) {

			if (tempProperty.getNumberOfHouses() == 0) {
				tempInt = tempProperty.getDefaultRent();

				control(player, tempInt);
				if (player.isAlive() == true) {
					// ny ändringar
					westPanel.append(player.getName() + " paid " + tempProperty.getTotalRent() + " GC to "
							+ tempProperty.getOwner().getName() + "\n");
					// slut på ändringar
					player.decreaseBalace(tempInt);
					tempProperty.getOwner().increaseBalance(tempInt);
				}

			} else {
				tempInt = tempProperty.getTotalRent();
				control(player, tempInt);
				if (player.isAlive() == true) {
					// ny ändringar
					westPanel.append(player.getName() + " paid " + tempProperty.getTotalRent() + " GC to "
							+ tempProperty.getOwner().getName() + "\n");
					// slut på ändringar
					player.decreaseBalace(tempInt);
					tempProperty.getOwner().increaseBalance(tempInt);
				}

			}

		}

	}

	public void workEvent(Tile tile, Player player) {
		int pay = 0;
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
//		nya ändringar
		westPanel.append(player.getName() + " got " + totalEarnings + "\n");
//		slut på ändringar
		JOptionPane.showMessageDialog(null,
				"the roll is" + roll + "\n" + "you got: " + totalEarnings + "G for your hard work");
		player.increaseBalance(totalEarnings);
		player.increaseNetWorth(totalEarnings);
		// Rad nedan �r test
	}

	public void taxEvent(Tile tile, Player player) {
		Tax tempTaxObject = (Tax) tile;
		int chargePlayer = tempTaxObject.getTax();

		control(player, chargePlayer);

		if (player.isAlive() == true) {
			// ny ändringar
			westPanel.append(player.getName() + " paid 200 in tax\n");
			// slut på ändringar
			player.decreaseBalace(chargePlayer);
			player.decreaseNetWorth(chargePlayer);
			taxCounter++;
		}
	}
	/**
	 * Gets the total tax paid by players
	 * @return total tax
	 */
	public int getChurchTax() {
		int totalTax = taxCounter * 200;
		return totalTax;
	}

	public void tavernEvent(Tile tile, Player player) {
		Tavern tempTavernObj = (Tavern) tile;

		if (tempTavernObj.getPurchaseable()) {
			if (player.getBalance() < tempTavernObj.getPrice()) {
				JOptionPane.showMessageDialog(null, "Not enough funds to purchase this tavern");
			} else {
				tavernDialog(tempTavernObj, player);
			}
		} else {
			int randomValue = 0;

			if (tempTavernObj.getOwner().getAmountOfTaverns() == 1) {
				randomValue = (getRoll() * 10);
			} else if (tempTavernObj.getOwner().getAmountOfTaverns() == 2) {
				randomValue = (getRoll() * 20);
			}

			control(player, randomValue);
			if (player.isAlive() == true) {
				westPanel.append(
						player.getName() + " paid " + randomValue + " to " + tempTavernObj.getOwner().getName() + "\n");
				tempTavernObj.getOwner().increaseBalance(randomValue);
				tempTavernObj.getOwner().increaseNetWorth(randomValue);
				player.decreaseBalace(randomValue);
			}

		}

	}

	/**
	 * Spelaren ska vara fast på jail rutan i 3 rundor, eller köpa sig ut för 50G?
	 * 
	 * @param tile
	 * @param player
	 */
	public void jailEvent(Tile tile, Player player) {
		System.out.println("");

		if (player.isPlayerInJail() == true && (player.getJailCounter()) < 2) {
			westPanel.append(player.getName() + " is in jail for " + (2 - player.getJailCounter()) + " more turns\n");
			player.increaseJailCounter();
			System.out.println("test");
			if (player.getBalance() > (player.getJailCounter()*50)) {
				jailDialog(player);
				System.out.println("If sats körs");
			}
		} else {
			player.setPlayerIsInJail(false);
			player.setJailCounter(0);
			dice.activateRollDice();
		}

	}

	public void goToJailEvent(Tile tile, Player player) {
		player.setPlayerIsInJail(true);
		board.removePlayer(player);
		player.setPositionInSpecificIndex(10);
		board.setPlayer(player);
		westPanel.append(player.getName() + " is in jail for " + (2 - player.getJailCounter()) + " more turns\n");
	}

	public void churchEvent(Player player) {

		player.increaseBalance(200 * taxCounter);
		player.increaseNetWorth(200 * taxCounter);
		taxCounter = 0;
		westPanel.append(player.getName() + " got " + taxCounter * 200 + " gc from church\n");

	}

	public void propertyDialog(Property property, Player player) {
		int yesOrNo = JOptionPane.showConfirmDialog(null, property.getName() + "\n"
				+ "Do you want to purchase this property for " + property.getPrice() + " Gold coins",
				"Decide your fate!", JOptionPane.YES_NO_OPTION);

		if (yesOrNo == 0 && (property.getPrice() <= player.getBalance())) {

			// Visa en MessageDialog med "You cannot afford this property" om spelaren
			// klickar på ja men inte har råd
			property.setOwner(player);
			player.addNewProperty(property);
			property.setPurchaseable(false);
			player.decreaseBalace(property.getPrice());
			// Lägg till ny rad
			westPanel.append(player.getName() + " purchased " + property.getName() + "\n");
		}

		else {
			westPanel.append(player.getName() + " did not purchase " + property.getName() + "\n");
			// Behövs inte fixas
			// Skriv ut typ "player passed"
		}
	}

	public void tavernDialog(Tavern tavern, Player player) {
		int yesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to purchase this property", "JOption",
				JOptionPane.YES_NO_OPTION);

		if (yesOrNo == 0 && (tavern.getPrice() <= player.getBalance())) {

			// Visa en MessageDialog med "You cannot afford this property" om spelaren
			// klickar på ja men inte har råd
			tavern.setOwner(player);
			player.addNewTavern(tavern);
			tavern.setPurchaseable(false);
			player.decreaseBalace(tavern.getPrice());
			westPanel.append(player.getName() + " purchased " + tavern.getName() + "\n");
		} else {
			westPanel.append(player.getName() + " did not purchase " + tavern.getName() + "\n");
			// Behövs inte fixas
			// Skriv ut typ "player passed"
		}

	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(Dice dice) {
		this.roll = dice.getRoll();
	}
	/**
	 * Message for the prisoner to choose if the player
	 *  wants to pay the bail and get free
	 * @param player
	 */
	public void jailDialog(Player player) {
		int yesOrNo = JOptionPane.showConfirmDialog(null, "Do you want to pay the bail\nWhich is " + (player.getJailCounter() * 50) + "GC?", "JOption",
				JOptionPane.YES_NO_OPTION);
		int totalBail = player.getJailCounter() * 50;
		if (yesOrNo == 0 && (totalBail <= player.getBalance())) {
			player.setJailCounter(0);
			player.setPlayerIsInJail(false);
			westPanel.append(player.getName() + " paid the bail and\ngot free from jail\n");
			dice.activateRollDice();
		} else {
			JOptionPane.showMessageDialog(null, "You can not afford the bail");
			westPanel.append(player.getName() + " did not pay tha bail\n and is still in jail\n");
		}
	}

}
