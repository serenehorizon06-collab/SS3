package com.rikkei.course_management.controller;

import com.rikkei.course_management.model.Enrollment;
import com.rikkei.course_management.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        return ResponseEntity.ok(enrollmentService.getAllEnrollments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEnrollmentById(@PathVariable Long id) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(id);

        if (enrollment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(enrollment);
    }

    @PostMapping
    public ResponseEntity<Enrollment> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment createdEnrollment = enrollmentService.createEnrollment(enrollment);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdEnrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEnrollment(
            @PathVariable Long id,
            @RequestBody Enrollment enrollment) {

        Enrollment updatedEnrollment = enrollmentService.updateEnrollment(id, enrollment);

        if (updatedEnrollment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEnrollment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnrollmentById(@PathVariable Long id) {
        Enrollment deletedEnrollment = enrollmentService.deleteEnrollmentById(id);

        if (deletedEnrollment == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deletedEnrollment);
    }
}