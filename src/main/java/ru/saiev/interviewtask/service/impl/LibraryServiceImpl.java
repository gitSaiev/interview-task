package ru.saiev.interviewtask.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.saiev.interviewtask.dto.LibraryDto;
import ru.saiev.interviewtask.entity.Library;
import ru.saiev.interviewtask.mapper.AutoLibraryMapper;
import ru.saiev.interviewtask.repository.LibraryRepository;
import ru.saiev.interviewtask.service.LibraryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    @Override
    public LibraryDto createLibrary(LibraryDto libraryDto) {
        Library library = AutoLibraryMapper.MAPPER.mapToLibrary(libraryDto);
        Library savedLibrary = libraryRepository.save(library);

        return AutoLibraryMapper.MAPPER.mapToLibraryDto(savedLibrary);
    }

    @Override
    public LibraryDto getLibraryById(Long libraryId) {
        Library library = libraryRepository.findById(libraryId).get();

        return AutoLibraryMapper.MAPPER.mapToLibraryDto(library);
    }

    @Override
    public List<LibraryDto> getAllLibraries() {
        List<Library> libraries = libraryRepository.findAll();

        return libraries.stream().map(AutoLibraryMapper.MAPPER::mapToLibraryDto)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDto updateLibrary(LibraryDto libraryDto) {
        Library existingLibrary = libraryRepository.findById(libraryDto.getId()).get();
        existingLibrary.setName(libraryDto.getName());

        Library updatedLibrary = libraryRepository.save(existingLibrary);

        return AutoLibraryMapper.MAPPER.mapToLibraryDto(updatedLibrary);
    }

    @Override
    public void deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }
}
