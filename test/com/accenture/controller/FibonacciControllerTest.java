package com.accenture.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.service.FibonacciService;
import com.accenture.service.impl.FibonacciServiceImpl;

public class FibonacciControllerTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@InjectMocks
	private FibonacciController fibonacciController;
	@Mock
	private FibonacciService fibonacciService = new FibonacciServiceImpl();

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(fibonacciController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	// length=1
	public void testFibonacciControllerLengthEqualToOne() throws Exception {
		List<Long> fiboList = new ArrayList<>();
		fiboList.add((long) 0);
		when(fibonacciService.fibonacci(1)).thenReturn(fiboList);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/FibonacciController").param("fibonaccilength", "1"))
				.andExpect(MockMvcResultMatchers.view().name("fibonacciResult")).andReturn();
		assertEquals(fiboList.toString(), mvcResult.getModelAndView().getModel().get("fibolist").toString());

	}

	@Test
	// length=2
	public void testFibonacciControllerLengthEqualToTwo() throws Exception {

		List<Long> fiboList = new ArrayList<>();
		fiboList.add((long) 0);
		fiboList.add((long) 1);
		when(fibonacciService.fibonacci(2)).thenReturn(fiboList);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/FibonacciController").param("fibonaccilength", "2"))
				.andExpect(MockMvcResultMatchers.view().name("fibonacciResult")).andReturn();
		assertEquals(fiboList.toString(), mvcResult.getModelAndView().getModel().get("fibolist").toString());

	}

	@Test
	// length=3
	public void testFibonacciControllerLengthEqualToThree() throws Exception {

		List<Long> fiboList = new ArrayList<>();
		fiboList.add((long) 0);
		fiboList.add((long) 1);
		fiboList.add((long) 1);
		when(fibonacciService.fibonacci(3)).thenReturn(fiboList);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/FibonacciController").param("fibonaccilength", "3"))
				.andExpect(MockMvcResultMatchers.view().name("fibonacciResult")).andReturn();
		assertEquals(fiboList.toString(), mvcResult.getModelAndView().getModel().get("fibolist").toString());

	}

	@Test
	// length=-1
	public void testFibonacciControllerLengthIsNegative() throws Exception {

		when(fibonacciService.fibonacci(-1))
				.thenThrow(new IllegalArgumentException("The length of the sequence should be greater than  0"));
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get("/FibonacciController").param("fibonaccilength", "-1"))
				.andExpect(MockMvcResultMatchers.view().name("fibonacciResult")).andReturn();
		assertEquals("The length of the sequence should be greater than  0",
				mvcResult.getModelAndView().getModel().get("errorInfo").toString());

	}
}
