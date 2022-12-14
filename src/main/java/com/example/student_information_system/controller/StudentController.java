package com.example.student_information_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_information_system.domain.Student;
import com.example.student_information_system.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/students")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;
  
	@PostMapping
	public ResponseEntity<String> create(@RequestBody Student student) {
		return studentService.create(student);	
	}

  @GetMapping
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

  @GetMapping("/{id}")
  public Student getStudent(@PathVariable Long id) {
    return studentService.getStudentById(id);
  }

  @PutMapping("/{id}")
  public void enrollCourse(@PathVariable Long id, @RequestBody String courseCode) {
    studentService.addCourse(id, courseCode);
  }

}