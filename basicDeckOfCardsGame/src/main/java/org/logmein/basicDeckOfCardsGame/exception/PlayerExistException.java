package org.logmein.basicDeckOfCardsGame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * The Class PlayerExistException.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Player already exist")
public class PlayerExistException extends RuntimeException {
	
	}


