package com.registerlogin.model;

public class Errors {
	
	private String message ;

	/**
	 * @param message
	 */
	public Errors(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Errors [message=" + message + "]";
	}
	
	
}
