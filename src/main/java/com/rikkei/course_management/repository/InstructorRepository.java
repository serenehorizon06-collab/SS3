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

    public Instructor findById(Long id) {
        for (Instructor instructor : instructors) {
            if (instructor.getId().equals(id)) {
                return instructor;
            }
        }
        return null;
    }

    public Instructor create(Instructor instructor) {
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(Long id, Instructor newInstructor) {
        Instructor oldInstructor = findById(id);

        if (oldInstructor == null) {
            return null;
        }

        oldInstructor.setName(newInstructor.getName());
        oldInstructor.setEmail(newInstructor.getEmail());

        return oldInstructor;
    }

    public Instructor deleteById(Long id) {
        Instructor instructor = findById(id);

        if (instructor == null) {
            return null;
        }

        instructors.remove(instructor);
        return instructor;
    }
}