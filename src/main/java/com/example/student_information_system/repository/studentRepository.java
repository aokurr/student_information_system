package com.example.student_information_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_information_system.domain.Student;

public interface studentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
}
