package com.example.student_information_system.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
public class student {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
        
}
