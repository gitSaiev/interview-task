package ru.saiev.interviewtask.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.saiev.interviewtask.dto.StudentDto;
import ru.saiev.interviewtask.entity.Student;

@Mapper
public interface AutoStudentMapper {
    AutoStudentMapper MAPPER = Mappers.getMapper(AutoStudentMapper.class);

    StudentDto mapToStudentDto(Student student);

    Student mapToStudent(StudentDto studentDto);
}
