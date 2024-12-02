package com.ty.Exceptions;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	String message;

	public StudentNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
