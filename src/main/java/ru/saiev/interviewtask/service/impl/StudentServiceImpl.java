package ru.saiev.interviewtask.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saiev.interviewtask.dto.StudentDto;
import ru.saiev.interviewtask.entity.Student;
import ru.saiev.interviewtask.mapper.AutoStudentMapper;
import ru.saiev.interviewtask.repository.StudentRepository;
import ru.saiev.interviewtask.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = AutoStudentMapper.MAPPER.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);

        return AutoStudentMapper.MAPPER.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();

        return AutoStudentMapper.MAPPER.mapToStudentDto(student);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream().map(AutoStudentMapper.MAPPER::mapToStudentDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student existingStudent = studentRepository.findById(studentDto.getId()).get();

        existingStudent.setFirstName(studentDto.getFirstName());
        existingStudent.setLastName(studentDto.getLastName());
        Student updatedStudent = studentRepository.save(existingStudent);

        return AutoStudentMapper.MAPPER.mapToStudentDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
