package com.example.student_information_system.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

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

    @Column(name = "courseTitle")
    
    private String courseTitle;

    @Column(name = "courseCode")
    private String courseCode;

    @Column(name = "semester")
    private int semester;

    @Column(name = "credits")
    private int credits;

    @Column(name = "classCapacity")
    private int classCapacity;

    @Column(name = "lecturer")
    private String lecturer;
    
    @ManyToMany
    Set<Student> likes=new HashSet<Student>();

}