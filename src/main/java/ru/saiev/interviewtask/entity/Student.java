package ru.saiev.interviewtask.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "library_id")
    private Library library;

    @OneToOne
    @Column(name = "student_id")
    private Student student;
}
