package com.geomin.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

	// 메인 화면
	@GetMapping("/main")
	public String main() {
		return "teacher/main";
	}
	
	// 숙제 등록
	@GetMapping("/homeWorkRegist")
	public String homeWorkRegist() {
		return "teacher/homeWorkRegist";
	}
	
	// 숙제 전송
	@GetMapping("/homeWorkTransfer")
	public String homeWorkTransfer() {
		return "teacher/homeWorkTransfer";
	}
	
	// 숙제 전송
		@GetMapping("/homeWorkScore")
		public String homeWorkScore() {
			return "teacher/homeWorkScore";
		}
	
	// 나의 구독 조회
	@GetMapping("/myproduct")
	public String myproduct() {
		return "teacher/myproduct";
	}
	
	// 학습 그룹 등록
	@GetMapping("/learnGroupRegist")
	public String learnGroupRegist() {
		
		return "teacher/learnGroupRegist";
	}
	
	// 학습 그룹 조회
	@GetMapping("/learnGroupLook")
	public String learnGroupLook() {
		
		return "teacher/learnGroupLook";
	}
	
}
