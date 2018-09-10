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
	String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/1")
	@ResponseBody
	String hello1() {
		return "Hello Tanmay!";
	}
	
	@RequestMapping("/2")
	@ResponseBody
	String hello2() {
		return "Hello Arnoldo!";
	}
	
	@RequestMapping("/3")
	@ResponseBody
	String hello3() {
		return "Hello Karla!";
	}
	
	@RequestMapping("/4")
	@ResponseBody
	String hello4() {
		return "Hello Josh!";
	}
	
	@RequestMapping("/5")
	@ResponseBody
	String hello5() {
		return "Hello Andrew!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ExperimentApplication.class, args);
	}
}
