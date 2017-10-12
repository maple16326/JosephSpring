package com.accenture.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -124906570858352606L;

	public BusinessException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	/**
	 * @param message
	 * @param cause
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public BusinessException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public BusinessException(Throwable cause) {
		super(cause);

	}

}
