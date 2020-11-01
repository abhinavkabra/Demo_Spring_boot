package com.test.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Table(name = "Customer")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;

	private String firstName;

	private String lastName;

	private String sin;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private final List<TransactionEntity> transactionEntities = new ArrayList<>();

	public void addTransaction(TransactionEntity transaction) {
		transactionEntities.add(transaction);
		transaction.setCustomer(this);
	}

	public void removeTransaction(TransactionEntity transaction) {
		transactionEntities.remove(transaction);
		transaction.setCustomer(null);
	}

}
