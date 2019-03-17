/**
 * 
 */
package org.logmein.basicDeckOfCardsGame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.logmein.basicDeckOfCardsGame.exception.DeckEmptyException;

// TODO: Auto-generated Javadoc
/**
 * The Class Deck.
 *
 * @author robi
 */


public class Deck {

	

/** The deck card. */
private ArrayList<Card> deckCard;



/**
 * Instantiates a new deck.
 */
public Deck()
{
	
	this.deckCard = new ArrayList<Card>();
	
}


/**
 * Adds the complete game.
 */
public void addCompleteGame() {

	
	
	// for all the colors
	String[] colors=new String[]{cardEnumeration.HEART,cardEnumeration.SPADES,cardEnumeration.CLUBS,cardEnumeration.DIAMONDS};
	for(String color : colors) {
		//for all the card in a color
		for(int value=1;value<=13;value++){

			
			String cardName = String.valueOf(value); 
			
			//replace the value of card by this name
			switch(value) 
			{    	    	
			case 11 :
				cardName =cardEnumeration.JACK;
				break;
			case 12 :
				cardName =cardEnumeration.QUEEN;
				break;
			case 13 :
				cardName =cardEnumeration.KING;
				break;
			}
			deckCard.add(new Card(cardName,color,value));
		}}
	
	//shuffle the game
	//this.suffleGame();

		
	}
	

/**
 * Adds the card.
 *
 * @param card the card
 */
public  void addCard(Card card) {
	deckCard.add(card);
}


	/**
	 * Removes the card.
	 *
	 * @param card the card
	 */
	public  void removeCard(Card card) {
		deckCard.remove(card);
}

