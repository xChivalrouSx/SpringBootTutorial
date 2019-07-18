package com.chivalrous.app.ws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionshandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> handleAnyException(NullPointerException ex) {
		return new ResponseEntity<>("Error : " + ex.getMessage(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception exception) {
		return new ResponseEntity<>("Error...", HttpStatus.NOT_FOUND);
	}
}