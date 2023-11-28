package ru.saiev.interviewtask.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.saiev.interviewtask.dto.LibraryDto;
import ru.saiev.interviewtask.exception.LibraryNotFoundException;
import ru.saiev.interviewtask.exception.StudentNotFoundException;
import ru.saiev.interviewtask.service.LibraryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/libraries")
public class LibraryController {

    private LibraryService libraryService;

    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary(@RequestBody LibraryDto libraryDto) {
        LibraryDto savedLibrary = libraryService.createLibrary(libraryDto);

        if (libraryService.getLibraryById(libraryDto.getId()) != null) {
            throw new LibraryNotFoundException("Библиотека с такими данными уже существует!");
        }

        return new ResponseEntity<>(savedLibrary, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable("id") Long libraryId) {
        LibraryDto library = libraryService.getLibraryById(libraryId);

        if (library == null) {
            throw new LibraryNotFoundException("Не найдена библиотека с таким Id!" + libraryId);
        }

        return new ResponseEntity<>(library, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LibraryDto>> getAllLibraries() {
        List<LibraryDto> libraries = libraryService.getAllLibraries();

        if (libraries.isEmpty()) {
            throw new LibraryNotFoundException("Список библиотек пуст!");
        }

        return new ResponseEntity<>(libraries, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<LibraryDto> updateLibrary(@PathVariable("id") Long libraryId, @RequestBody LibraryDto libraryDto) {
        if (libraryService.getLibraryById(libraryId) == null) {
            throw new LibraryNotFoundException("Не найдена библиотека с таким Id!" + libraryId);
        }

        libraryDto.setId(libraryId);
        LibraryDto updatedLibrary = libraryService.updateLibrary(libraryDto);

        return new ResponseEntity<>(updatedLibrary, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLibrary(@PathVariable("id") Long libraryId) {
        if (libraryService.getLibraryById(libraryId) == null) {
            throw new LibraryNotFoundException("Не найден библиотека с таким Id!" + libraryId);
        }

        libraryService.deleteLibrary(libraryId);

        return new ResponseEntity<>("Библиотека успешно удалён!", HttpStatus.OK);
    }
}
