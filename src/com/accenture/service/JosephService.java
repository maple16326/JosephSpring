package com.accenture.service;

import java.util.List;

import com.accenture.exception.BusinessException;

public interface JosephService {
	public String solveJosephProblem (List<String> persons, int interval, int startNo)throws BusinessException;
}
 