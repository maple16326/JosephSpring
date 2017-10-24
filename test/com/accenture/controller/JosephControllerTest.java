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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.business.JosephBusiness;
import com.accenture.business.impl.JosephBusninessImpl;
import com.accenture.dto.Circle;
import com.accenture.dto.Error;
import com.accenture.dto.JosephProblemRequest;
import com.accenture.dto.JosephProblemResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RunWith(MockitoJUnitRunner.class)
public class JosephControllerTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();	
	@InjectMocks
	private JosephController josephController;
	@Mock
	private JosephBusiness josephBusniness=new JosephBusninessImpl();
	
	private MockMvc mockMvc;
	@Before
	public void setUp() throws Exception {
		
		mockMvc = MockMvcBuilders.standaloneSetup(josephController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testJosephController() throws Exception {
		
		String josephRequestJsonStr = "{\"circle\":{\"start\":\"1\",\"interval\":\"2\",\"persons\":[\"a\",\"b\",\"c\",\"d\"]}}";
		JosephProblemResponse josephProblemResponse=new JosephProblemResponse();
		josephProblemResponse.setErrors(null);
		josephProblemResponse.setPerson("a");
		when(josephBusniness.doJosephCalcu(Mockito.any(JosephProblemRequest.class))).thenReturn(josephProblemResponse);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/Josephcontroller").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(josephRequestJsonStr)).andReturn();
	
		Gson gson = new GsonBuilder()
			    .disableHtmlEscaping().serializeNulls().create(); 
		assertEquals(gson.toJson(josephProblemResponse).toString(), mvcResult.getResponse().getContentAsString());
	}
	@Test
	//persons=null
	public void testJosephControllerPersonsIsNull() throws Exception {
		
		String josephRequestJsonStr = "{\"circle\":{\"start\":\"1\",\"interval\":\"2\",\"persons\":null}}";
		JosephProblemResponse josephProblemResponse=new JosephProblemResponse();

		when(josephBusniness.doJosephCalcu(Mockito.any(JosephProblemRequest.class))).thenReturn(josephProblemResponse);	
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/Josephcontroller").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(josephRequestJsonStr)).andReturn();
		String mvcResultStr=mvcResult.getResponse().getContentAsString();
		Gson gson = new GsonBuilder()
			    .disableHtmlEscaping().serializeNulls().create(); 
		josephProblemResponse=gson.fromJson(mvcResultStr, JosephProblemResponse.class);
		List<Error>errors=josephProblemResponse.getErrors();
		String person=josephProblemResponse.getPerson();
		assertEquals(person, null);
		for(Error error:errors){
			assertEquals(errors.get(0).getField(),"circle.persons" );
			assertEquals(errors.get(0).getMessage(),"{value.illegal.empty}" );
		}
		
	}
	@Test
	//start=null
	public void testJosephControllerStartIsNull() throws Exception {
		
		String josephRequestJsonStr = "{\"circle\":{\"start\":null,\"interval\":\"2\",\"persons\":[\"a\",\"b\",\"c\",\"d\"]}}";
		JosephProblemResponse josephProblemResponse=new JosephProblemResponse();

		when(josephBusniness.doJosephCalcu(Mockito.any(JosephProblemRequest.class))).thenReturn(josephProblemResponse);	
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/Josephcontroller").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(josephRequestJsonStr)).andReturn();
		String mvcResultStr=mvcResult.getResponse().getContentAsString();
		Gson gson = new GsonBuilder()
			    .disableHtmlEscaping().serializeNulls().create(); 
		josephProblemResponse=gson.fromJson(mvcResultStr, JosephProblemResponse.class);
		List<Error>errors=josephProblemResponse.getErrors();
		String person=josephProblemResponse.getPerson();
		assertEquals(person, null);
		for(Error error:errors){
			assertEquals(errors.get(0).getField(),"circle.start" );
			assertEquals(errors.get(0).getMessage(),"{value.illegal.null}" );
		}
		
	}
	@Test
	//interval=null
	public void testJosephControllerIntervalIsNull() throws Exception {
		
		String josephRequestJsonStr = "{\"circle\":{\"start\":\"1\",\"interval\":null,\"persons\":[\"a\",\"b\",\"c\",\"d\"]}}";
		JosephProblemResponse josephProblemResponse=new JosephProblemResponse();
		when(josephBusniness.doJosephCalcu(Mockito.any(JosephProblemRequest.class))).thenReturn(josephProblemResponse);	
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/Josephcontroller").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(josephRequestJsonStr)).andReturn();
		String mvcResultStr=mvcResult.getResponse().getContentAsString();
		Gson gson = new GsonBuilder()
			    .disableHtmlEscaping().serializeNulls().create(); 
		josephProblemResponse=gson.fromJson(mvcResultStr, JosephProblemResponse.class);
		List<Error>errors=josephProblemResponse.getErrors();
		String person=josephProblemResponse.getPerson();
		assertEquals(person, null);
		for(Error error:errors){
			assertEquals(errors.get(0).getField(),"circle.interval" );
			assertEquals(errors.get(0).getMessage(),"{value.illegal.null}" );
		}
	}
	@Test
	//interval=0
	public void testJosephControllerIntervalEqualToZero() throws Exception {
		
		String josephRequestJsonStr = "{\"circle\":{\"start\":\"1\",\"interval\":\"0\",\"persons\":[\"a\",\"b\",\"c\",\"d\"]}}";
		JosephProblemResponse josephProblemResponse=new JosephProblemResponse();
		when(josephBusniness.doJosephCalcu(Mockito.any(JosephProblemRequest.class))).thenReturn(josephProblemResponse);	
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/Josephcontroller").accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON).content(josephRequestJsonStr)).andReturn();
		String mvcResultStr=mvcResult.getResponse().getContentAsString();
		Gson gson = new GsonBuilder()
			    .disableHtmlEscaping().serializeNulls().create(); 
		josephProblemResponse=gson.fromJson(mvcResultStr, JosephProblemResponse.class);
		List<Error>errors=josephProblemResponse.getErrors();
		String person=josephProblemResponse.getPerson();
		assertEquals(person, null);
		assertEquals(errors.get(0).getField(),"circle.interval" );
		assertEquals(errors.get(0).getMessage(),"{interval.illegal.minValue}" );
	}
	
}
 