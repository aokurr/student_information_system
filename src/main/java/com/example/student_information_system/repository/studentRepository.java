package com.example.student_information_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_information_system.domain.student;

public interface studentRepository extends JpaRepository<student,Long>{
    Optional <student> findStudentByEmail(String email);
}
