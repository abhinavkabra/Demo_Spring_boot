package com.test.example.jenkins.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.test.example.jenkins.service.JenkinsService;

@AutoConfigureMockMvc
@WebMvcTest(controllers = JenkinsCrudController.class)
public class JenkinsCrudControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	JenkinsService jenkinsService;
	
	@Test
	public void testJenkinsMessage() throws Exception {
		when(jenkinsService.getMessage()).thenReturn("Hello from Jenkins");
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andReturn();
		assertThat(
		andReturn.getResponse().getContentAsString()).isEqualToIgnoringCase("Hello from Jenkins");
	}

}
