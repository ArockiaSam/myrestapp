/**
 * 
 */
package com.thinktower.myrestapp.exception;

public class LimitExceedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public LimitExceedException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public LimitExceedException() {
		super();
	}
}
