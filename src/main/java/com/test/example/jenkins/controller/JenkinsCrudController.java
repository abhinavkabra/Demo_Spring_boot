package com.test.example.jenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JenkinsCrudController {

	@GetMapping("/")
	public String helloJenkins() {
		return "Hello from Jenkins";
	}
	
}
