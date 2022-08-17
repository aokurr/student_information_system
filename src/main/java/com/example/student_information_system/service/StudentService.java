package com.example.student_information_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.student_information_system.domain.Student;
import com.example.student_information_system.repository.studentRepository;
import com.example.student_information_system.requests.UserRequest;
import com.example.student_information_system.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

	private final studentRepository studentRepository;
	private final CourseService courseService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;

	public List<Student> getStudents() {

		return studentRepository.findAll();
	}

	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("student not found"));
	}
	public Student getSudentByEmail(String email){
		log.info("geçti 1");
		if(studentRepository.findStudentByEmail(email).isPresent())
			return studentRepository.findStudentByEmail(email).get();
		log.info("geçti 2");
			return null;
	}

	public ResponseEntity<String>  addNewStudent(Student student) {
		Optional<Student> studentByEmail = studentRepository
				.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		log.info("student {} added",student.getName());
		
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		
		studentRepository.save(student);
		
		return new ResponseEntity<>("User Succesfully registered", HttpStatus.CREATED);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException();
		}
		log.info("student {} deleted",studentRepository.findById(studentId).get().getName());
		studentRepository.deleteById(studentId);
	}

	
	public void addCourse(Long id, String courseCode) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("student with id" + "does not exist"));
		
		student.getCourses().add(courseService.getCourse(courseCode));
		
		courseService.updateClassCapacity(courseCode);

		log.info("student {} added to course number {}",student.getName(),courseCode);
		studentRepository.save(student);
		
	}
	public String login(UserRequest loginRequest) {
		log.info("geçti0");
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
		log.info("geçti1");
		Authentication auth = authenticationManager.authenticate(authToken);
		log.info("geçti2");
		SecurityContextHolder.getContext().setAuthentication(auth);
		log.info("geçti3");
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		return "Bearer "+ jwtToken;
	}
}
