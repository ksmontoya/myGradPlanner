package com.example.demo.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository CourseRepository;

	
	public List<Course> getAllCourses(String majorId){
		return CourseRepository.findByMajorId(majorId);
	}

	public Course getCourse(String id) {
		return CourseRepository.findById(id).get();
	}
	
	public void addCourse(Course course) {
		CourseRepository.save(course);
	}

	public void updateCourse(Course Course) {
		CourseRepository.save(Course);
	}

	public void deleteCourse(String id) {
		CourseRepository.deleteById(id);
	}
	
	
}
