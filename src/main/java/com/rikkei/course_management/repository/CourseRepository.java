package com.rikkei.course_management.repository;

import com.rikkei.course_management.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses = List.of(
            new Course(1L, "Java Spring Boot", "OPEN", 1L),
            new Course(2L, "React Basic", "CLOSED", 2L)
    );

    public List<Course> findAll() {
        return courses;
    }
}