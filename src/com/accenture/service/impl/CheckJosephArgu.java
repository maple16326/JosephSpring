package com.accenture.service.impl;

import com.accenture.exception.ServiceException;

public class CheckJosephArgu {
	private static final String INTERVAL_IS_NOT_A_POSITIVE_NUMBER = "interval is not a positive number";
	private static final String START_NO_IS_NOT_A_POSITIVE_NUMBER = "startNo is not a positive number";
	private static final String INTERVALS_IS_NOT_A_NUMBER = "intervals is not a number!";
	private static final String START_NO_IS_NOT_A_NUMBER = "startNo is not a number!";
	private static final String INTERVAL_IS_NULL = "interval is null!";
	private static final String START_IS_NULL = "start is null!";

	public Boolean checkJosephParameter(String start, String interval, String[] persons) throws ServiceException {
		int startNo;
		int intervalInt;
		Boolean bl=false;
	
		if(start==null){
		    
			throw new ServiceException(START_IS_NULL);
	    
		}
		if(interval==null){
		
			throw new ServiceException(INTERVAL_IS_NULL);

		}
		if(persons==null){
	
			throw new ServiceException(INTERVAL_IS_NULL);
		}
		else {

			try {
				startNo = Integer.parseInt(start);

			} catch (NumberFormatException e) {

				throw new ServiceException(START_NO_IS_NOT_A_NUMBER, e);
			}
			try {
				intervalInt = Integer.parseInt(interval);
			} catch (NumberFormatException e) {
				throw new ServiceException(INTERVALS_IS_NOT_A_NUMBER, e);
			}
			if (startNo < 0) {
				throw new ServiceException(START_NO_IS_NOT_A_POSITIVE_NUMBER);
			} else if (intervalInt < 0) {
				throw new ServiceException(INTERVAL_IS_NOT_A_POSITIVE_NUMBER);
			}
			else {
				bl=true;
			}

		}
		return bl;}
}
 