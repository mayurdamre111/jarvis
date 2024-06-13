package com.jarvis.exceptions;

public class InvalidSelectorException extends RuntimeException {

	String locatorType;
	
	public InvalidSelectorException(String locatorType) {
		this.locatorType= locatorType;
	}
	
	@Override
	public String getMessage() {
		return "Invalid Selector Type: "+locatorType;
	}
	
}
