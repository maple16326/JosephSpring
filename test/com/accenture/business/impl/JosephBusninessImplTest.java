package com.accenture.business.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.accenture.dto.Circle;
import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;
import com.accenture.exception.BusinessException;
import com.accenture.service.JosephService;
import com.accenture.business.*;
import static org.mockito.Mockito.*;  

@RunWith(MockitoJUnitRunner.class)
public class JosephBusninessImplTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();	
	
	@InjectMocks
	private JosephBusiness josephBusniness=new JosephBusninessImpl();
	@Mock
	private JosephService josephService;
	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoJosephCalcuNormal() throws BusinessException {
		
		JosephProblemRequest josephProblemRequest=new JosephProblemRequest();
		Circle circle=new Circle();
		List<String>persons=new ArrayList<>();
		persons.add("a");
		persons.add("b");
		persons.add("c");
		persons.add("d");
		circle.setInterval(1);
		circle.setStart(0);
		circle.setPersons(persons);
		josephProblemRequest.setCircle(circle);
		when(josephService.solveJosephProblem(persons, 1, 0)).thenReturn("a");
		josephBusniness.doJosephCalcu(josephProblemRequest);
		JosephProblemResponse josephProblemResponse=new JosephProblemResponse();
		josephProblemResponse.setErrors(null);
		josephProblemResponse.setPerson("a");
		assertEquals("a",josephBusniness.doJosephCalcu(josephProblemRequest).getPerson());
	}
	@Test
	//persons=null
	public void testDoJosephCalcuThrowException() throws BusinessException {
		
		JosephProblemRequest problemRequest=new JosephProblemRequest();
		Circle circle=new Circle();
		circle.setInterval(1);
		circle.setStart(0);
		circle.setPersons(null);
		problemRequest.setCircle(circle);
		when(josephService.solveJosephProblem(null, 1, 0)).thenThrow(new BusinessException("Business level failed!"));
		thrown.expect(BusinessException.class);
		josephBusniness.doJosephCalcu(problemRequest);		
	}
}
 