package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String CourseName;
    private String CourseCode;
    private String CourseDuration;

    @ManyToOne
    @JoinColumn(name="university_id")
    private University university;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    List<Student> students;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    public void setCourseDuration(String courseDuration) {
        CourseDuration = courseDuration;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public String getCourseName() {
        return CourseName;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public String getCourseDuration() {
        return CourseDuration;
    }

    public University getUniversity() {
        return university;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Course() {
    }

    public Course(String courseName, String courseCode, String courseDuration, University university, List<Student> students) {
        CourseName = courseName;
        CourseCode = courseCode;
        CourseDuration = courseDuration;
        this.university = university;
        this.students = students;
    }

    public Course(Integer id, String courseName, String courseCode, String courseDuration, University university, List<Student> students) {
        this.id = id;
        CourseName = courseName;
        CourseCode = courseCode;
        CourseDuration = courseDuration;
        this.university = university;
        this.students = students;
    }
}
