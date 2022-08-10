package com.example.student_information_system.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student_information_system.domain.teacher;

public interface teacherRepository extends JpaRepository<teacher,Long>{
    Optional <teacher> findteacherByEmail(String email);
}