package com.example.student_information_system.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    
    @Min(1)
    @Max(2)
    @Column(name = "semester")
    private int semester;

    @Min(1)
    @Max(8)
    @Column(name = "credits")
    private int credits;
    
    @Min(30)
    @Max(120)
    @Column(name = "classCapacity")
    private int classCapacity;
    
    @NotBlank
    @Column(name = "lecturer")
    private String lecturer;
    
    @ManyToMany
    Set<Student> likes=new HashSet<Student>();

}