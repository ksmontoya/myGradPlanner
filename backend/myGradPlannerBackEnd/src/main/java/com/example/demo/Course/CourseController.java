package com.example.demo.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.Major.Major;

@RestController
@EnableWebMvc
public class CourseController {

	@Autowired
	private CourseService CourseService;
	
	
	@RequestMapping("/Majors/{id}/Courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return CourseService.getAllCourses(id);
	}
	
	@RequestMapping(value = "/debug", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String debugInput(HttpEntity<String> httpEntity) {
	    String json = httpEntity.getBody();
	    System.out.println(json);
	    return json;
	}
	
	@RequestMapping("/Majors/{majorId}/Courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return CourseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Majors/{majorId}/Courses")
	public void addCourse(@RequestBody Course course, @PathVariable String majorId) {
		course.setMajor(new Major().setId(majorId));
		CourseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Majors/{majorId}/Courses/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String majorId, @PathVariable String courseId) {
		course.setMajor(new Major().setId(majorId));
		CourseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Majors/{majorId}/Courses/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		CourseService.deleteCourse(courseId);
	}
}
