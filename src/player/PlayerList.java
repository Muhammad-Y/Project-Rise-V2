package player;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import board.ColorIconMap;
import eastSidePanels.EastSidePanel;

public class PlayerList {
	private LinkedList<Player> activePlayers = new LinkedList<Player>();
	private ColorIconMap colorIcons = new ColorIconMap();
	
	//Tas bort senare?
	private int playerIndex = 0; 
	private String playerName = "";
	private ImageIcon playerIcon = new ImageIcon(); 
	private int currentPlayer = 0; //index fÃ¶r den aktiva spelaren?
	private int playerListLength = 0;
	
	public PlayerList(EastSidePanel p) {
		currentPlayer = 0; 
		
	}
	
	public PlayerList() {
		currentPlayer = 0; 
	}
	
	
//	Denna konstruktor kan kallas frÃ¥n startskÃ¤rmen om man matat in rÃ¤tt mÃ¤ngd spelare
//	public PlayerList(int amountOfPlayers) {
//		
//		for(int i = 0; i < amountOfPlayers; i++) {
//			//hÃ¤r behÃ¶ver nya vÃ¤rden hÃ¤mtas
//			//tex playerIndex = startScreen.getPlayerName();???
//			addNewPlayer(playerName, playerIcon); 
//			//Konstruktorn med playerIndex kan tas bort, istÃ¤llet kan man ta playerIndex = array.length/size
//		}
//		currentPlayer = 0; 
//	}
	
	 
	public void addNewPlayer(String name, ImageIcon icon) {
		activePlayers.add(new Player(name, icon, playerListLength)); 
		playerListLength++;
	} 
	
	public void addNewPlayer(String name, String icon) {
		playerIcon = colorIcons.getColorFromMap(icon);
		activePlayers.add(new Player(name, playerIcon, playerListLength)); 
		playerListLength++;
	}
	
	
	public PlayerList getList() {
		return this;
	}
	
	
	public Player getPlayerFromIndex(int index) {
		return activePlayers.get(index);
	}
	
	
	public Player getActivePlayer() {
		return activePlayers.get(currentPlayer); 
	}
	
	 
	public int getLength() {
		return activePlayers.size();
	}
	
	
	//Kan Ã¤ndras till endTurn() eller nÃ¥got annat fÃ¶r att gÃ¶ras tydligare?
	public void switchToNextPlayer() {
		
		if(currentPlayer < (activePlayers.size() - 1) ) {
			currentPlayer = currentPlayer + 1;
		}
		else {
			currentPlayer = 0; 
		}
		
	}
	

}
