package com.accenture.controller;

import static org.junit.Assert.*;

import org.json.JSONObject;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.accenture.business.JosephBusiness;
import com.accenture.business.impl.JosephBusninessImpl;

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
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(josephController).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws Exception {
		/*String josephRequestJsonStr = "{\"circle\":{\"start\":\"1\",\"interval\":\"2\",\"persons\":[\"a\",\"b\",\"c\",\"d\"]}}";
		JSONObject jsonObject = new JSONObject(josephRequestJsonStr);*/
		 ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/Josephcontroller").param("id", "1"));
	}

}
 