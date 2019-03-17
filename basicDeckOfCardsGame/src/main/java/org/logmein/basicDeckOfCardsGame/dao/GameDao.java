package org.logmein.basicDeckOfCardsGame.dao;

import java.util.HashMap;
import java.util.Map;

import org.logmein.basicDeckOfCardsGame.model.Game;
import org.springframework.stereotype.Repository;


@Repository
public class GameDao {

	private Map<String, Game> gameMap;
	
	/**
	 * Instantiates a new game dao.
	 */
	public GameDao() {
		gameMap = new HashMap<String, Game> ();

	}
	
	
	/**
	 * Creates the game.
	 *
	 * @param gameName the game name
	 * @return the game
	 */
	public Game createGame(String gameName) {
        Game game = new Game(gameName);
        this.gameMap.put(game.getName(), game);
        return game;
    }
		
	/**
	 * Removes the game.
	 *
	 * @param gameId the game id
	 */
	public void removeGame(String gameId) {
		this.gameMap.remove(gameId);
    }

	  /**
  	 * Gets the by id.
  	 *
  	 * @param id the id
  	 * @return the by id
  	 */
  	public Game getById(String id) {
	        return this.gameMap.get(id);
	    }	
		
		    
	}


