package com.test.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@ActiveProfiles({ "prod", "staging" })
public class DemoCrudControllerProdIntegrationTests {

	@Autowired
	MockMvc mockMvc;

	@Value("${welcome.message}")
	String message;

	@DisplayName("Welcome message profile from prod profile")
	@Test
	public void testWelcomeMessageProdProfile() throws Exception {
		MvcResult results = mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andReturn();
		String contentAsString = results.getResponse().getContentAsString();
		assertThat(contentAsString).isEqualToIgnoringCase(message);
	}
}
