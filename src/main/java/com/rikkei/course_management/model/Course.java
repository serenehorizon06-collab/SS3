package com.rikkei.course_management.model;

public class Course {
    private Long id;
    private String title;
    private String status;
    private Long instructorId;

    public Course(Long id, String title, String status, Long instructorId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.instructorId = instructorId;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public Long getInstructorId() { return instructorId; }
}