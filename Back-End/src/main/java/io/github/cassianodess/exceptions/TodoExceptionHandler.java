package io.github.cassianodess.exceptions;

import java.util.Date;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {

	@ExceptionHandler(TodoException.class)
	public ResponseEntity<StandardError> objNotFound(TodoException e, ServletRequest request) {
		StandardError error = new StandardError(new Date().getTime(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

}
