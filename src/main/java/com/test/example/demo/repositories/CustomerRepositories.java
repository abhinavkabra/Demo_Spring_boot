package com.test.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.example.demo.entities.Customer;

@Repository
public interface CustomerRepositories extends JpaRepository<Customer, Integer> {

}
