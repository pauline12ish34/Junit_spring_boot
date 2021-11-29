package rw.ac.rca.smsJunit.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



//@WebMvcTest(HelloWord.class)
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@WebMvcTest(HelloWord.class)
public class HelloWorldTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
		.get("/hello-world")
		.accept(MediaType.APPLICATION_JSON);
		
		 MvcResult result = mockMvc
				.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("hello world you pauline"))
				.andReturn();
		
		//verify "Hello world"
	assertEquals("hello world you pauline", result.getResponse().getContentAsString());
	}
}

