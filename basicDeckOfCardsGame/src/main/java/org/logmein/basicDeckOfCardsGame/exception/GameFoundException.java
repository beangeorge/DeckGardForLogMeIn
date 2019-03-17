package org.logmein.basicDeckOfCardsGame.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The Class GameFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Game already exists")
public class GameFoundException extends RuntimeException  {


	 
}
