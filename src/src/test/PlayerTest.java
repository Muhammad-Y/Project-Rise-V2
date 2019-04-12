package test;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import DinoTesting.Tile;

/**
 * Player class deals with everything that has to do with a player.
 * @author AevanDino
 */
public class PlayerTest {

	
	private String playerName;
	private Color playerColor;
	private Boolean playerIsAlive; // If we want to kill off players.

	private PlayerRankTest playerRank;

	private int playerBalance;
	private int playerNetWorth;
	private int playerPosition;

	private ArrayList<Tile> propertiesOwned;
	private ArrayList<String> transactionsMade; // Should we want to keep track of in/out comes


	public PlayerTest(String inPlayerName, Color inPlayerColor) {

		setPlayerName(inPlayerName);
		setPlayerColor(inPlayerColor);
		setPlayerIsAlive(true);

		setPlayerBalance(1500);
		setPlayerPosition(0);
		setPlayerRank(playerRank.PEASANT);

		this.propertiesOwned = new ArrayList<>(); // only red marked cuz Tile interface isnt in this package/imported
		this.transactionsMade = new ArrayList<String>();

	}

	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return this.playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the playerColor
	 */
	public Color getPlayerColor() {
		return this.playerColor;
	}

	/**
	 * @param playerColor the playerColor to set
	 */
	public void setPlayerColor(Color playerColor) {
		this.playerColor = playerColor;
	}

	/**
	 * @return the playerBalance
	 */
	public int getPlayerBalance() {
		return this.playerBalance;
	}

	/**
	 * @param playerBalance the playerBalance to set
	 */
	public void setPlayerBalance(int playerBalance) {
		this.playerBalance = playerBalance;
	}

	/**
	 * @return the playerIsAlive
	 */
	public Boolean getPlayerIsAlive() {
		return playerIsAlive;
	}

	/**
	 * @param playerIsAlive the playerIsAlive to set
	 */
	public void setPlayerIsAlive(Boolean playerIsAlive) {
		this.playerIsAlive = playerIsAlive;
	}

	/**
	 * @return the positionOfPlayer
	 */
	public int getPositionOfPlayer() {
		return this.playerPosition;
	}

	/**
	 * @param positionOfPlayer the positionOfPlayer to set
	 */
	public void setPlayerPosition(int positionOfPlayer) {
		if( positionOfPlayer>0) {
			this.playerPosition = positionOfPlayer;
		}
	}

	/**
	 * @return playerRank the rank of the player
	 */
	public PlayerRankTest getPlayerRank() {
		return this.playerRank;
	}

	/**
	 * @param playerRank set the rank of this player
	 */
	public void setPlayerRank(PlayerRankTest playerRank) {
		this.playerRank = playerRank;
	}

	/**
	 * @return the netWorth
	 */
	public int getPlayerNetWorth() {
		return this.playerNetWorth;
	}

	/**
	 * @param netWorth the netWorth to set
	 */
	public void setPlayerNetWorth(int netWorth) {
		this.playerNetWorth = netWorth;
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