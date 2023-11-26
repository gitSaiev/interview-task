package ru.saiev.interviewtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.saiev.interviewtask.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
}
