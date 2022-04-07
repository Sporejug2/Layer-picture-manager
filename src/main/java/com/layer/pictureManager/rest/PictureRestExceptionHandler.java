package com.layer.pictureManager.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PictureRestExceptionHandler {

	// Add an exception handler for PictureNotFoundException
	
	@ExceptionHandler
	 public ResponseEntity<PictureErrorResponse> handleException(PictureNotFoundException exc){
		
		// create PictureErrorREsponse
		PictureErrorResponse error = new PictureErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		// return REsponeEntitiy
		
		return new ResponseEntity<PictureErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	// Add another exception handler .. to catch any exception (catch all)
	@ExceptionHandler
	 public ResponseEntity<PictureErrorResponse> handleException(Exception exc){
		
		// create PictureErrorREsponse
		PictureErrorResponse error = new PictureErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		// return REsponeEntitiy
		
		return new ResponseEntity<PictureErrorResponse>(error, HttpStatus.BAD_REQUEST);
	} 
}
