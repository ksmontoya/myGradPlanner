package com.example.demo.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.Major.Major;

@RestController
@EnableWebMvc
public class CourseController {

	@Autowired
	private CourseService CourseService;
	
	
	@RequestMapping("/Majors/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return CourseService.getAllCourses(id);
	}
	
	@RequestMapping("/Majors/{majorId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return CourseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Majors/{majorId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String majorId) {
		course.setMajor(new Major().setId(majorId));
		CourseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Majors/{majorId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String majorId, @PathVariable String courseId) {
		course.setMajor(new Major().setId(majorId));
		CourseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Majors/{majorId}/courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		CourseService.deleteCourse(courseId);
	}
}
