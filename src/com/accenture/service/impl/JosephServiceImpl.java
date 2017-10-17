package com.accenture.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import com.accenture.exception.BusinessException;
import com.accenture.exception.NegativeArgumentException;
import com.accenture.exception.NullArgumentValueException;
import com.accenture.service.JosephService;

public class JosephServiceImpl implements JosephService {
	private static final Logger LOGGER = Logger.getLogger(JosephServiceImpl.class);

	public String solveJosephProblem(String[] persons, int interval, int startNo) throws BusinessException {
		CheckJosephArgu checkJosephArgument = new CheckJosephArgu();
		try {
			checkJosephArgument.checkJosephParameter(startNo, interval, persons);
			List<String> person = new ArrayList<>();
			person.addAll(Arrays.asList(persons));
			int k = startNo - 1;
			LOGGER.debug(person);
			while (person.size() > 1) {
				k = k + interval;
				k = k % (person.size()) - 1;
				if (k < 0) {
					LOGGER.debug("reomove:" + person.get(person.size() - 1));
					person.remove(person.size() - 1);
					k = 0;
				} else {
					LOGGER.debug("reomove:" + person.get(k));
					person.remove(k);
				}

			}
			LOGGER.info("the last element is:" + person.get(0));

			return person.get(0);
		} catch (NullArgumentValueException e) {
			throw new BusinessException("Bussiness level failed!", e);
		} catch (NegativeArgumentException e) {
			throw new BusinessException("Bussiness level failed!", e);
		}

	}

}
