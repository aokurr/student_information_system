package com.example.student_information_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_information_system.domain.Course;

public interface courseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findCourseByCourseCode(String courseCode);
}
