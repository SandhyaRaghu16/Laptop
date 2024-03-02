package com.laptop.exception;

import javax.naming.NameNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(value=PriceNotFoundException.class)
	public ResponseEntity<Object> nameHandler(PriceNotFoundException pf)
	{
		return new ResponseEntity<>(pf.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=NameNotFoundException.class)
	public ResponseEntity<Object> nameHandler(NameNotFoundException nf)
	{
		return new ResponseEntity<>(nf.getMessage(),HttpStatus.NOT_FOUND);
	}
	
}
