package ru.saiev.interviewtask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "libraries", schema = "interview")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private Long id;

    @Column(name = "library_name")
    private String name;

    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

}
