package com.example.demo;

import java.util.List;

public class Major {
    List<String> courses;

    public Major(List<String> courses) {
        this.courses = courses;
    }

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
}