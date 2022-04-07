package com.layer.pictureManager.rest;

public class PictureNotFoundException extends RuntimeException {

	public PictureNotFoundException() {
	}

	public PictureNotFoundException(String message) {
		super(message);
	}

	public PictureNotFoundException(Throwable cause) {
		super(cause);
	}

	public PictureNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PictureNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
