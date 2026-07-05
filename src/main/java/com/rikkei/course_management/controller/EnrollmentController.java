package com.rikkei.course_management.controller;

import com.rikkei.course_management.model.Enrollment;
import com.rikkei.course_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/enrollments")
    public List<Enrollment> findAll() {
        return enrollmentService.findAll();
    }
}