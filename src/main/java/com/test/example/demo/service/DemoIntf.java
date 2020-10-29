package com.test.example.demo.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.test.example.demo.model.User;

public interface DemoIntf {

	Map<Integer, User> userMap = new ConcurrentHashMap<>();
	AtomicInteger atomicInt = new AtomicInteger(0);

	default User addUser(User user) {
		int incrementAndGet = atomicInt.incrementAndGet();
		user.setUID(incrementAndGet);
		userMap.put(incrementAndGet, user);
		return user;
	}

	String getMessage();
}
