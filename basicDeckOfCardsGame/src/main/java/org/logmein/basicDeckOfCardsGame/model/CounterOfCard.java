/*
 * this class is used for return a counter of card in a deck
 */
package org.logmein.basicDeckOfCardsGame.model;

// TODO: Auto-generated Javadoc
/**
 * The Class CounterOfCard.
 */
public class CounterOfCard {

	
	/** The type. of card (facial value, or color) */
	private String type;
	
	/** The counter. */
	private int counter;
	
	
	
	
	/**
	 * Instantiates a new counter of card.
	 *
	 * @param type the type
	 * @param counter the counter
	 */
	public CounterOfCard(String type,int counter) {
		this.type=type;
		this.counter = counter;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets the type.
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Gets the counter.
	 *
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}
	
	/**
	 * Sets the counter.
	 *
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	
	
}
