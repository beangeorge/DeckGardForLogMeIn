/**
 * 
 */
package org.logmein.basicDeckOfCardsGame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.logmein.basicDeckOfCardsGame.exception.PlayerNotExistException;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 *
 * @author robi
 */
public class Game {

	


	/** The name of game. */
	private String name;
	
	/** The shoe. */
	private Deck shoe;
	
	/** The players. */
	private Map<String, Player> players;
	
	

	/**
	 * Instantiates a new game.
	 *
	 * @param name the name
	 */
	public  Game(String name) {
		this.name = name;
		this.shoe = new Deck();
		this.players = new HashMap<String, Player>();
	
	}
	
	
    /**
     * Join player.
     *
     * @param player the player
     */
    public void joinPlayer(Player player) {
    	
    	      
        players.put(player.getNickName(), player);
    }

    /**
     * Removes the player.
     *
     * @param nickName the nick name
     */
    public void removePlayer(String nickName) {
        
    	  if (!this.getPlayerNames().contains(nickName)) {
              throw new PlayerNotExistException();      }
          this.players.remove(nickName);      
    }

    
    /**
     * Player take card.
     *
     * @param nickName the nick name
     * @return the card
     */
    public Card playerTakeCard(String nickName) {
        if (!this.getPlayerNames().contains(nickName)) {
            throw new PlayerNotExistException();      }
        Player player = players.get(nickName);      
        Card takedCard = shoe.takeCard();
        player.addCard(takedCard);
        return takedCard;
    }
    
    
    /**
     * Gets the player names.
     *
     * @return the player names
     */
    public List<String> getPlayerNames() {
        return new ArrayList<>(players.keySet());
    }




	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Gets the players.
	 *
	 * @return the players
	 */
	public Map<String, Player> getPlayers() {
		return players;
	}

	/**
	 * Gets the player.
	 *
	 * @param nickname the nickname
	 * @return the player
	 */
	public Player getPlayer(String nickname) {
		return this.players.get(nickname);
	}

	
	/**
	 * Sort the player by hand value.
	 *
	 * @return the List of player Order by hand value
	 */
	public List<Player> getPlayerByHandValue() {
		
	      List<Player> playerByValue = new ArrayList<Player>(players.values());
	      Collections.sort(playerByValue,new Comparator<Player>() {
	  		//ovreride the compartor for ordered the players by hand value
	 		 @Override
	 		    public int compare(Player player1, Player player2) {return Integer.compare(player1.getHandValue(),player2.getHandValue());
	 		 }}
	 			.reversed());
	     return   playerByValue;
		
	}

	/**
	 * Sets the name.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * Gets the shoe.
	 *
	 * @return the shoe
	 */
	public Deck getShoe() {
		return shoe;
	}


	/**
	 * Sets the shoe.
	 *
	 * @param shoe the new shoe
	 */
	public void setShoe(Deck shoe) {
		this.shoe = shoe;
	}


	
	

}
