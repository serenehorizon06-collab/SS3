package com.rikkei.course_management.repository;

import com.rikkei.course_management.model.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {

    private final List<Enrollment> enrollments = new ArrayList<>(List.of(
            new Enrollment(1L, "Le Van C", 1L),
            new Enrollment(2L, "Pham Thi D", 2L)
    ));

    public List<Enrollment> findAll() {
        return enrollments;
    }

    public Enrollment findById(Long id) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId().equals(id)) {
                return enrollment;
            }
        }
        return null;
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Long id, Enrollment newEnrollment) {
        Enrollment oldEnrollment = findById(id);

        if (oldEnrollment == null) {
            return null;
        }

        oldEnrollment.setStudentName(newEnrollment.getStudentName());
        oldEnrollment.setCourseId(newEnrollment.getCourseId());

        return oldEnrollment;
    }

    public Enrollment deleteById(Long id) {
        Enrollment enrollment = findById(id);

        if (enrollment == null) {
            return null;
        }

        enrollments.remove(enrollment);
        return enrollment;
    }
}