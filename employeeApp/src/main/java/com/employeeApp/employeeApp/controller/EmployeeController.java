package com.employeeApp.employeeApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeApp.employeeApp.dto.EmployeeDTO;
import com.employeeApp.employeeApp.entity.Employee;
import com.employeeApp.employeeApp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService es;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO>  saveEmp(@Valid @RequestBody EmployeeDTO employee) {
		return ResponseEntity.status(HttpStatus.CREATED).body(es.saveEmployee(employee));
		
	}
}