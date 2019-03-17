THe project is a basice game form manipulatiuong card from a deck

the project are created by using spring boot for making REST microservice

For documentation and testing I have implement swagger
http://localhost:8080/swagger-ui.html#/basic-desk-of-cards-controller

I have make some junit test case in the test project


the instructions and implementation method are :

 * Create and delete a game
Implementation http://localhost:8080/game/

* Create a deck

Implementation http://localhost:8080/game/{gameName}/addDeck


* Add a deck to a game deck

Implementation http://localhost:8080/game/{gameName}/addDeck

Please note that once a deck has been added to a game deck it cannot be removed.

* Add and remove players from a game
Implementation http://localhost:8080/game/{gameName}/Player

* Deal cards to a player in a game from the game deck
Implementation http://localhost:8080/game/{gameName}/{playerNickname}/dealCard


* Get the list of cards for a player
Implementation http://localhost:8080/game/{gameName}/{playerNickname}/getPlayerListOfCards


* Get the list of players in a game along with the total added value of all the cards each player holds; use face values of cards only. Then sort the list in descending order, from the player with the highest value hand to the player with the lowest value hand:
Implementation http://localhost:8080//game/{gameName}/getPlayerByCardsValue

* Get the count of how many cards per suit are left undealt in the game deck (example: 5 hearts, 3 spades, etc.)
Implementation http://localhost:8080/game/{gameName}/getDeckCardByColor

* Get the count of each card (suit and value) remaining in the game deck sorted by suit ( hearts, spades, clubs, and diamonds) and face value from high value to low value (King, Queen, Jack, 10….2, Ace with value of 1)
Implementation http://localhost:8080/game/{gameName}/getShoeCountOfCardOrderByColorAndValue
and with cards details
Implementation http://localhost:8080/game/{gameName}/getShoeListOfCards

* Shuffle the game deck (shoe)
Implementation http://localhost:8080/game/{gameName}/shuffle
 
