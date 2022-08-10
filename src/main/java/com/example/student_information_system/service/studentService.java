package com.example.student_information_system.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo3.student.Repository.StudentRepository;
import com.example.demo3.student.entity.Student;
import com.example.student_information_system.domain.student;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class studentService {
	
	
	private final StudentRepository studentRepository;
	public List<Student> getStudents(){
		
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


	

	
}
