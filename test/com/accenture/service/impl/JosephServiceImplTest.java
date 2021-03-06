package com.accenture.service.impl;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.accenture.exception.BusinessException;



public class JosephServiceImplTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	//start=1;interval=1;persons={"a","b","c","1","2","3","d","ee"}
	public void testSolveJosephProblemNormal() throws BusinessException {
		JosephServiceImpl josephServiceImpl=new JosephServiceImpl();
		String[] personStr={"a","b","c","1","2","3","d","ee"};
		int interval=1; 
		int start=2;
		String s="a";
		List<String>persons=Arrays.asList(personStr);
		CheckJosephArgu checkJosephArgument=new CheckJosephArgu();
			josephServiceImpl.setCheckJosephArgument(checkJosephArgument);
			assertEquals(s,josephServiceImpl.solveJosephProblem(persons, interval, start));
		}
	
	@Test
	//start=-1;interval=1;persons={"a","b","c","1","2","3","d","ee"}
	public void testSolveJosephProblemStartIsNegative() throws BusinessException {
		JosephServiceImpl josephServiceImpl=new JosephServiceImpl();
		String[] personStr={"a","b","c","1","2","3","d","ee"};
		List<String>persons=Arrays.asList(personStr);
		int interval=-1; 
		int start=2;
		CheckJosephArgu checkJosephArgument=new CheckJosephArgu();
			josephServiceImpl.setCheckJosephArgument(checkJosephArgument);
			thrown.expect(BusinessException.class);
			thrown.expectMessage("Bussiness level failed!");
			josephServiceImpl.solveJosephProblem(persons, interval, start);
		
	}
	@Test
	//start=-1;interval=1;persons=null
	public void testSolveJosephProblemPersonsIsNull() throws BusinessException {
		JosephServiceImpl josephServiceImpl=new JosephServiceImpl();
		//String[] persons=null;
		List<String>persons=null;
		int interval=-1; 
		int start=2;
		CheckJosephArgu checkJosephArgument=new CheckJosephArgu();
			josephServiceImpl.setCheckJosephArgument(checkJosephArgument);
			thrown.expect(BusinessException.class);
			thrown.expectMessage("Bussiness level failed!");
			josephServiceImpl.solveJosephProblem(persons, interval, start);
		
	}
}
 