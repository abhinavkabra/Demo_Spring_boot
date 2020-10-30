package com.test.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

	private int id;

	private String type;

	private double amount;

	@JsonIgnore
	private Customer customer;
}
