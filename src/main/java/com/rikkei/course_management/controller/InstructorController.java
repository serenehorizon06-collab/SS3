package com.rikkei.course_management.controller;

import com.rikkei.course_management.model.Instructor;
import com.rikkei.course_management.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getAllInstructors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.getInstructorById(id);

        if (instructor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(instructor);
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(@RequestBody Instructor instructor) {
        Instructor createdInstructor = instructorService.createInstructor(instructor);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdInstructor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(
            @PathVariable Long id,
            @RequestBody Instructor instructor) {

        Instructor updatedInstructor = instructorService.updateInstructor(id, instructor);

        if (updatedInstructor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedInstructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructorById(@PathVariable Long id) {
        Instructor deletedInstructor = instructorService.deleteInstructorById(id);

        if (deletedInstructor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(deletedInstructor);
    }
}