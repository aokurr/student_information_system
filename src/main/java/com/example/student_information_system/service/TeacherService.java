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

import com.example.student_information_system.domain.Course;
import com.example.student_information_system.domain.Teacher;
import com.example.student_information_system.repository.teacherRepository;
import com.example.student_information_system.requests.UserRequest;
import com.example.student_information_system.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

	private final teacherRepository teacherRepository;
	private final CourseService courseService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;

	public List<Teacher> getteachers() {
		return teacherRepository.findAll();
	}

	
	public ResponseEntity<String>  addNewTeacher(Teacher teacher) {
		Optional<Teacher> teacherByEmail = teacherRepository
				.findTeacherByEmail(teacher.getEmail());
		if (teacherByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		teacher.setPassword(passwordEncoder.encode(teacher.getPassword()));
		
		log.info("teacher {} added",teacher.getName());
		
		teacherRepository.save(teacher);
		
		return new ResponseEntity<>("User Succesfully registered", HttpStatus.CREATED);
	}
	public String login(UserRequest loginRequest) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword());
		
		Authentication auth = authenticationManager.authenticate(authToken);
		
		//SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwtToken = jwtTokenProvider.generateJwtToken(auth);
		return "Bearer "+ jwtToken;
	}
	

	public void deleteteacher(Long teacherId) {
		boolean exists = teacherRepository.existsById(teacherId);
		if (!exists) {
			throw new IllegalStateException();
		}
		teacherRepository.deleteById(teacherId);
	}

	public void addNewCourse(Course course) {
		courseService.addNewCourse(course);
	}
	/*public void addNewCourse(Course course,long teacherId) {
		if(!teacherRepository.findById(teacherId).isPresent())
			throw new IllegalStateException();
		
		courseService.addNewCourse(course);
	}*/
	//spring rexes araştır
	//database i dockerle kurup dockerla databese bağlanma
}
