package com.accenture.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FibonacciServiceImplTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	//Length is 1
	public void testFibonacciLengthEqualToOne() {
		List<Long> list = new ArrayList<>();
		list.add((long) 0);
		FibonacciServiceImpl fibonacciServiceImpl =new FibonacciServiceImpl();	
		assertEquals(list,fibonacciServiceImpl.fibonacci(1));
	}
	@Test
	//Length is 2
	public void testFibonacciNormalLengthEqualToTwo() {
		List<Long> list = new ArrayList<>();
		list.add((long) 0);
		list.add((long) 1);
		FibonacciServiceImpl fibonacciServiceImpl =new FibonacciServiceImpl();	
		assertEquals(list,fibonacciServiceImpl.fibonacci(2));
	}
	@Test
	//Length is 3
	public void testFibonacciNormalLengthEqualToThree() {
		List<Long> list = new ArrayList<>();
		list.add((long) 0);
		list.add((long) 1);
		list.add((long) 1);
		FibonacciServiceImpl fibonacciServiceImpl =new FibonacciServiceImpl();	
		assertEquals(list,fibonacciServiceImpl.fibonacci(3));
	}
	@Test
	//Length is negative
	public void testFibonacciNormalLengthIsNegative() throws Exception{
		FibonacciServiceImpl fibonacciServiceImpl =new FibonacciServiceImpl();	
		thrown.expect(IllegalArgumentException.class);
		fibonacciServiceImpl.fibonacci(-3);

	}
}
 