package com.rikkei.course_management.controller;

import com.rikkei.course_management.model.Course;
import com.rikkei.course_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<Course> findAll() {
        return courseService.findAll();
    }
}