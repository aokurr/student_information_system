package com.example.student_information_system.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.Course;
import com.example.student_information_system.domain.Teacher;
import com.example.student_information_system.repository.teacherRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

	private final teacherRepository teacherRepository;
	private final CourseService courseService;

	public List<Teacher> getteachers() {
		return teacherRepository.findAll();
	}

	public void addNewTeacher(Teacher teacher) {
		Optional<Teacher> teacherByEmail = teacherRepository
				.findTeacherByEmail(teacher.getEmail());
		if (teacherByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		log.info("teacher {} added",teacher.getName());
		teacherRepository.save(teacher);
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
