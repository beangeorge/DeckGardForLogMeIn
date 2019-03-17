/**
 * 
 */
package org.logmein.basicDeckOfCardsGame.controller;

import java.util.ArrayList;
import java.util.List;

import org.logmein.basicDeckOfCardsGame.dao.GameDao;
import org.logmein.basicDeckOfCardsGame.exception.GameFoundException;
import org.logmein.basicDeckOfCardsGame.exception.GameNotFoundException;
import org.logmein.basicDeckOfCardsGame.exception.PlayerExistException;
import org.logmein.basicDeckOfCardsGame.exception.PlayerNotExistException;
import org.logmein.basicDeckOfCardsGame.model.Card;
import org.logmein.basicDeckOfCardsGame.model.CounterOfCard;
import org.logmein.basicDeckOfCardsGame.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author robi
 *
 */

@Api(description = "API for simulate a bask card Deck game")
@RestController
@RequestMapping(value = "/game")
public class BasicDeskOfCardsController {

	@Autowired
	private GameDao gameDao;

	public String welcome() {

		return "Welcome to Api of basic deck of card";
	}

	// URL:
	// http://localhost:8080/game
	/**
	 * Adds the game.
	 *
	 * @param gameName the game name
	 * @return the response entity
	 */
	// Used for create the game
	@ApiOperation(value = "Create a new game")
	@ApiParam()

