package com.test.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = {"prod","staging"})
public class DemoService implements DemoIntf {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@Override
	public String getMessage() {
		return welcomeMessage;	
	}
}
