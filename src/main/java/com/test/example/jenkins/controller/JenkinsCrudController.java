package com.test.example.jenkins.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.example.jenkins.model.User;
import com.test.example.jenkins.service.JenkinsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class JenkinsCrudController {

	private JenkinsService jenkinsService;
	
	@GetMapping("/")
	public String helloJenkins() {
		return jenkinsService.getMessage();
	}
	
	@PostMapping("/")
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody User jenkinsUser(@RequestBody User user) {
		return jenkinsService.addUser(user);
	}
	
}
