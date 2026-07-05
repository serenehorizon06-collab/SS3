package com.rikkei.course_management.model;

public class Enrollment {
    private Long id;
    private String studentName;
    private Long courseId;

    public Enrollment(Long id, String studentName, Long courseId) {
        this.id = id;
        this.studentName = studentName;
        this.courseId = courseId;
    }

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public Long getCourseId() { return courseId; }
}