	@RequestMapping(method = RequestMethod.POST, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addGame(@ApiParam(value = "Name of the party, required = true") @RequestParam("gameName") String gameName) {

		System.out.println("(Service Side) Creating Game: " + gameName);
		if (gameDao.getById(gameName) != null)
			throw new GameFoundException();
		gameDao.createGame(gameName);
		return new ResponseEntity<String>("Game " + gameName + " is created successfully", HttpStatus.CREATED);
	}

	// URL:
	// http://localhost:8080/game
	/**
	 * Delete game.
	 *
	 * @param gameName the game name
	 * @return the response entity
	 */
	// Used for Delete a game
	@ApiOperation(value = "Delete a game")
	@RequestMapping(value = "/{gameName}", //
			method = RequestMethod.DELETE, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> deleteGame(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName) {

		
		if (gameDao.getById(gameName) == null)
			throw new GameNotFoundException();
		System.out.println("(Service Side) Deleting game: " + gameName);

		gameDao.removeGame(gameName);
		return new ResponseEntity<String>("Game " + gameName + " is successfully deleted", HttpStatus.OK);
	}

	// URL:
	// http://localhost:8080/game/{gameName}/addDeck
	/**
	 * Adds the deck.
	 *
	 * @param gameName the game name
	 * @return the response entity
	 */
	// Used for add a new deck of a game
	@ApiOperation(value = "add a deck of game")

	@RequestMapping(value = "/{gameName}/addDeck", //
			method = RequestMethod.POST, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addDeck(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName) {

		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();
		System.out.println("(Service Side) Creating deck: " + gameName);
		this.gameDao.getById(gameName).getShoe().addCompleteGame();
		return new ResponseEntity<String>("Deck is created successfully", HttpStatus.OK);
	}
	
	// http://localhost:8080/game/{gameName}/shuffle
		/**
	 * Shuffle.
	 *
	 * @param gameName the game name
	 * @return the response entity
	 */
	// Used for shuffle the card in the deck of the game
		@ApiOperation(value = "Shuffle the card in the deck of the game   ")

		@RequestMapping(value = "/{gameName}/shuffle", //
				method = RequestMethod.GET, //
				produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		public  ResponseEntity<String> shuffle(@PathVariable("gameName") String gameName) {

			System.out.println("(Service Side) shuffle : " + gameName);
			if (gameDao.getById(gameName) == null)
			throw new GameNotFoundException();
			this.gameDao.getById(gameName).getShoe().suffleGame();
			return new ResponseEntity<String>("Deck card has succefully add to party " + gameName, HttpStatus.OK);
		}

		
		

	// URL:
	// http://localhost:8080/game/{gameName}/addPlayer
	/**
	 * Adds the player.
	 *
	 * @param gameName the game name
	 * @param playeNickname the playe nickname
	 * @param playerFistName the player fist name
	 * @param playerLastName the player last name
	 * @return the response entity
	 */
	// Used for add a player at the designed game
	@ApiOperation(value = "Add a player at the designed game  ")

	@RequestMapping(value = "/{gameName}/Player", //
			method = RequestMethod.POST, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> addPlayer(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName,
			@ApiParam(value = "Nickname of the player", required = true) @RequestParam("nickname") String playeNickname,
			@ApiParam(value = "Fisrt name of the player", required = true) @RequestParam("firstname") String playerFistName,
			@ApiParam(value = "Last name of the player", required = true) @RequestParam("lastname") String playerLastName) {
		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();
		Player player = new Player(playeNickname,playerFistName,playerLastName);

		System.out.println("(Service Side) Add player : " + player.getFirstName());

		this.gameDao.getById(gameName).joinPlayer(player);

		return new ResponseEntity<String>("player "+playeNickname+" is join to party "+gameName+" successfully", HttpStatus.OK);
	}

	
	// http://localhost:8080/game/{gameName}/{playerNickname}/removePlayer
	/**
	 * Removes the player.
	 *
	 * @param gameName the game name
	 * @param playerNickname the player nickname
	 */
	// Used for remove a player on the party
	@ApiOperation(value = "Remove a player on the party")

	@RequestMapping(value = "/{gameName}/{playerNickname}/Player", //
			method = RequestMethod.DELETE, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void removePlayer(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName,
			@ApiParam(value = "NickName of the player", required = true) @PathVariable("playerNickname") String playerNickname) {

		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();

		if (gameDao.getById(gameName).getPlayer(playerNickname) != null)
		throw new PlayerExistException();
		System.out.println("(Service Side) Delete player : " + playerNickname);

		this.gameDao.getById(gameName).removePlayer(playerNickname);
	}

	// http://localhost:8080/game/{gameName}/{playerNickname}/dealCard
	/**
	 * Deal card.
	 *
	 * @param gameName the game name
	 * @param playerNickname the player nickname
	 * @return the response entity
	 */
	// Used for give a card at a player
	@ApiOperation(value = "Give a card at a player")

	@RequestMapping(value = "/{gameName}/{playerNickname}/dealCard", //
			method = RequestMethod.GET, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Card> dealCard(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName,
			@ApiParam(value = "NickName of the player", required = true) @PathVariable("playerNickname") String playerNickname) {

		System.out.println("(Service Side) dealcard for  player : " + playerNickname);

		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();

		if (gameDao.getById(gameName).getPlayer(playerNickname) == null)
		throw new PlayerNotExistException();
		Card card = new Card();
		card = this.gameDao.getById(gameName).playerTakeCard(playerNickname);
		return new ResponseEntity<Card>( card,HttpStatus.OK);
	}

	// http://localhost:8080/game/{gameName}/getShoeListOfCardsOrderByColorAndValue
	/**
	 * Gets the shoe list of cards order by color and value.
	 *
	 * @param gameName the game name
	 * @return the shoe list of cards order by color and value
	 */
	// Used for get the list of card in the shoe of the party
	@ApiOperation(value = "Get the list of card in the shoe of the party order by color and value")
	@RequestMapping(value = "/{gameName}/getShoeListOfCards", //
			method = RequestMethod.GET, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Card>> getShoeListOfCardsOrderByColorAndValue(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName) {

		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();
		System.out.println("(Service Side) List of card for shoe : " + gameName);
		List<Card> cardlist = new ArrayList<Card>();
		cardlist = this.gameDao.getById(gameName).getShoe().getCardByColorAndValue();
		return new ResponseEntity<List<Card>>(cardlist,HttpStatus.OK);
	}
	
	// http://localhost:8080/game/{gameName}/getShoeCountOfCardOrderByColorAndValue
	/**
	 * Gets the shoe count of card order by color and value.
	 *
	 * @param gameName the game name
	 * @return the shoe count of card order by color and value
	 */
	// Used for get the list of card in the count of the party
	@ApiOperation(value = "Get the count of card in the shoe of the party order by color and value")
	@RequestMapping(value = "/{gameName}/getShoeCountOfCardOrderByColorAndValue", //
			method = RequestMethod.GET, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CounterOfCard> > getShoeCountOfCardOrderByColorAndValue(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName) {
		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();
		System.out.println("(Service Side) List of card for shoe : " + gameName);
		List<CounterOfCard> cardlist = new ArrayList<CounterOfCard>();
		cardlist = this.gameDao.getById(gameName).getShoe().cardListByColoAndValue();
		return new ResponseEntity<List<CounterOfCard>>(cardlist,HttpStatus.OK);
	}
	// http://localhost:8080/game/{gameName}/{playerNickname}/getPlayerListOfCar
	/**
	 * Gets the player list of cards.
	 *
	 * @param gameName the game name
	 * @param playerNickname the player nickname
	 * @return the player list of cards
	 */
	// Used for get the list of card of a player
	@ApiOperation(value = "Get the list of card of a player")
	@RequestMapping(value = "/{gameName}/{playerNickname}/getPlayerListOfCards", //
			method = RequestMethod.GET, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Card>> getPlayerListOfCards(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName,
			@ApiParam(value = "NickName of the player", required = true) @PathVariable("playerNickname") String playerNickname) {

		if (gameDao.getById(gameName) == null)
		throw new GameNotFoundException();

		if (gameDao.getById(gameName).getPlayer(playerNickname) == null)
		throw new PlayerNotExistException();
		System.out.println("(Service Side) List of card for player : " + playerNickname);
		List<Card> cardlist = new ArrayList<Card>();
		cardlist = this.gameDao.getById(gameName).getPlayer(playerNickname).getCards().getCardByColorAndValue();
		return new ResponseEntity<List<Card>>(cardlist,HttpStatus.OK);
	}

	// http://localhost:8080/game/{gameName}/getPlayerByCardsValue
	/**
	 * Gets the player by cards value.
	 *
	 * @param gameName the game name
	 * @return the player by cards value
	 */
	// Used for get the list of players order by hand value
	@ApiOperation(value = "Get the list of players order by hand value")
	@RequestMapping(value = "/{gameName}/getPlayerByCardsValue", //
			method = RequestMethod.GET, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<Player>> getPlayerByCardsValue(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName) {

		if (gameDao.getById(gameName) == null)
			throw new GameNotFoundException();
		System.out.println("(Service Side) value of card for Party : " + gameName);

		return new ResponseEntity<List<Player>>(this.gameDao.getById(gameName).getPlayerByHandValue(),HttpStatus.OK);
	
	}

	// http://localhost:8080/game/{gameName}/getDeckCardByColor
	// Used for get the count of each card (suit and value) remaining in the game
	/**
	 * Gets the deck card by color.
	 *
	 * @param gameName the game name
	 * @return the deck card by color
	 */
	// deck sorted by suit and value
	@ApiOperation(value = "Get the list of card by color")

	@RequestMapping(value = "/{gameName}/getDeckCardByColor", //
			method = RequestMethod.GET, //
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<CounterOfCard> > getDeckCardByColor(@ApiParam(value = "Name of the game", required = true) @PathVariable("gameName") String gameName) {
		if (gameDao.getById(gameName) == null)
			throw new GameNotFoundException();
		System.out.println("(Service Side) List of card for player : " + gameName);

		return  new ResponseEntity<List<CounterOfCard> > (this.gameDao.getById(gameName).getShoe().cardList(),HttpStatus.OK);
	}

}
