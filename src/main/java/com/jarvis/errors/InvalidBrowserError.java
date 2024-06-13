package com.jarvis.errors;

public class InvalidBrowserError extends Error{
	
	String browserName;
	public InvalidBrowserError(String browserName) {
		this.browserName = browserName;
	}
	
	@Override
	public String getMessage() {
		return "Invalid Browser Name: "+browserName;
	}

}
