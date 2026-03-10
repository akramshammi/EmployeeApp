package com.assessment2.assessment2.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment2.assessment2.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}