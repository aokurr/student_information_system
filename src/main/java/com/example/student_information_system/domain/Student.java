package com.example.student_information_system.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotBlank
    @Column(name = "name")
    private String name;
    
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @NotBlank
    @Column(name = "email")
    private String email;
    
    @NotBlank
    @Column(name = "password")
    private String password;

    /*@ElementCollection
    @CollectionTable(name = "listOfCourses")*/
    @ManyToMany
    private Set<Course> courses = new HashSet<>();
}