	/**
	 * Add a card to the player, and remove it from the shoe
	 *
	 * @return the card
	 */
	public  Card takeCard() {
		if (this.deckCard.size()==0) { throw new  DeckEmptyException(); }; 
		Card card = this.deckCard.get(0);		
		deckCard.remove(0);
		return card;
}

	
	/**
	 * Suffle game.
	 */
	public void suffleGame() {
		// creating a new list for add the card in a ramdon order
		ArrayList<Card> suffleGame = new ArrayList<Card>();
		int n;
		while (!this.deckCard.isEmpty()) {
			// make an random indice
			n = (int) (Math.random() * this.deckCard.size());
			// remove the card from the main deck and add in the suffle desk
			suffleGame.add(this.deckCard.remove(n));
		}
		// replace the main deck by the shuffle deck
		this.deckCard = suffleGame;
	}

	

	

/**
 * Calculate value from deck.
 *
 * @return the int
 */
public int calculateValueFromDeck() {
	int valueOfDeck=0;
	//cumulate the value of the card
	for (int i = 0; i < deckCard.size();i++)  valueOfDeck+=deckCard.get(i).getCardvalue();
	return valueOfDeck;
}

/**
 * Calcul number of card by color.
 *
 * @param color the color
 * @return the int
 */
public int calculNumberOfCardByColor(String color) {

	int nombreByColor = 0;
	//count the number of card for the color
	for (int i=0;i<this.deckCard.size();i++) {
		
		if (this.deckCard.get(i).getCardColor()==color) nombreByColor++;
	
	}
	return nombreByColor;
	
}

/**
 * Calcul number of card by value.
 *
 * @param value the value
 * @return the int
 */
public int calculNumberOfCardByValue(int value) {

	int nombreByValue = 0;
	//count the number of card for the value
	for (int i=0;i<this.deckCard.size();i++) {
		
		if (this.deckCard.get(i).getCardvalue().equals(value)) nombreByValue++;
	
	}
	return nombreByValue;
	
}



/**
 * Card list.
 *
 * @return the list
 */
public List<CounterOfCard> cardList() {

	ArrayList<CounterOfCard> cardList = new ArrayList<CounterOfCard>();
	//add the count for each color of card
	cardList.add(new CounterOfCard(cardEnumeration.HEART, calculNumberOfCardByColor(cardEnumeration.HEART)));
	cardList.add(new CounterOfCard(cardEnumeration.SPADES, calculNumberOfCardByColor(cardEnumeration.SPADES)));
	cardList.add(new CounterOfCard(cardEnumeration.CLUBS, calculNumberOfCardByColor(cardEnumeration.CLUBS)));
	cardList.add(new CounterOfCard(cardEnumeration.DIAMONDS, calculNumberOfCardByColor(cardEnumeration.DIAMONDS)));
	
	return cardList;
	
}

/**
 * Card list by colo and value.
 *
 * @return the list
 */
public List<CounterOfCard> cardListByColoAndValue() {

	ArrayList<CounterOfCard> cardList = new ArrayList<CounterOfCard>();

	//add the count for each color of card
	cardList.addAll(cardList());

	//add the count for each value of card
	cardList.add(new CounterOfCard(cardEnumeration.KING, calculNumberOfCardByValue(13)));
	cardList.add(new CounterOfCard(cardEnumeration.QUEEN, calculNumberOfCardByValue(12)));
	cardList.add(new CounterOfCard(cardEnumeration.JACK, calculNumberOfCardByValue(11)));
	cardList.add(new CounterOfCard("10", calculNumberOfCardByValue(10)));
	cardList.add(new CounterOfCard("9", calculNumberOfCardByValue(9)));
	cardList.add(new CounterOfCard("8", calculNumberOfCardByValue(8)));
	cardList.add(new CounterOfCard("7", calculNumberOfCardByValue(7)));
	cardList.add(new CounterOfCard("6", calculNumberOfCardByValue(6)));
	cardList.add(new CounterOfCard("5", calculNumberOfCardByValue(5)));
	cardList.add(new CounterOfCard("4", calculNumberOfCardByValue(4)));
	cardList.add(new CounterOfCard("3", calculNumberOfCardByValue(3)));
	cardList.add(new CounterOfCard("2", calculNumberOfCardByValue(2)));
	cardList.add(new CounterOfCard("1", calculNumberOfCardByValue(1)));
	
	return cardList;
	
}


/**
 * Gets the card by color and value.
 *
 * @return the card by color and value
 */
public List<Card> getCardByColorAndValue() {
	// creating a new list for add the card in a ramdon order
	ArrayList<Card> cardByOder = deckCard;
	Collections.sort(cardByOder,new Comparator<Card>() {
		
		//override the comparator for make my own coparator
		 @Override
		    public int compare(Card card1, Card card2) {
			 
			 int valCard1 =0;
			 int valCard2 = 0;
		    	//replace the value of card by this name
				switch(card1.getCardColor()) 
				{    	    
				//in function of the color of card multiply by an value for have on final the card ordered by color
				case cardEnumeration.HEART :
					valCard1 = card1.getCardvalue() * 1000;
					break;
				case  cardEnumeration.SPADES :
					valCard1 = card1.getCardvalue() * 100;
					break;
				case cardEnumeration.CLUBS :
					valCard1 = card1.getCardvalue() * 10;
					break;
				}
				switch(card2.getCardColor()) 
				{    	    	
				case  cardEnumeration.HEART :
					valCard2 = card2.getCardvalue() * 1000;
					break;
				case cardEnumeration.SPADES :
					valCard2 = card2.getCardvalue() * 100;
					break;
				case cardEnumeration.CLUBS :
					valCard2 = card2.getCardvalue() * 10;
					break;
				}
		        return Integer.compare(valCard1,valCard2);
		 }}
			.reversed());
	
	return cardByOder;
}



/**
 * Gets the deck card.
 *
 * @return the deckCard
 */
public List<Card> getDeckCard() {
	return deckCard;
}



/**
 * Sets the deck card.
 *
 * @param deckCard the deckCard to set
 */
public void setDeckCard(ArrayList<Card> deckCard) {
	this.deckCard = deckCard;
}


}
