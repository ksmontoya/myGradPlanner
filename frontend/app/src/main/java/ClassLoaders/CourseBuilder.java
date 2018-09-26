package ClassLoaders;

import java.util.List;

public class CourseBuilder {
    private String courseShortName;
    private String courseLongName;
    private String description;
    private int ratingCount;
    private float ratingNumber;
    private String majorId;
    private List<String> preReqs;
    private List<String> postReq;

    public CourseBuilder setCourseShortName(String courseShortName) {
        this.courseShortName = courseShortName;
        return this;
    }

    public CourseBuilder setCourseLongName(String courseLongName) {
        this.courseLongName = courseLongName;
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

    public CourseBuilder setMajorId(String majorId) {
        this.majorId = majorId;
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
        return new Course(courseShortName, courseLongName, description, ratingCount, ratingNumber, majorId, preReqs, postReq);
    }
}