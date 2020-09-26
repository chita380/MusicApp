package com.MusicApp.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.MusicApp.Registration.Exception.ModificationException;

@RestControllerAdvice
public class ModificationAdvice {

	@ExceptionHandler(value = {ModificationException.class})
	public ResponseEntity<String> Exception1(ModificationException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
