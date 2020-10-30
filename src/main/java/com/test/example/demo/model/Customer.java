package com.test.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

	private int custId;

	private String firstName;

	private String lastName;

	private String sin;

}
