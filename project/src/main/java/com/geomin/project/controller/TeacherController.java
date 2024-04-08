package com.geomin.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.teacher.service.TeacherService;


@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;

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
	
	// 학습 그룹 등록 페이지
	@GetMapping("/learnGroupRegist")
	public String learnGroupRegist() {
		
		return "teacher/learnGroupRegist";
	}
	
	// 학습 그룹 등록 폼
	// 여기 안에 GAME_NO는 나중에 값 직접 받아와야 함(나중에 게임상품 등록 만들면 수정)
	@PostMapping("/learnGroupRegistForm")
	public String learnGroupRegistForm(learnGroupVO vo) {

		teacherService.RegistGroup(vo);
		
		
		return "teacher/main";
		
	}
	
	// 학습 그룹 조회
	@GetMapping("/learnGroupLook")
	public String learnGroupLook(Model model) {
		
		ArrayList<learnGroupVO> list = teacherService.learnGroupLook();
		model.addAttribute("list", list);
		
		return "teacher/learnGroupLook";
	}
	
	// 숙제 등록
	@PostMapping("/homeWorkRegistForm")
	public String homeWorkRegistForm(HomeWorkVO vo) {
		
		System.out.println(vo);
		teacherService.RegistHomework(vo);
		
		return "";
	}
	
}
