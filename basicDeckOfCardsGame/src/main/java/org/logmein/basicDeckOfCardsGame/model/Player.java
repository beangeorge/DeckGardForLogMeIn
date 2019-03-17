/**
 * 
 */
package org.logmein.basicDeckOfCardsGame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 *
 * @author robi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

	/** The nick name. */
	private String nickName;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The cards. */
	//private int handValue;
	@JsonIgnore
	private Deck cards;
	
	
	/**
	 * Instantiates a new player.
	 */
	public Player() {
		this.cards = new Deck();
	}
	
	/**
	 * Instantiates a new player.
	 *
	 * @param nickName the nick name
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public Player(String nickName,String firstName,String lastName) {
		this.nickName = nickName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cards = new Deck();
	}
	
	
	

	
	
	
	/**
	 * Gets the hand value.
	 *
	 * @return the hand value
	 */
	public int getHandValue() {
		
		
		return this.cards.calculateValueFromDeck();
	}
	
	
	
	/**
	 * Adds the card.
	 *
	 * @param card the card
	 */
	public void addCard(Card card)
	{
		this.cards.addCard(card);
		
	}
	
	/**
	 * Gets the nick name.
	 *
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Sets the nick name.
	 *
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the cards.
	 *
	 * @return the cards
	 */
	public Deck getCards() {
		return cards;
	}

	


}
