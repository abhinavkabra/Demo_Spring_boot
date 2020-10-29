package com.test.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class DemoCrudControllerIntegrationTests {

	@Autowired
	MockMvc mockMvc;
	
	
	@DisplayName("Welcome message from default profile")
	@Test
	public void testWelcomeMessage() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/")).andReturn();
		assertThat(mvcResult.getResponse().getContentAsString()).isEqualToIgnoringCase("Hi I am from Default profile");
	}
	
}
