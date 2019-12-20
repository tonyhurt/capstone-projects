package com.techelevator.exceptions.calc.str;

public class InvalidStringException extends Exception { // extends Exception because want to be Checked Exception

	private String originalValue;

	public InvalidStringException(String message, String OriginalValue) {
		super(message);
		this.originalValue = originalValue;

	}
	
	public String getOriginalValue() {
		return this.originalValue;
		
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + " " + this.originalValue;
		
	}

}
