package com.example.student_information_system.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.Course;
import com.example.student_information_system.domain.Teacher;
import com.example.student_information_system.repository.teacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

	private final teacherRepository teacherRepository;
	private final CourseService courseService;

	public List<Teacher> getteachers() {
		return teacherRepository.findAll();
	}

	
	public Teacher create(Teacher teacher) {
		Optional<Teacher> teacherByEmail = teacherRepository
				.findTeacherByEmail(teacher.getEmail());
		if (teacherByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}			
		
		return teacherRepository.save(teacher);
	}
	

	public void delete(Long teacherId) {
		boolean exists = teacherRepository.existsById(teacherId);
		if (!exists) {
			throw new IllegalStateException();
		}
		teacherRepository.deleteById(teacherId);
	}

	public void createCourse(Course course) {
		courseService.create(course);
	}
}