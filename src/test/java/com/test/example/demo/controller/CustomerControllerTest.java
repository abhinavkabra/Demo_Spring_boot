package com.test.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.example.demo.model.Customer;
import com.test.example.demo.service.customer.CustomerService;

@AutoConfigureWebMvc
@WebMvcTest(controllers = CustomerController.class)
@ExtendWith(SpringExtension.class)
public class CustomerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@MockBean
	CustomerService customerService;

	private static Customer customer;

	private static Customer customerSaved;

	@BeforeAll
	public static void setUp() {
		customer = Customer.builder().firstName("JOHN").lastName("MATHEW").sin("123jdfh38478").build();
		customerSaved = Customer.builder().custId(12345).firstName("JOHN").lastName("MATHEW").sin("123jdfh38478")
				.build();
	}

	@Nested
	@DisplayName("Test suite for all Add Customer scenarios")
	class AddCustomer {

		@BeforeEach
		public void reset() {
			Mockito.reset(customerService);
		}

		@DisplayName("Given a valid User Object is passed to Add Cusomer API, It will successfully Add it")
		@Test
		public void testAddCustomer_201() throws JsonProcessingException, Exception {
			when(customerService.addCustomer(customer)).thenReturn(customerSaved);
			MvcResult results = mockMvc
					.perform(post("/v1/customer/").contentType(MediaType.APPLICATION_JSON_VALUE)
							.content(objectMapper.writeValueAsString(customer)))
					.andExpect(status().isCreated()).andReturn();
			Customer readValue = objectMapper.readValue(results.getResponse().getContentAsString(), Customer.class);
			verify(customerService).addCustomer(customer);
			Assertions.assertAll(() -> {
				assertEquals(customerSaved.getCustId(), readValue.getCustId());
				assertEquals(customerSaved.getFirstName(), readValue.getFirstName());
				assertEquals(customerSaved.getLastName(), readValue.getLastName());
				assertEquals(customerSaved.getSin(), readValue.getSin());
			});
		}

		@Test
		public void testAddCustomer_500() throws JsonProcessingException, Exception {
			doThrow(new NullPointerException()).when(customerService).addCustomer(customer);
			mockMvc.perform(post("/v1/customer/").contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(objectMapper.writeValueAsString(customer))).andExpect(status().is5xxServerError());
			verify(customerService).addCustomer(customer);
		}
	}

}