package com.geomin.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geomin.project.command.UserVO;
import com.geomin.project.security.MyUserDetails;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@GetMapping("/main")
	public String main() {

		
		
		
		
		return "teacher/main";
	}
	
}
