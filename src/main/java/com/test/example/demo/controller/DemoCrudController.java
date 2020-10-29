package com.test.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.example.demo.model.User;
import com.test.example.demo.service.DemoIntf;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class DemoCrudController {

	private DemoIntf demoIntf;
	
	@GetMapping("/")
	public String helloJenkins() {
		return demoIntf.getMessage();
	}
	
	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody User jenkinsUser(@RequestBody User user) {
		return demoIntf.addUser(user);
	}
	
}
