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
		com.test.example.demo.entities.CustomerEntity convertValue = objectMapper.convertValue(customer,
				com.test.example.demo.entities.CustomerEntity.class);
		com.test.example.demo.entities.CustomerEntity save = customerRepositories.save(convertValue);
		return objectMapper.convertValue(save, Customer.class);
	}

	public Customer getCustomer(int id) {
		return customerRepositories.findById(id).map(e -> objectMapper.convertValue(e, Customer.class))
				.orElse(Customer.builder().build());
	}

	public void deleteById(int id) {
		customerRepositories.deleteById(id);
	}

}
