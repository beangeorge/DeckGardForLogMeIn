package org.logmein.basicDeckOfCardsGame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Class GameNotFoundException.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "game not found")
public class GameNotFoundException extends RuntimeException {
}
