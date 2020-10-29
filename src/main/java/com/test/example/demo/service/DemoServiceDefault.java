package com.test.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceDefault implements DemoIntf {

	@Override
	public String getMessage() {
		return "Hi I am from Default profile";
	}

}
