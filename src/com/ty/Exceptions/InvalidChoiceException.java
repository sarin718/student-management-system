package com.ty.Exceptions;

@SuppressWarnings("serial")
public class InvalidChoiceException extends Exception{
	String message;

	public InvalidChoiceException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}
