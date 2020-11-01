package com.test.example.demo.supplier;

import java.util.function.Supplier;

import com.test.example.demo.entities.CustomerEntity;
import com.test.example.demo.model.Customer;
import com.test.example.demo.model.Transaction;

public class CustomerSuppliers {

	public static Supplier<Customer> customer = () -> Customer.builder().firstName("JOHN").lastName("MATHEW")
			.sin("123jdfh38478").build();
	public static Supplier<Customer> customerSaved = () -> Customer.builder().custId(12345).firstName("JOHN")
			.lastName("MATHEW").sin("123jdfh38478").build();

	public static Supplier<CustomerEntity> customerEntity = () -> CustomerEntity.builder().firstName("JOHN")
			.lastName("MATHEW").sin("123jdfh38478").build();

	public static Supplier<Transaction> transaction = () -> Transaction.builder().type("SAVING").amount(12345.55)
			.build();

}
