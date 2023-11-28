package ru.saiev.interviewtask.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "students", schema = "interview")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "student_firstName")
    private String firstName;

    @Column(name = "student_lastName")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "student_library_id")
    private Library library;

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private Student student;
}
