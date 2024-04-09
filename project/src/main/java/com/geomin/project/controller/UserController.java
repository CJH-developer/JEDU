package com.geomin.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/main")
	public String main() {
		System.out.println("user/main페이지");
		return "user/main";
	}
	
	@GetMapping("/PurChase_Log")
	public String PurChase() {
		return "user/PurChase_Log";
	}
	
	
	
	@GetMapping("/Study_Status")
	public String Study_Status() {
		return "user/Study_Status";
	}

	
	
	
	@GetMapping("/SubScribe_User")
	public String SubScribe() {
		return "user/SubScribe_User";
	}
	
	

}
