package com.example.student_information_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_information_system.domain.Course;
import com.example.student_information_system.domain.Teacher;
import com.example.student_information_system.requests.UserRequest;
import com.example.student_information_system.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/teachers")
@RequiredArgsConstructor
public class TeacherController {

  private final TeacherService teacherService;

  @GetMapping
  public List<Teacher> getteachers() {
    return null;
  }

  @PostMapping("/auth/login")
	public String login(@RequestBody UserRequest loginRequest){
    return teacherService.login(loginRequest);
	}
	
	@PostMapping("/auth/register")
	public ResponseEntity<String> register(@RequestBody Teacher teacher) {
		return teacherService.addNewTeacher(teacher);
	}

  @DeleteMapping("/{teacherId}")
  public void deleteteacher(@PathVariable("teacherId") Long teacherId) {
    teacherService.deleteteacher(teacherId);
  }

  @PostMapping("/createCourse")
  public void createCourse(@RequestBody Course course) {
    teacherService.addNewCourse(course);
  }
  

  /*@PostMapping("/{teacherId}/createCourse")
  public void createCourse(@RequestBody Course course,@PathVariable("teacherId") Long teacherId) {
    teacherService.addNewCourse(course,teacherId);
  }*/
}
