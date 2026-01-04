package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String universityName;
    private String location;
    private String establishedYear;
    private String universityEmail;
    private String universityPassword;

    @OneToMany(mappedBy = "university",cascade = CascadeType.ALL)
    List<Course> courses;

    public University() {
    }

    public University(String universityName, String location, String establishedYear, String universityEmail, String universityPassword, List<Course> courses) {
        this.universityName = universityName;
        this.location = location;
        this.establishedYear = establishedYear;
        this.universityEmail = universityEmail;
        this.universityPassword = universityPassword;
        this.courses = courses;
    }

    public University(Integer id, String universityName, String location, String establishedYear, String universityEmail, String universityPassword, List<Course> courses) {
        this.id = id;
        this.universityName = universityName;
        this.location = location;
        this.establishedYear = establishedYear;
        this.universityEmail = universityEmail;
        this.universityPassword = universityPassword;
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getLocation() {
        return location;
    }

    public String getEstablishedYear() {
        return establishedYear;
    }

    public String getUniversityEmail() {
        return universityEmail;
    }

    public String getUniversityPassword() {
        return universityPassword;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEstablishedYear(String establishedYear) {
        this.establishedYear = establishedYear;
    }

    public void setUniversityEmail(String universityEmail) {
        this.universityEmail = universityEmail;
    }

    public void setUniversityPassword(String universityPassword) {
        this.universityPassword = universityPassword;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", universityName='" + universityName + '\'' +
                ", location='" + location + '\'' +
                ", establishedYear='" + establishedYear + '\'' +
                ", universityEmail='" + universityEmail + '\'' +
                ", universityPassword='" + universityPassword + '\'' +
                ", courses=" + courses +
                '}';
    }
}
