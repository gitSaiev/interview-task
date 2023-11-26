package ru.saiev.interviewtask.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.saiev.interviewtask.dto.LibraryDto;
import ru.saiev.interviewtask.entity.Library;

@Mapper
public interface AutoLibraryMapper {
    AutoLibraryMapper MAPPER = Mappers.getMapper(AutoLibraryMapper.class);

    LibraryDto mapToLibraryDto(Library library);

    Library mapToLibrary(LibraryDto libraryDto);
}
