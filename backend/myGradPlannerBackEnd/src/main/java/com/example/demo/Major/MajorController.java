package com.example.demo.Major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class MajorController {

	@Autowired
	private MajorService MajorService;
	
	
	@RequestMapping("/Majors")
	public List<Major> getAllMajors() {
		return MajorService.getAllMajors();
	}
	
	@RequestMapping("/Majors/{id}")
	public Major getMajor(@PathVariable String id) {
		return MajorService.getMajor(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/Majors")
	public void addMajor(@RequestBody Major Major) {
		MajorService.addMajor(Major);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/Majors/{id}")
	public void updateMajor(@RequestBody Major Major, @PathVariable String id) {
		MajorService.updateMajor(id, Major);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/Majors/{id}")
	public void deleteMajor(@PathVariable String id) {
		MajorService.deleteMajor(id);
	}
}
