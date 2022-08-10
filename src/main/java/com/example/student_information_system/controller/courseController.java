package com.example.student_information_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_information_system.domain.course;
import com.example.student_information_system.service.courseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/courses")
@RequiredArgsConstructor
public class courseController {

    private final courseService courseService;
    @GetMapping
    public List<course> getCourses() {
        return null;
    }

    @PostMapping
    public void registerNewCourse(@RequestBody course course) {
        courseService.addNewCourse(course);
    }

    @DeleteMapping("/{course}")
    public void deleteCourse(@PathVariable("courseId") Long courseId) {
        courseService.deleteCourse(courseId);
    }
}
