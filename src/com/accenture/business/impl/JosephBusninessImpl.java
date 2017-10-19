package com.accenture.business.impl;

import java.util.List;

import com.accenture.business.JosephBusiness;
import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;

import com.accenture.exception.BusinessException;
import com.accenture.service.JosephService;
import com.accenture.service.impl.JosephServiceImpl;

public class JosephBusninessImpl implements JosephBusiness {
	private JosephService josephProblem;

	public JosephService getJosephProblem() {
		return josephProblem;
	}

	public void setJosephProblem(JosephService josephProblem) {
		this.josephProblem = josephProblem;
	}

	public JosephProblemResponse doJosephCalcu(JosephProblemRequest request) throws BusinessException {

		JosephProblemResponse response = new JosephProblemResponse();
		int interval = request.getCircle().getInterval();
		int start = request.getCircle().getStart();
		List<String> persons = request.getCircle().getPersons();
		String person = null;
		try {
			String[] personArray = new String[persons.size()];
			// convert list to array
			persons.toArray(personArray);
			person = josephProblem.solveJosephProblem(personArray, interval, start);
			response.setPerson(person);
			response.setErrors(null);
		} catch (Exception e) {
			throw new BusinessException("Bussiness level failed!", e);
		}

		return response;
	}

}
