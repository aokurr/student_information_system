package com.example.student_information_system.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.student;
import com.example.student_information_system.repository.courseRepository;
import com.example.student_information_system.repository.studentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class studentService {
	
	
	private final studentRepository studentRepository;
	private final courseRepository courseRepository;
	public List<student> getStudents(){
		
		return studentRepository.findAll();
	}

    public void addNewStudent(student student) {
		Optional <student> studentByEmail  = studentRepository		
				.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()){
			throw new IllegalStateException("email taken");
		}

		studentRepository.save(student);
    }
	
    public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		if(!exists){
			throw new IllegalStateException();
		}
		studentRepository.deleteById(studentId);
    }
	@Transactional
    public void addCourse(Long id,String courseCode) {
		student student = studentRepository.findById(id).orElseThrow(()->new IllegalStateException("student with id" + "does not exist"));
		student.getCourses().add(courseRepository.findCourseByCourseCode(courseCode).get());
		//return new ResponseEntity<>(HttpStatus.OK);
    }

	

	
}
