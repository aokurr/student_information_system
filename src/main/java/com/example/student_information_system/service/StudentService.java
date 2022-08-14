package com.example.student_information_system.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.Student;
import com.example.student_information_system.repository.studentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	private final studentRepository studentRepository;
	private final CourseService courseService;

	public List<Student> getStudents() {

		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("student not found"));
	}

	//authentication şirfreleme nasıl kripto halde tutulor 
	//jwt bak 
	public void addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository
				.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}

		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException();
		}
		studentRepository.deleteById(studentId);
	}

	
	public void addCourse(Long id, String courseCode) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("student with id" + "does not exist"));
		
		student.getCourses().add(courseService.getCourse(courseCode));
		courseService.updateClassCapacity(courseCode);

		studentRepository.save(student);
		
	}

}
