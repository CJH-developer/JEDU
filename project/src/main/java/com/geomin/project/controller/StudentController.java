package com.geomin.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/main")
	public String main() {
		
		return "student/main";
	}
	
	@GetMapping("/game")
	public String game() {
		return "student/game";
	}
	
	@GetMapping("/groupStudyList")
	public String groupStudyList() {
		return "student/groupStudyList";
	}
	
	@GetMapping("/homeworkList")
	public String homeworkList() {
		return "student/homeworkList";
	}
	
	
}
