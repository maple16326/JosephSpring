package com.accenture.service.impl;

import com.accenture.exception.NegativeArgumentException;
import com.accenture.exception.NullArgumentValueException;

public class CheckJosephArgu {
	private static final String INTERVAL_IS_NOT_A_POSITIVE_NUMBER = "interval is not a positive number";
	private static final String START_NO_IS_NOT_A_POSITIVE_NUMBER = "startNo is not a positive number";
	private static final String INTERVAL_IS_NULL = "interval is null!";
	private static final String START_IS_NULL = "start is null!";

	public Boolean checkJosephParameter(Integer start, Integer interval, String[] persons)
			throws NullArgumentValueException, NegativeArgumentException {
		Boolean bl = false;

		if (start == null) {
			throw new NullArgumentValueException(START_IS_NULL);

		}
		if (interval == null) {

			throw new NullArgumentValueException(INTERVAL_IS_NULL);

		}
		if (persons == null) {

			throw new NullArgumentValueException(INTERVAL_IS_NULL);
		} else {

			if (start < 0 && interval > 0) {
				throw new NegativeArgumentException(START_NO_IS_NOT_A_POSITIVE_NUMBER);
			} else if (start > 0 && interval < 0) {
				throw new NegativeArgumentException(INTERVAL_IS_NOT_A_POSITIVE_NUMBER);
			} else if (start < 0 && interval < 0) {
				throw new NegativeArgumentException(
						START_NO_IS_NOT_A_POSITIVE_NUMBER + "&&" + INTERVAL_IS_NOT_A_POSITIVE_NUMBER);

			} else {
				bl = true;
			}

		}
		return bl;
	}
}
