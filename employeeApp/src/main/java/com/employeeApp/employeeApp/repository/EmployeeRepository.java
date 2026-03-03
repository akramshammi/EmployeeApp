package com.employeeApp.employeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeApp.employeeApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
