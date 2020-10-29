package com.test.example.demo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = {"!prod","!staging"})
public class DemoServiceDefault implements DemoIntf {

	@Override
	public String getMessage() {
		return "Hi I am from Default profile";
	}

}
