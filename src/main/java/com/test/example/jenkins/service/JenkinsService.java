package com.test.example.jenkins.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.test.example.jenkins.model.User;

@Service
@Profile(value = {"prod","staging"})
public class JenkinsService {
	
	Map<Integer, User> userMap = new ConcurrentHashMap<>();
	AtomicInteger atomicInt = new AtomicInteger(0);
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	public String getMessage() {
		return welcomeMessage;	
	}

	public User addUser(User user) {
		int incrementAndGet = atomicInt.incrementAndGet();
		user.setUID(incrementAndGet);
		userMap.put(incrementAndGet, user);
		return user;
	}
}
