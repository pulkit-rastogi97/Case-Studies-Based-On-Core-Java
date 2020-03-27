package com.psl;

public class InvalidDateFormatException extends Exception {
	
	public InvalidDateFormatException() {
		super("Invalid Date format ");
	}

	public InvalidDateFormatException(String msg) {
		super(msg);
	}
}
