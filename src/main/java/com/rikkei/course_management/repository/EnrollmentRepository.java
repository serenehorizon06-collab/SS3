package com.rikkei.course_management.repository;

import com.rikkei.course_management.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = List.of(
            new Enrollment(1L, "Le Van C", 1L),
            new Enrollment(2L, "Pham Thi D", 2L)
    );

    public List<Enrollment> findAll() {
        return enrollments;
    }
}