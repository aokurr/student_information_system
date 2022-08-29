package com.example.student_information_system.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.Course;
import com.example.student_information_system.repository.courseRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

	private final courseRepository courseRepository;

	public List<Course> getCourses() {

		return courseRepository.findAll();
	}

	public Course getCourse(String courseCode) {
		return courseRepository.findCourseByCourseCode(courseCode)
				.orElseThrow(() -> new RuntimeException("course not found"));
	}

	public Course create(Course course) {
		Optional<Course> courseByCourseCode = courseRepository
				.findCourseByCourseCode(course.getCourseCode());
		if (courseByCourseCode.isPresent()) {
			throw new IllegalStateException("Cours Code taken");
		}
		log.info("New course added");
		return courseRepository.save(course);
	}

	public void delete(Long courseId) {
		boolean exists = courseRepository.existsById(courseId);
		if (!exists) {
			throw new IllegalStateException();
		}
		courseRepository.deleteById(courseId);
	}

	
	public void updateClassCapacity(String courseCode){
		
		int capacity = getCourse(courseCode).getClassCapacity();
		
		if(capacity>120){
			throw new IllegalStateException();
		}
		
		Course course=getCourse(courseCode);
		
		course.setClassCapacity(capacity+1);
		log.info("Class capacity has been increased");
		courseRepository.save(course);

	}
}