package com.test.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.test.example.demo.model.Customer;
import com.test.example.demo.service.customer.CustomerService;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/customer")
@AllArgsConstructor
public class CustomerController {

	private final CustomerService customerService;

	@PostMapping("/")
	@ApiOperation("Add Customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer addCustomer(@RequestBody Customer customer) {
		try {
			return customerService.addCustomer(customer);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ApiOperation("Get Customer")
	@ResponseStatus(code = HttpStatus.OK)
	public Customer getCustomer(@PathVariable("id") String id) {
		try {
			return customerService.getCustomer(Integer.parseInt(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation("Delete customer based in Id")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("id") String id) {
		try {
			customerService.deleteById(Integer.parseInt(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
