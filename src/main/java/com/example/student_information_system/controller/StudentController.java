package com.example.student_information_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_information_system.domain.student;
import com.example.student_information_system.service.studentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/students")
@RequiredArgsConstructor
public class StudentController {
	
	private final studentService studentService;
		
	@GetMapping
	public List<student> getStudents(){
		return null;
    }
   
    @PostMapping
    public void registerNewStudent(@RequestBody student student){
		studentService.addNewStudent(student);
    }
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
		studentService.deleteStudent(studentId);
    }
}
