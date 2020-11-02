package com.test.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.example.demo.entities.CustomerEntity;
import com.test.example.demo.repositories.CustomerRepositories;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepositories customerRepositories;

	@Nested
	@DisplayName("Tests class for Find by first name")
	@TestInstance(Lifecycle.PER_CLASS)
	class CustomerFirstName {
		@BeforeEach
		public void setUp() {
			CustomerEntity customerEntity = CustomerEntity.builder().firstName("TestFirstName").lastName("TestLastName")
					.sin("1234LMLN8907").build();
			customerRepositories.save(customerEntity);
		}

		@Test
		@DisplayName("Test for Find By First Name")
		public void testFindByFirstName_successful() {
			CustomerEntity customer = customerRepositories.findByFirstName("TestFirstName")
					.orElse(CustomerEntity.builder().build());
			Assertions.assertAll(() -> {
				assertEquals("TestFirstName", customer.getFirstName());
				assertEquals("TestLastName", customer.getLastName());
				assertEquals("1234LMLN8907", customer.getSin());
				assertNotEquals(0, customer.getCustId());
			});
		}

		@Test
		@DisplayName("Test for Find By First Name with empty result")
		public void testFindByFirstName_emptyResult() {
			CustomerEntity customer = customerRepositories.findByFirstName("RANDOMNAME")
					.orElse(CustomerEntity.builder().build());
			Assertions.assertAll(() -> {
				assertEquals(0, customer.getCustId());
				assertNull(customer.getFirstName());
				assertNull(customer.getLastName());
				assertNull(customer.getSin());
			});
		}
	}

}
