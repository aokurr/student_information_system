
package com.example.student_information_system.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_information_system.domain.Course;
import com.example.student_information_system.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return ResponseEntity.ok(courseService.getCourses());
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.create(course));
    }

    @DeleteMapping("/{course}")
    public void delete(@PathVariable("courseId") Long courseId) {
        courseService.delete(courseId);
    }

    @PutMapping
    public void changeCourse(String courseCode) {
        courseService.updateClassCapacity(courseCode);
    }
}