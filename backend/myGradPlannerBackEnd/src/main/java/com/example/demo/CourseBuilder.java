package com.example.demo;

import java.util.List;

public class CourseBuilder {
    private String courseName;
    private String description;
    private int ratingCount;
    private float ratingNumber;
    private List<String> preReqs;
    private List<String> postReq;

    public CourseBuilder setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    public CourseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public CourseBuilder setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
        return this;
    }

    public CourseBuilder setRatingNumber(float ratingNumber) {
        this.ratingNumber = ratingNumber;
        return this;
    }

    public CourseBuilder setPreReqs(List<String> preReqs) {
        this.preReqs = preReqs;
        return this;
    }

    public CourseBuilder setPostReq(List<String> postReq) {
        this.postReq = postReq;
        return this;
    }

    public Course createCourse() {
        return new Course(courseName, description, ratingCount, ratingNumber, preReqs, postReq);
    }

    private class Course {
        String courseName;
        String description;
        int ratingCount;
        float ratingNumber;
        List<String> preReqs;
        List<String> postReq;

        public Course(String courseName, String description, int ratingCount, float ratingNumber, List<String> preReqs, List<String> postReq) {
            this.courseName = courseName;
            this.description = description;
            this.ratingCount = ratingCount;
            this.ratingNumber = ratingNumber;
            this.preReqs = preReqs;
            this.postReq = postReq;
        }
    }
}