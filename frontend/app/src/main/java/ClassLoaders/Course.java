package ClassLoaders;

import java.util.List;


public class Course {

	protected String courseId;
	protected String courseLongName;
	protected String description;
	protected int ratingCount;
	protected float ratingNumber;

	protected Major major;

	protected List<String> preReqs;

	protected List<String> postReq;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseLongName() {
		return courseLongName;
	}
	public void setCourseLongName(String courseLongName) {
		this.courseLongName = courseLongName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRatingCount() {
		return ratingCount;
	}
	public void setRatingCount(int ratingCount) {
		this.ratingCount = ratingCount;
	}
	public float getRatingNumber() {
		return ratingNumber;
	}
	public void setRatingNumber(float ratingNumber) {
		this.ratingNumber = ratingNumber;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public List<String> getPreReqs() {
		return preReqs;
	}
	public void setPreReqs(List<String> preReqs) {
		this.preReqs = preReqs;
	}
	public List<String> getPostReq() {
		return postReq;
	}
	public void setPostReq(List<String> postReq) {
		this.postReq = postReq;
	}
	public Course(String courseShortName, String courseLongName, String description, int ratingCount,
			float ratingNumber, String majorId, List<String> preReqs, List<String> postReq) {
		super();
		this.courseId = courseShortName;
		this.courseLongName = courseLongName;
		this.description = description;
		this.ratingCount = ratingCount;
		this.ratingNumber = ratingNumber;
		this.major = new MajorBuilder().createMajor().setId(majorId);
		this.preReqs = preReqs;
		this.postReq = postReq;
	}
	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course{" +
				"courseId='" + courseId + '\'' +
				", courseLongName='" + courseLongName + '\'' +
				", description='" + description + '\'' +
				", ratingCount=" + ratingCount +
				", ratingNumber=" + ratingNumber +
				", major=" + major +
				", preReqs=" + preReqs +
				", postReq=" + postReq +
				'}';
	}
}




