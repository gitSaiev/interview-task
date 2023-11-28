package ru.saiev.interviewtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.saiev.interviewtask.dto.StudentDto;
import ru.saiev.interviewtask.exception.StudentNotFoundException;
import ru.saiev.interviewtask.service.StudentService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/students")
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {
        StudentDto savedStudent = studentService.createStudent(student);

        if (studentService.getStudentById(student.getId()) != null) {
            throw new StudentNotFoundException("Студент с такими данными уже существует!");
        }

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) {
        StudentDto student = studentService.getStudentById(studentId);

        if (student == null) {
            throw new StudentNotFoundException("Не найден студент с таким Id!" + studentId);
        }

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            throw new StudentNotFoundException("Список студентов пуст!");
        }

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto studentDto) {
        if (studentService.getStudentById(studentId) == null) {
            throw new StudentNotFoundException("Не найден студент с таким Id!" + studentId);
        }
        studentDto.setId(studentId);
        StudentDto updatedStudent = studentService.updateStudent(studentDto);

        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId) {
        if (studentService.getStudentById(studentId) == null) {
            throw new StudentNotFoundException("Не найден студент с таким Id!" + studentId);
        }

        studentService.deleteStudent(studentId);

        return new ResponseEntity<>("Студент успешно удалён!", HttpStatus.OK);
    }
}
