package com.assessment2.assessment2.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.assessment2.assessment2.entity.Student;
import com.assessment2.assessment2.repository.StudentRepository;



@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Cacheable("students")
    public Student getStudentById(int id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getAllStudents(Pageable pageable) {
        return studentRepo.findAll(pageable).getContent();
    }

    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }
}