package com.rikkei.course_management.repository;

import com.rikkei.course_management.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {

    private final List<Course> courses = new ArrayList<>(List.of(
            new Course(1L, "Java Spring Boot", "OPEN", 1L),
            new Course(2L, "React Basic", "CLOSED", 2L)
    ));

    public List<Course> findAll() {
        return courses;
    }

    public Course findById(Long id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    public Course create(Course course) {
        courses.add(course);
        return course;
    }

    public Course update(Long id, Course newCourse) {
        Course oldCourse = findById(id);

        if (oldCourse == null) {
            return null;
        }

        oldCourse.setTitle(newCourse.getTitle());
        oldCourse.setStatus(newCourse.getStatus());
        oldCourse.setInstructorId(newCourse.getInstructorId());

        return oldCourse;
    }

    public Course deleteById(Long id) {
        Course course = findById(id);

        if (course == null) {
            return null;
        }

        courses.remove(course);
        return course;
    }
}