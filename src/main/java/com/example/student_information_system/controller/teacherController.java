package com.example.student_information_system.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_information_system.domain.teacher;
import com.example.student_information_system.service.teacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/teacher")
@RequiredArgsConstructor
public class teacherController {

  private final teacherService teacherService;

  @GetMapping
  public List<teacher> getteachers() {
    return null;
  }

  @PostMapping
  public void registerNewteacher(@RequestBody teacher teacher) {
    teacherService.addNewteacher(teacher);
  }

  @DeleteMapping("/{teacherId}")
  public void deleteteacher(@PathVariable("teacherId") Long teacherId) {
    teacherService.deleteteacher(teacherId);
  }
}
