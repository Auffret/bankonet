package com.bankonet;

public class CompteException extends Exception {

	public CompteException() {
		super();
	}

	public CompteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CompteException(String message, Throwable cause) {
		super(message, cause);
	}

	public CompteException(String message) {
		super(message);
	}

	public CompteException(Throwable cause) {
		super(cause);
	}	
	

}
