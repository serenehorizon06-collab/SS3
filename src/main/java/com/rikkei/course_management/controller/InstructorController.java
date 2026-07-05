package com.rikkei.course_management.controller;

import com.rikkei.course_management.model.Instructor;
import com.rikkei.course_management.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructors")
    public List<Instructor> findAll() {
        return instructorService.findAll();
    }
}