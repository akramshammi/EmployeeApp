package com.employeeApp.employeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeApp.employeeApp.entity.Company;
import com.employeeApp.employeeApp.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService cs;
	
	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
		Company comp = cs.saveCompany(company);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(comp);
	}
	
	@PostMapping("/company2")
	public ResponseEntity<Company> saveCompMapWithEmp(@RequestBody Company company) {
		
		Company comp = cs.saveCompanyAndMapWithEmp(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(comp);
	}
	
//	@PostMapping("/company")
//	public String saveComp(@RequestBody Company company) {
//		
//		cs.saveCompany(company);
//		return "saved";
//	}
//	
//	@PostMapping("/company2")
//	public String saveCompMappedByEmployee(@RequestBody Company company) {
//		
//		cs.saveCompanyAndMapWithEmp(company);
//		return "saved";
//	}
	@GetMapping("/data/{num1}/{num2}")
	public String divide(@PathVariable int num1, @PathVariable int num2) {
		return "Res:" +num1/num2;
	}
	@GetMapping("/company/find{id}")
	public String findEmp(@PathVariable int id) {
		return "company: "+cs.findCompById(id);
	}

}