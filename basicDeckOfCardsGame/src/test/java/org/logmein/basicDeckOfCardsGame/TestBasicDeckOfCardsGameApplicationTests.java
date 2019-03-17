package org.logmein.basicDeckOfCardsGame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.logmein.basicDeckOfCardsGame.controller.BasicDeskOfCardsController;
import org.logmein.basicDeckOfCardsGame.dao.GameDao;
import org.logmein.basicDeckOfCardsGame.model.Player;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The Class TestBasicDeckOfCardsGameApplicationTests.
 */
@RunWith(SpringRunner.class)
public class TestBasicDeckOfCardsGameApplicationTests {

	//test the creation of a game
	  @Test
	  public void testCreateGame() {
	     GameDao gameDao = new GameDao();
	     gameDao.createGame("test");;
	     assertNotNull(gameDao.getById("test"));
	     assertEquals(gameDao.getById("test").getName(), "test");
	  }
	  

		//test the creation of a user
	  @Test
	  public void testCreateUser() {
	     GameDao gameDao = new GameDao();
	     gameDao.createGame("test");
	     Player player = new Player("julien","julien","julien");
	     gameDao.getById("test").joinPlayer(player);
	     assertNotNull(gameDao.getById("test").getPlayer("julien"));
	     assertEquals(gameDao.getById("test").getPlayer("julien").getNickName(), "julien");
	     
	    
	  }
	//test the shuffle of the card
	  @Test
	  public void testShuffle() {
		 int hashcode;
	     GameDao gameDao = new GameDao();
	     gameDao.createGame("test");
	     gameDao.getById("test").getShoe().addCompleteGame();
	     hashcode = gameDao.getById("test").getShoe().getDeckCard().hashCode();
	     assertNotNull(hashcode);
	     gameDao.getById("test").getShoe().suffleGame();
	     //compare the hashcode for see if the order have moved
	     assertNotEquals( gameDao.getById("test").getShoe().getDeckCard().hashCode(), hashcode);
	     
	     
	    
	  }

	  //test the removing and adding a card from shoe to player
	  @Test
	  public void testPickCard() {
		 int nmberOfCard;
	     GameDao gameDao = new GameDao();
	     gameDao.createGame("test");
	     gameDao.getById("test").getShoe().addCompleteGame();
	     nmberOfCard = gameDao.getById("test").getShoe().getDeckCard().size();
	     Player player = new Player("julien","julien","julien");
	     gameDao.getById("test").joinPlayer(player);
	     gameDao.getById("test").getPlayer("julien").addCard(gameDao.getById("test").getShoe().takeCard());
	     assertNotEquals(gameDao.getById("test").getShoe().getDeckCard().size(), nmberOfCard);
	     assertNotNull(gameDao.getById("test").getPlayer("julien").getCards().cardList().get(0));
	    
	     
	     
	     //....
	  }


}