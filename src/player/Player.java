package player;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import tiles.Tile;

/**
 * Player class deals with everything that has to do with a player.
 * 
 * @author AevanDino , seth �berg , muhammad hasan, sebastian viro
 */
public class Player {

	private String name;
	private Boolean isAlive; // If we want to kill off players.

	private ImageIcon playerIcon;
	private int counter;
	private int playerIndex;

	private PlayerRanks playerRank;

	private int balance;
	private int netWorth;
	private int position;

	private ArrayList<Tile> propertiesOwned;
	private ArrayList<String> transactionsMade; // Should we want to keep track of in/out comes

	public Player(String inPlayerName, ImageIcon playerIcon, int playerIndex) {

		setName(inPlayerName);
		this.playerIcon = playerIcon;
		setIsAlive(true);
		this.playerIndex = playerIndex;

		setBalance(1500);
		setNetWorth(1500);
		setPosition(0);
		setPlayerRank(playerRank.PEASANT);
		this.playerIndex = playerIndex;
		this.propertiesOwned = new ArrayList<>(); // only red marked cuz Tile interface isnt in this package/imported
		this.transactionsMade = new ArrayList<String>();

		counter = 0;
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

	public void setPlayerIndex(int index) {
		this.playerIndex = index;
	}

	public int getPlayerIndex() {
		return playerIndex;
	}

	public int getIndex() {
		return counter;
	}

	public void setCounter(int amountOfStepsToMove) {

		for (int i = 0; i < amountOfStepsToMove; i++) {

			if (counter < 39) {
				counter++;
			} else {
				counter = 0;
			}

		}
	}

	/**
	 * @return the playerBalance
	 */
	public int getBalance() {
		return this.balance;
	}

	public ImageIcon getImage() {
		return playerIcon;
	}

	/**
	 * @param playerBalance the playerBalance to set
	 */
	public void setBalance(int playerBalance) {
		this.balance = playerBalance;
	}
	
	public void decreaseBalace(int decrease) {
		this.balance -= decrease;
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

	public String isAliveString() {

		if (isAlive == true) {
			return "This player is alive and well";
		} else
			return "The plauge has taken another soul";

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
		if (positionOfPlayer > 0) {
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

	public void decreaseNetWorth(int decrease) {
		this.netWorth -= decrease;
	}

	public void increaseNetWorth(int income) {
		this.netWorth += income;
	}

	
	/**
	 * Adds newly purchased property to ownedProperties array
	 * 
	 * @param newProperty, the newly bought property.
	 */
	public void addNewProperty(Tile newProperty) {
		this.propertiesOwned.add(newProperty);
	}

	/**
	 * Gets property att specified position
	 * 
	 * @param pos
	 * @return
	 */
	public Tile getProperty(int pos) {
		if (propertiesOwned.size() >= pos && pos > 0) {
			return this.propertiesOwned.get(pos);
		}
		return null;
	}
	
	public void checkPlayerRank() {
		
		if (getNetWorth() >= 3000) {
			setPlayerRank(playerRank.KNIGHT);
			
		}
		
		if (getNetWorth() >= 6000) {
			setPlayerRank(playerRank.LORD);
			
		}

	}

	/**
	 * @return propertiesOwned, returns entire ArrayList of properties owned.
	 */
	public ArrayList<Tile> getProperties() {
		return this.propertiesOwned;
	}

}