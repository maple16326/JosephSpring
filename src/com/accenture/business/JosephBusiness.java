package com.accenture.business;

import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;
import com.accenture.exception.BusinessException;

public interface JosephBusiness {
	public JosephProblemResponse doJosephCalcu(JosephProblemRequest request) throws BusinessException;
}
 