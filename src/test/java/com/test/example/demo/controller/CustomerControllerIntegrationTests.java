package com.test.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.example.demo.entities.CustomerEntity;
import com.test.example.demo.model.Customer;
import com.test.example.demo.repositories.CustomerRepositories;
import com.test.example.demo.service.customer.CustomerService;
import com.test.example.demo.supplier.CustomerSuppliers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class CustomerControllerIntegrationTests {

	private static Customer customer = CustomerSuppliers.customer.get();

	private static Customer customerSaved = CustomerSuppliers.customerSaved.get();
	
	private static CustomerEntity customerEntity = CustomerSuppliers.customerEntity.get();

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	MockMvc mockMvc;

	@Autowired
	CustomerService customerService;

	@Autowired
	CustomerRepositories customerRepo;

	@Test
	public void addCustomer_200OK() throws JsonProcessingException, Exception {
		MvcResult results = mockMvc
				.perform(post("/v1/customer/").contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(customer)))
				.andExpect(status().isCreated()).andReturn();
		Customer readValue = objectMapper.readValue(results.getResponse().getContentAsString(), Customer.class);
		Assertions.assertAll(() -> {
			assertNotNull(customerSaved.getCustId());
			assertEquals(customerSaved.getFirstName(), readValue.getFirstName());
			assertEquals(customerSaved.getLastName(), readValue.getLastName());
			assertEquals(customerSaved.getSin(), readValue.getSin());
		});
	}
	
	@Test
	public void getCustomer_200OK() throws JsonProcessingException, Exception {
		int custId = customerRepo.save(customerEntity).getCustId();
		MvcResult results = mockMvc
				.perform(get("/v1/customer/{id}",String.valueOf(custId)).contentType(MediaType.APPLICATION_JSON_VALUE)
						.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		Customer readValue = objectMapper.readValue(results.getResponse().getContentAsString(), Customer.class);
		Assertions.assertAll(() -> {
			assertNotNull(customerSaved.getCustId());
			assertEquals(customerSaved.getFirstName(), readValue.getFirstName());
			assertEquals(customerSaved.getLastName(), readValue.getLastName());
			assertEquals(customerSaved.getSin(), readValue.getSin());
		});
	}
}
