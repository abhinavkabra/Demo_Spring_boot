package com.test.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

	private int custId;

	private String firstName;

	private String lastName;

	private String sin;

	private final List<Transaction> transactions = new ArrayList<>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
		transaction.setCustomer(this);
	}

	public void removeTransaction(Transaction transaction) {
		transactions.remove(transaction);
		transaction.setCustomer(null);
	}

}
