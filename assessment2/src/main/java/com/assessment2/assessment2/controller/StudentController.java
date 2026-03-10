package com.assessment2.assessment2.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assessment2.assessment2.entity.Student;
import com.assessment2.assessment2.service.StudentService;


@RestController
public class StudentController {
	 @Autowired
	    private StudentService studentService;

	    @PreAuthorize("hasRole('ADMIN')")
	    @PostMapping
	    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	        return ResponseEntity.ok(studentService.saveStudent(student));
	    }

	    @PreAuthorize("hasAnyRole('ADMIN','USER')")
	    @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudent(@PathVariable int id) {
	        return ResponseEntity.ok(studentService.getStudentById(id));
	    }

	    @PreAuthorize("hasAnyRole('ADMIN','USER')")
	    @GetMapping
	    public ResponseEntity<List<Student>> getAllStudents(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "id") String sortBy) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
	        return ResponseEntity.ok(studentService.getAllStudents(pageable));
	    }

	    @PreAuthorize("hasRole('ADMIN')")
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
	        studentService.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }

	    @PostMapping("/{id}/uploadProfile")
	    public ResponseEntity<String> uploadProfileImage(@PathVariable int id,
	            @RequestParam("file") MultipartFile file) throws IOException {
	        Student student = studentService.getStudentById(id);
	        student.setProfileImage(file.getBytes());
	        studentService.saveStudent(student);
	        return ResponseEntity.ok("Profile image uploaded successfully");
	    }

	    @GetMapping("/{id}/downloadProfile")
	    public ResponseEntity<byte[]> downloadProfileImage(@PathVariable int id) {
	        Student student = studentService.getStudentById(id);
	        return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=profile.png")
	                .body(student.getProfileImage());
	    }
	
}