/*
 * 
 */
package org.logmein.basicDeckOfCardsGame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class DeckEmptyException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The deck is Empty")
public class DeckEmptyException extends RuntimeException{

	

}
