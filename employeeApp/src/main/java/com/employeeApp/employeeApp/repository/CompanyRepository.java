package com.employeeApp.employeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeApp.employeeApp.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
}
