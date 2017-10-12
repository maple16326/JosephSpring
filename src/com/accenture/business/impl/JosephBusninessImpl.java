package com.accenture.business.impl;

import java.util.List;

import com.accenture.business.JosephBusiness;
import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;

import com.accenture.exception.BusinessException;
import com.accenture.service.JosephProblem;
import com.accenture.service.impl.JosephProblemImpl;

public class JosephBusninessImpl implements JosephBusiness {
	private JosephProblem josephProblem;

	public JosephProblem getJosephProblem() {
		return josephProblem;
	}



	public void setJosephProblem(JosephProblem josephProblem) {
		this.josephProblem = josephProblem;
	}



	public JosephProblemResponse doJosephCalcu(JosephProblemRequest request) throws BusinessException {

		JosephProblemResponse response = new JosephProblemResponse();
		int interval = request.getCircle().getInterval();
		int start = request.getCircle().getStart();
		List<String>persons = request.getCircle().getPersons();
		JosephProblem joseph = new JosephProblemImpl();
		String person = null;
		try {
			String[] personArray = new String[persons.size()];
			//convert list to array
			persons.toArray(personArray);
			person = joseph.solveJosephProblem(personArray, interval, start);
			response.setPerson(person);
			response.setErrors(null);
		} catch (Exception e) {
			throw new BusinessException("Bussiness level failed!", e);
		}

		return response;
	}

}
