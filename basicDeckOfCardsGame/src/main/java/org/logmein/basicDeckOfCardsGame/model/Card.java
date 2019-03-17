/*
 * class used for represent a card
 */
package org.logmein.basicDeckOfCardsGame.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Card.
 */
public class Card {

	/** The card name. */
	private String cardName;
	
	/** The card color. */
	private String cardColor;
	
	/** The value of card. */
	private int Cardvalue;
	
	
	
	/**
	 * Instantiates a new card.
	 */
	public Card()
	{
		
		
	}
	
	/**
	 * Instantiates a new card.
	 *
	 * @param cardName the card name
	 * @param cardColor the card color
	 * @param cardValue the card value
	 */
	public Card(String cardName,String cardColor,int cardValue)
	{
		this.cardName = cardName;
		this.cardColor = cardColor;
		this.Cardvalue = cardValue;
	}
	
	
	
	
    /* 
     * overide the to string function
     */
    @Override
    public String toString(){
        String cardName = this.cardName +" of " + this.cardColor;
        return cardName;
    }
    
      
	/**
	 * Gets the card name.
	 *
	 * @return the card name
	 */
	public String getCardName() {
		return cardName;
	}
	
	/**
	 * Sets the card name.
	 *
	 * @param cardName the new card name
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	/**
	 * Gets the card color.
	 *
	 * @return the card color
	 */
	public String getCardColor() {
		return cardColor;
	}
	
	/**
	 * Sets the card color.
	 *
	 * @param cardColor the new card color
	 */
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}
	
	/**
	 * Gets the cardvalue.
	 *
	 * @return the cardvalue
	 */
	public Integer getCardvalue() {
		return Cardvalue;
	}
	
	/**
	 * Sets the cardvalue.
	 *
	 * @param cardvalue the new cardvalue
	 */
	public void setCardvalue(Integer cardvalue) {
		Cardvalue = cardvalue;
	}

	
}
