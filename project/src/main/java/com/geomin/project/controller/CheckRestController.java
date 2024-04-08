package com.geomin.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.command.learnGroupVO;
import com.geomin.project.teacher.service.TeacherService;
import com.geomin.project.user.service.UserService;

@RestController
public class CheckRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TeacherService teacherService;
	
	// 회원가입 페이지 아이디체크
	// 배포 시, CrossOrigin 설정 다시 해야함
	@GetMapping("/check/{user_id}")
	public int idCheck(@PathVariable("user_id") String id) {
		
		return userService.buttonIdCheck(id);
	}
	
	// 숙제 페이지에 학습그룹 불러오기
	@GetMapping("/mygroup/{user_no}")
	public ArrayList<learnGroupVO> myGroupList(@PathVariable("user_no") int user_no) {
		
		System.out.println(user_no);
		
		return teacherService.myGroupList(user_no);
	}
	
	

}
