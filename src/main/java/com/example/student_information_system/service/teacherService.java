package com.example.student_information_system.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.teacher;
import com.example.student_information_system.repository.teacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class teacherService {
	
	
	private final teacherRepository teacherRepository;
	public List<teacher> getteachers(){
		
		return teacherRepository.findAll();
	}

    public void addNewteacher(teacher teacher) {
		Optional <teacher> teacherByEmail  = teacherRepository		
				.findteacherByEmail(teacher.getEmail());
		if(teacherByEmail.isPresent()){
			throw new IllegalStateException("email taken");
		}

		teacherRepository.save(teacher);
    }
	
    public void deleteteacher(Long teacherId) {
		boolean exists=teacherRepository.existsById(teacherId);
		if(!exists){
			throw new IllegalStateException();
		}
		teacherRepository.deleteById(teacherId);
    }


	

	
}
