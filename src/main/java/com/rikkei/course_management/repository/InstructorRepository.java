package com.rikkei.course_management.repository;

import com.rikkei.course_management.model.Instructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors = List.of(
            new Instructor(1L, "Nguyen Van A", "a@gmail.com"),
            new Instructor(2L, "Tran Thi B", "b@gmail.com")
    );

    public List<Instructor> findAll() {
        return instructors;
    }
}