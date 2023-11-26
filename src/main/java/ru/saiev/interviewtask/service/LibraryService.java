package ru.saiev.interviewtask.service;

import ru.saiev.interviewtask.dto.LibraryDto;

import java.util.List;

public interface LibraryService {
    LibraryDto createLibrary(LibraryDto libraryDto);
    LibraryDto getLibraryById(Long libraryId);
    List<LibraryDto> getAllLibraries();
    LibraryDto updateLibrary(LibraryDto libraryDto);
    void deleteLibrary(Long libraryId);
}
