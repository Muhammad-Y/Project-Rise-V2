package projectrise;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import tiles.Tile;

/**
 * Player class deals with everything that has to do with a player.
 * @author AevanDino
 */
public class Player {

	
	private String name;
	private Color color;
	private Boolean isAlive; // If we want to kill off players.

	private PlayerRanks playerRank;

	private int balance;
	private int netWorth;
	private int position;

	private ArrayList<Tile> propertiesOwned;
	private ArrayList<String> transactionsMade; // Should we want to keep track of in/out comes


	public Player(String inPlayerName, Color inPlayerColor) {

		setName(inPlayerName);
		setColor(inPlayerColor);
		setIsAlive(true);

		setBalance(1500);
		setPosition(0);
		setPlayerRank(playerRank.PEASANT);

		this.propertiesOwned = new ArrayList<>(); // only red marked cuz Tile interface isnt in this package/imported
		this.transactionsMade = new ArrayList<String>();

	}

	/**
	 * @return the playerName
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setName(String playerName) {
		this.name = playerName;
	}

	/**
	 * @return the playerColor
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * @param playerColor the playerColor to set
	 */
	public void setColor(Color playerColor) {
		this.color = playerColor;
	}

	/**
	 * @return the playerBalance
	 */
	public int getBalance() {
		return this.balance;
	}

	/**
	 * @param playerBalance the playerBalance to set
	 */
	public void setBalance(int playerBalance) {
		this.balance = playerBalance;
	}
	
	public void increaseBalance(int income) {
		this.balance += income;
	}

	/**
	 * @return the playerIsAlive
	 */
	public Boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param playerIsAlive the playerIsAlive to set
	 */
	public void setIsAlive(Boolean playerIsAlive) {
		this.isAlive = playerIsAlive;
	}

	/**
	 * @return the positionOfPlayer
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * @param positionOfPlayer the positionOfPlayer to set
	 */
	public void setPosition(int positionOfPlayer) {
		if( positionOfPlayer>0) {
			this.position = positionOfPlayer;
		}
	}

	/**
	 * @return playerRank the rank of the player
	 */
	public PlayerRanks getPlayerRank() {
		return this.playerRank;
	}

	/**
	 * @param playerRank set the rank of this player
	 */
	public void setPlayerRank(PlayerRanks playerRank) {
		this.playerRank = playerRank;
	}

	/**
	 * @return the netWorth
	 */
	public int getNetWorth() {
		return this.netWorth;
	}

	/**
	 * @param netWorth the netWorth to set
	 */
	public void setNetWorth(int netWorth) {
		this.netWorth = netWorth;
	}

	/**
	 * Adds newly purchased property to ownedProperties array
	 * @param newProperty, the newly bought property.
	 */
	public void addNewProperty(Tile newProperty) {
		this.propertiesOwned.add(newProperty);
	}

	/**
	 * Gets property att specified position
	 * @param pos
	 * @return
	 */
	public Tile getProperty(int pos) {
		if(propertiesOwned.size() >= pos && pos > 0) {
			return this.propertiesOwned.get(pos);
		}
		return null;
	}

	/**
	 * @return propertiesOwned, returns entire ArrayList of properties owned.
	 */
	public ArrayList<Tile> getProperties() {
		return this.propertiesOwned;
	}

}