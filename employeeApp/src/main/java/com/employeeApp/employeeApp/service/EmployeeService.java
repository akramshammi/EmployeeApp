package com.employeeApp.employeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeApp.employeeApp.dto.EmployeeDTO;
import com.employeeApp.employeeApp.entity.Employee;
import com.employeeApp.employeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;
	
	public Employee saveEmployee(Employee employee) {
		return er.save(employee);
	}
	
    public EmployeeDTO saveEmployee(EmployeeDTO empDTO) {
		
		Employee employee = DTOToEntity(empDTO);
		er.save(employee);
		
		return entityToDTO(employee);
	}

	
	public Employee findEmpById(int id) {
		return er.findById(id).orElse(null);
	}
	public void deleteById(int id) {
		Employee emp = findEmpById(id);
		er.delete(emp);
	}
	public EmployeeDTO entityToDTO(Employee employee) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setAge(employee.getAge());
		dto.setEmail(employee.getEmail());
		dto.setName(employee.getName());
		dto.setPhone(employee.getPhone());
		
		return dto;
	}
	
	public Employee DTOToEntity(EmployeeDTO dto) {
		Employee emp = new Employee();
		emp.setAge(dto.getAge());
		emp.setEmail(dto.getEmail());
		emp.setName(dto.getName());
		emp.setPhone(dto.getPhone());
		return emp;
	}
}
