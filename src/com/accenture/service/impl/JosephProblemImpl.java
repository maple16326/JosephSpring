package com.accenture.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import com.accenture.exception.ServiceException;
import com.accenture.service.JosephProblem;

public class JosephProblemImpl implements JosephProblem {
	private static final Logger LOGGER = Logger.getLogger(JosephProblemImpl.class);
	private static final String LOG4J_PROPERTIES = "log4j.properties";
	private CheckJosephArgu checkJosephArgu;
	private ServiceException serviceException;

	public ServiceException getServiceException() {
		return serviceException;
	}

	public void setServiceException(ServiceException serviceException) {
		this.serviceException = serviceException;
	}

	public CheckJosephArgu getCheckJosephArgu() {
		return checkJosephArgu;
	}

	public void setCheckJosephArgu(CheckJosephArgu checkJosephArgu) {
		this.checkJosephArgu = checkJosephArgu;
	}

	public String solveJosephProblem(String[] persons, int interval, int startNo) throws ServiceException {
		
		CheckJosephArgu checkJosephArgu=new CheckJosephArgu();
		/*checkJosephArgu.checkJosephParameter(startNo, interval, persons);
		int intervals = Integer.parseInt(interval);
		int start = Integer.parseInt(startNo);*/
		List<String> person = new ArrayList<String>();
		person.addAll(Arrays.asList(persons));
		int k = startNo - 1;
		LOGGER.info(person);
		while (person.size() > 1) {
			k = k + interval;
			k = k % (person.size()) - 1;
			if (k < 0) {
				LOGGER.info("reomove:" + person.get(person.size() - 1));
				person.remove(person.size() - 1);
				k = 0;
			} else {
				LOGGER.info("reomove:" + person.get(k));
				person.remove(k);
			}

		}
		LOGGER.info("the last element is:" + person.get(0));

		return person.get(0);
		
	}

	public void solve(String inputFilePath, String outputDirPath) {

	}

	
}
