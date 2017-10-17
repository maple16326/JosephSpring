package com.accenture.exception; 

public class NegativeArgumentException extends Exception{

	public NegativeArgumentException() {
		
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NegativeArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public NegativeArgumentException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public NegativeArgumentException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public NegativeArgumentException(Throwable cause) {
		super(cause);

	}

}
 