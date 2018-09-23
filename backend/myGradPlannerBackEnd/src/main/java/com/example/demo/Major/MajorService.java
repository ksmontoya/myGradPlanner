package com.example.demo.Major;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService {
	
	@Autowired
	private MajorRepository majorRepository;

	
	public List<Major> getAllMajors(){
		List<Major> majors = new ArrayList<>();
		majorRepository.findAll().forEach(majors::add);
		return majors;
	}

	public Major getMajor(String id) {
		return majorRepository.findById(id).get();
	}
	
	public void addMajor(Major Major) {
		majorRepository.save(Major);
	}

	public void updateMajor(String id, Major Major) {
		majorRepository.save(Major);
	}

	public void deleteMajor(String id) {
		majorRepository.deleteById(id);
	}
	
	
}
