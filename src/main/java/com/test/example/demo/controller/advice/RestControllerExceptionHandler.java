package com.test.example.demo.controller.advice;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

	
	
}
