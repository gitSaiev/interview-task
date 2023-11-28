package ru.saiev.interviewtask.dto;

import lombok.*;

import java.util.List;

@Data
public class LibraryDto {
    private Long id;
    private String name;
    private List<StudentDto> studentDtoList;
}
