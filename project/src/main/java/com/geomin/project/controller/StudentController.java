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

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.UserVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.student.service.StudentService;
import com.geomin.project.teacher.service.TeacherService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/main")
	public String main() {
		
		return "student/main";
	}
	
	@GetMapping("/game")
	public String game() {
		return "student/game";
	}
	
	@GetMapping("/groupStudyList")
	public String groupStudyList(Model model,  HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		
		
		
		ArrayList<learnGroupVO> list = teacherService.learnGroupLook();
		model.addAttribute("list", list);
		
		return "student/groupStudyList";
	}
	
	@GetMapping("/homeworkList")
	public String homeworkList(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		ArrayList<HomeWorkVO> hwList = studentService.getHomeworkList(user_no);
		
		model.addAttribute("hwList", hwList);
		
		
		return "student/homeworkList";
	}
	
	// 그룹 가입 상세 조회
	@GetMapping("/groupApplyList")
	public String groupRegistLook(Model model,
								  @RequestParam("sg_no") int sg_no) {
		
		/*
		 * int inGroup = studentService.groupCheck(user_no, sg_no);
		 * 
		 * if (inGroup > 0) { System.out.println("신청한 내용 있음"); } else {
		 * System.out.println("신청한 내용 없음"); }
		 */
		  
		learnGroupVO vo = teacherService.groupDetail(sg_no);
		model.addAttribute("group", vo);
		
 	
		return "student/groupApplyList";
	}
	
	//그룹 가입 신청 승인 여부
	@GetMapping("/groupApproval")
	public String groupApprove(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		
		return "student/groupApproval";
	}

	
}
