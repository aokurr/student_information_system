package com.example.student_information_system.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.course;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class courseService {
	
	
	private final courseRepository courseRepository;
	public List<course> getStudents(){
		
		return courseRepository.findAll();
	}

    public void addNewCourse(course course) {
		Optional <course> courseByEmail  = courseRepository		
				.findCourseByEmail(course.getEmail());
		if(courseByEmail.isPresent()){
			throw new IllegalStateException("email taken");
		}

		courseRepository.save(course);
    }
	
    public void deleteCourse(Long courseId) {
		boolean exists=courseRepository.existsById(courseId);
		if(!exists){
			throw new IllegalStateException();
		}
		courseRepository.deleteById(courseId);
    }


	

	
}
