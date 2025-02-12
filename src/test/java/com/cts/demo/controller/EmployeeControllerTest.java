package com.cts.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cts.demo.model.Employee;
import com.cts.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value=EmployeeController.class)//class under Test
public class EmployeeControllerTest {
	
	@MockBean   //to mock employee service 
	private EmployeeService empService;
	
	@Autowired
	private MockMvc mockMvc;
	//used to send request to REST API
	
	@Test //used to represent it as a test method
	public void testWelcomeMessage() throws Exception {
		//returns a dummy value when welcome method is called
		when(empService.Welcome()).thenReturn("Welcome");
		
		//prepare the request
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/test");
		
		ResultActions perform = mockMvc.perform(reqBuilder);//send request
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response= mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		//assertEquals("Welcome",response.toString());
	}
	@Test //used to represent it as a test method
	public void testWelcomeMessage3() throws Exception {
		//returns a dummy value when welcome method is called
		when(empService.Welcome()).thenReturn("Welcome");
		
		//prepare the request
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/test");
		
		ResultActions perform = mockMvc.perform(reqBuilder);//send request
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response= mvcResult.getResponse();
		String str = response.getContentAsString();
		assertEquals("Welcome",str);
	}
	
	@Test
	public void testPostEmployee() throws Exception {
		Employee emp = new Employee("Manimaran",24,25000,"Male");
		when(empService.addEmployee(ArgumentMatchers.any())).thenReturn(emp);
		
		ObjectMapper mapper = new ObjectMapper();
		String empJson = mapper.writeValueAsString(emp);
		
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.post("/")
				.contentType(MediaType.APPLICATION_JSON) // json request type
				.content(empJson); // requestbody 
		
		ResultActions perform = mockMvc.perform(reqBuilder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		//String str = response.getContentAsString();
		assertEquals(200,response.getStatus()); 
	}
	
        
}
