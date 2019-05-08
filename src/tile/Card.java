package tile;

import java.util.Random;

/**
 * @author SebastianViro, AevanDino, MuhammadAbdulkhuder
 *
 */
public class Card {
	private String fortune = "";
	private Boolean isBlessing = false;

	private String description = "";
	private int amount; // Can be both positive and negative
	
	// finns rum till att skapa klass specifika kort   
	
	public Card(Boolean isBlessing, String description, int amount) {
		
		if(isBlessing) {
			setFortune("BLESSING");
		}else {
			setFortune("CURSE");
		}
		setDescription(description);
		setAmount(amount);
	}

	/**
	 * @return the fortune
	 */
	public String getFortune() {
		return fortune;
	}

	/**
	 * @param fortune the fortune to set
	 */
	public void setFortune(String fortune) {
		this.fortune = fortune;
	}

	/**
	 * @return the isBlessing
	 */
	public Boolean getIsBlessing() {
		return isBlessing;
	}

	/**
	 * @param isBlessing the isBlessing to set
	 */
	public void setIsBlessing(Boolean isBlessing) {
		this.isBlessing = isBlessing;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
