package com.example.demo.Course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	public List<Course> findByMajorId(String Id);
}
