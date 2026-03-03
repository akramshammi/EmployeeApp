package com.employeeApp.employeeApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	public Map<String, String> handleArithmeticEx(ArithmeticException ex){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", ex.getMessage());
			return map;
	}
	
	@ExceptionHandler(CompanyIdNotFoundException.class)
	public Map<String, String> handleCompanyNotFoundEx(CompanyIdNotFoundException ex){
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", ex.getMessage());
			return map;
	}
	
	
}
