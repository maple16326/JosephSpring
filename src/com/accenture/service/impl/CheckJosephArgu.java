package com.accenture.service.impl;

import com.accenture.exception.NegativeArgumentException;
import com.accenture.exception.NullArgumentValueException;

public class CheckJosephArgu {
	private static final String PERSONS_IS_NULL = "persons is null! ";
	private static final String AND = "and ";
	private static final String INTERVAL_IS_NOT_A_POSITIVE_NUMBER = "interval is not a positive number";
	private static final String START_NO_IS_NOT_A_POSITIVE_NUMBER = "startNo is not a positive number";
	private static final String INTERVAL_IS_NULL = "interval is null! ";
	private static final String START_IS_NULL = "start is null! ";

	public Boolean checkJosephParameter(Integer start, Integer interval, String[] persons)
			throws NullArgumentValueException, NegativeArgumentException {
		Boolean bl = false;

		if (start == null && interval != null && persons != null) {
			throw new NullArgumentValueException(START_IS_NULL);

		} else if (interval == null && start != null && persons != null) {

			throw new NullArgumentValueException(INTERVAL_IS_NULL);

		} else if (persons == null && start != null && interval != null) {

			throw new NullArgumentValueException(PERSONS_IS_NULL);
		} else if (start == null && interval == null && persons != null) {
			throw new NullArgumentValueException(START_IS_NULL+AND+INTERVAL_IS_NULL);
		} else if (start == null && interval != null && persons == null) {
			throw new NullArgumentValueException(START_IS_NULL+AND+PERSONS_IS_NULL);
		} else if (start != null && interval == null && persons == null) {
			throw new NullArgumentValueException(INTERVAL_IS_NULL+AND+PERSONS_IS_NULL);
		} else if (start == null && interval == null && persons == null) {
			throw new NullArgumentValueException(START_IS_NULL+AND+INTERVAL_IS_NULL+AND+PERSONS_IS_NULL);
		} else {

			if (start < 0 && interval > 0) {
				throw new NegativeArgumentException(START_NO_IS_NOT_A_POSITIVE_NUMBER);
			} else if (start > 0 && interval < 0) {
				throw new NegativeArgumentException(INTERVAL_IS_NOT_A_POSITIVE_NUMBER);
			} else if (start < 0 && interval < 0) {
				throw new NegativeArgumentException(
						START_NO_IS_NOT_A_POSITIVE_NUMBER + AND + INTERVAL_IS_NOT_A_POSITIVE_NUMBER);

			} else {
				bl = true;
			}

		}

		return bl;
	}
}
