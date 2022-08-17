package com.example.student_information_system.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.student_information_system.domain.Student;
import com.example.student_information_system.repository.studentRepository;
import com.example.student_information_system.security.JwtUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private studentRepository studentRepository;
	
    public UserDetailsServiceImpl(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student = studentRepository.findStudentByEmail(username).get();
		
        return JwtUserDetails.create(student);
	}
	
	public UserDetails loadUserById(Long id) {
		Student student = studentRepository.findById(id).get();
		return JwtUserDetails.create(student); 
	}

}