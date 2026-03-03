package com.employeeApp.employeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeApp.employeeApp.entity.Company;
import com.employeeApp.employeeApp.exception.CompanyIdNotFoundException;
import com.employeeApp.employeeApp.repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository cr;
	
	
	public Company saveCompany(Company company) {
		 return cr.save(company);
	}
	
	public Company saveCompanyAndMapWithEmp(Company company) {
		company.getEmployee().forEach((emp) ->emp.setCompany(company));
		return cr.save(company);
	}
	public Company findCompById(int id) {
		return cr.findById(id).orElseThrow(() -> new CompanyIdNotFoundException("Company "+id+" is not available"));
	}
	
}