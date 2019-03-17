package org.logmein.basicDeckOfCardsGame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class PlayerNotExistException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "player not found")
public class PlayerNotExistException extends RuntimeException {
}
