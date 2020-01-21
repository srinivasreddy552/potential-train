package com.venkat.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)

	public ResponseEntity<ErrorMessage> something(Exception ex) {

		ErrorMessage exceptionResponse = new ErrorMessage(ex.getMessage(), "Not valid Input ");

		return new ResponseEntity<ErrorMessage>(exceptionResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);

	}

	/*
	 * public ResponseEntity<String> springHandleNotFound(HttpServletResponse
	 * response) throws IOException { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).
	 * body("Requested resource does not found");
	 */

}