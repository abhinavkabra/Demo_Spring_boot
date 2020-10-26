package com.test.example.jenkins.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
@WebMvcTest
public class JenkinsCrudControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testJenkinsMessage() throws Exception {
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andReturn();
		assertThat(
		andReturn.getResponse().getContentAsString().equalsIgnoreCase("Hello from Jenkins"));
	}

}
