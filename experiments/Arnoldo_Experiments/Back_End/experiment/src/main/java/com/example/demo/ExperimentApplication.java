package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class ExperimentApplication {

	@RequestMapping("/")
	@ResponseBody
	String homeGirl() {
		return "Hello Karla!";
	}
	
	@RequestMapping("/Arnoldo")
	@ResponseBody
	String homeBoy() {
		return "Hello Arnoldo!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExperimentApplication.class, args);
	}
}