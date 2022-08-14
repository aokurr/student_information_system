package com.example.student_information_system.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private long id;


    @Column(name = "name")
    private String name;
    @NonNull
    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;

    /*@ElementCollection
    @CollectionTable(name = "listOfCourses")*/
    @ManyToMany
    private Set<Course> courses = new HashSet<>();
}
