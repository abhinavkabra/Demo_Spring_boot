package com.test.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.example.demo.model.User;

@ExtendWith(SpringExtension.class)
public class DemoServiceTest {

	DemoService subject;

	@BeforeEach
	public void setUp() {
		subject = new DemoService();
	}

	@Test
	public void testAddUser() {
		User user = User.builder().build();
		subject.addUser(user);
		assertThat(user.getUID()).isEqualTo(1);
	}

}
