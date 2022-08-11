package com.example.student_information_system.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_information_system.domain.course;

public interface courseRepository extends JpaRepository<course,Long>{
    Optional <course> findCourseByCourseCode(String email);
}
