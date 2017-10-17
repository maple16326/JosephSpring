package com.accenture.exception; 

public class NullArgumentValueException extends Exception{

	public NullArgumentValueException() {
		
	}
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NullArgumentValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public NullArgumentValueException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public NullArgumentValueException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public NullArgumentValueException(Throwable cause) {
		super(cause);

	}
}
 