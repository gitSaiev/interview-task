CREATE TABLE interview.libraries
(
    library_id   BIGSERIAL NOT NULL,
    library_name VARCHAR(255),
    PRIMARY KEY (library_id)
);

CREATE TABLE interview.students
(
    student_id         BIGSERIAL NOT NULL,
    student_library_id BIGINT,
    student_first_name VARCHAR(255),
    student_last_name  VARCHAR(255),
    PRIMARY KEY (student_id)
);

ALTER TABLE IF EXISTS interview.students
    ADD CONSTRAINT fk_libraries_students foreign key (student_library_id) REFERENCES interview.libraries;

ALTER TABLE IF EXISTS interview.students
    ADD CONSTRAINT fk_students_libraries FOREIGN KEY (student_id) REFERENCES interview.students;
