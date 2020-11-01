package com.test.example.demo.service.customer;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.example.demo.entities.CustomerEntity;
import com.test.example.demo.entities.TransactionEntity;
import com.test.example.demo.model.Customer;
import com.test.example.demo.model.Transaction;
import com.test.example.demo.repositories.CustomerRepositories;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerRepositories customerRepositories;

	private final ObjectMapper objectMapper;

	public Customer addCustomer(Customer customer) {
		CustomerEntity convertValue = objectMapper.convertValue(customer, CustomerEntity.class);
		customer.getTransactions().stream()
				.forEach(e -> convertValue.addTransaction(objectMapper.convertValue(e, TransactionEntity.class)));
		CustomerEntity save = customerRepositories.save(convertValue);
		Customer convertValue2 = objectMapper.convertValue(save, Customer.class);
		save.getTransactionEntities()
				.forEach(e -> convertValue2.addTransaction(objectMapper.convertValue(e, Transaction.class)));
		return convertValue2;
	}

	public Customer getCustomer(int id) {
		return customerRepositories.findById(id).map(e -> objectMapper.convertValue(e, Customer.class))
				.orElse(Customer.builder().build());
	}

	public void deleteById(int id) {
		customerRepositories.findById(id).ifPresent(e -> customerRepositories.delete(e));
	}

}
