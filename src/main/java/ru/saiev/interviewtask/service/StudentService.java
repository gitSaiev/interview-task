package ru.saiev.interviewtask.service;

import ru.saiev.interviewtask.dto.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long studentId);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(StudentDto studentDto);
    void deleteStudent(Long studentId);
}
