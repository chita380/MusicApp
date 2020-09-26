package com.MusicApp.Registration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.MusicApp.Registration.Exception.PlaylistException;

@RestControllerAdvice
public class PlaylistAdvice {
	@ExceptionHandler(value = { PlaylistException.class })

	public ResponseEntity<String> Exception1(PlaylistException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
