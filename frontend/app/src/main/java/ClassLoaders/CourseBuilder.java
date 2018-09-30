package ClassLoaders;

import java.util.List;

public class CourseBuilder {
    /**
     * You absolutely need courseShortname, this is the ID
     */
    private String courseId;
    /**
     * You absolutely need majorId, this is the way we will find it by
     */
    private String majorId;

    private String courseLongName;
    private String description;
    private int ratingCount;
    private float ratingNumber;
    private List<String> preReqs;
    private List<String> postReq;

    public CourseBuilder setCourseId(String courseId) {
        this.courseId = courseId;
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
        return new Course(courseId, courseLongName, description, ratingCount, ratingNumber, majorId, preReqs, postReq);
    }
}