package com.example.student_information_system.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    
    @NotBlank
    @Column(name = "courseTitle") 
    private String courseTitle;

    @NotBlank
    @Column(name = "courseCode")
    private String courseCode;
    
    @NotBlank
    @Column(name = "semester")
    private int semester;

    @NotBlank
    @Column(name = "credits")
    private int credits;
    
    @NotBlank
    @Column(name = "classCapacity")
    private int classCapacity;
    
    @NotBlank
    @Column(name = "lecturer")
    private String lecturer;
    
    @ManyToMany
    Set<Student> likes=new HashSet<Student>();

}