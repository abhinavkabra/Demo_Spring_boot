package com.test.example.demo.service.customer;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.example.demo.model.Customer;
import com.test.example.demo.repositories.CustomerRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepositories customerRepositories;

	private final ObjectMapper objectMapper;

	public Customer addCustomer(Customer customer) {
		com.test.example.demo.entities.Customer convertValue = objectMapper.convertValue(customer,
				com.test.example.demo.entities.Customer.class);
		com.test.example.demo.entities.Customer save = customerRepositories.save(convertValue);
		return objectMapper.convertValue(save, Customer.class);
	}

}
