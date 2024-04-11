package com.geomin.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geomin.project.command.UserVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.teacher.service.TeacherService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/main")
	public String main() {
		
		return "student/main";
	}
	
	@GetMapping("/game")
	public String game() {
		return "student/game";
	}
	
	@GetMapping("/groupStudyList")
	public String groupStudyList(Model model) {
		
		ArrayList<learnGroupVO> list = teacherService.learnGroupLook();
		model.addAttribute("list", list);
		
		return "student/groupStudyList";
	}
	
	@GetMapping("/homeworkList")
	public String homeworkList() {
		return "student/homeworkList";
	}
	
	// 그룹 가입 상세 조회
	@GetMapping("/groupApplyList")
	public String groupRegistLook(Model model,
								  @RequestParam("sg_no") int sg_no) {		
		learnGroupVO vo = teacherService.groupDetail(sg_no);		
		model.addAttribute("group", vo);
 	
		return "student/groupApplyList";
	}
	
	//그룹 가입 신청
//	@GetMapping("/applyGroup")
//	public String applyGroup(@RequestParam("sg_no") int sg_no, HttpServletRequest request) {
//		
//		HttpSession session = request.getSession();
//		UserVO vo = (UserVO) session.getAttribute("vo");
//		int user_no = Integer.parseInt(vo.user_no);
//		
//		System.out.println(user_no);
//		
//		return "redirect:/student/groupApplyList";
//	}

	
}
