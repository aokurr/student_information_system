package com.example.student_information_system.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
@Entity
@Table(name = "Course")
@Data
@AllArgsConstructor
public class course {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private long id;
    
    @Column(name = "courseTitle")
    private String courseTitle;

    @Column(name = "courseCode")
    private String courseCode ;
    
    @Column(name = "semester")
    private short semester;

    @Column(name = "credits")
    private short credits;

    @Column(name = "classCapacity")
    private short classCapacity;

    @Column(name = "lecturer")
    private String lecturer;

}