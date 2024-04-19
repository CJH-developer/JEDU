package com.geomin.project.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.PageVO;
import com.geomin.project.command.StudyGroupVO;
import com.geomin.project.command.UserVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.student.service.StudentMapper;
import com.geomin.project.student.service.StudentService;
import com.geomin.project.teacher.service.TeacherService;
import com.geomin.project.util.StudyGroupCriteria;

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
	public String groupStudyList(Model model,  HttpServletRequest request,
								 StudyGroupCriteria cri) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		
		//그룹스터디 내용 리스트		
		ArrayList<StudyGroupVO> list = studentService.getList(cri);
		model.addAttribute("list", list);
		
		//페이지네이션
		int total = studentService.getTotal();
		PageVO pageVO = new PageVO(cri, total);
		model.addAttribute("pageVO", pageVO);
		
		return "student/groupStudyList";
	}
	
	//숙제 리스트 받아오기
	@GetMapping("/homeworkList")
	public String homeworkList(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		ArrayList<HomeWorkVO> hwList = studentService.getHomeworkList(user_no);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		String date = format.format(currentTime);
		
		
		model.addAttribute("user_name", vo.user_name);
		model.addAttribute("hwList", hwList);
		model.addAttribute("date", date);
		
		
		return "student/homeworkList";
	}
	
	@GetMapping("/homeworkDetail")
	public String homeworkDetail(Model model, 
								 HttpServletRequest request,
								 @RequestParam("homework_no") int homework_no) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		 ArrayList<HomeWorkVO> hwList = studentService.getHomeworkDetail(user_no, homework_no);
			
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		String date = format.format(currentTime);
		System.out.println(hwList.toString());
		
		model.addAttribute("user_name", vo.user_name);
		model.addAttribute("hwList", hwList);
		model.addAttribute("date", date);
		
		
		return "student/homeworkDetail";
	}
	// 그룹 가입 상세 조회
	@GetMapping("/groupApplyList")
	public String groupRegistLook(Model model,
								  HttpServletRequest request,
								  @RequestParam("sg_no") int sg_no) {
		
		HttpSession session = request.getSession();
		UserVO Uservo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(Uservo.user_no);
		
		ArrayList<StudyGroupVO> list = studentService.groupList(user_no, sg_no);
		
		System.out.println(list.size());
		
		learnGroupVO vo = teacherService.groupDetail(sg_no);
		model.addAttribute("group", vo);
		
		if(!list.isEmpty()) {		
			String auth = (String) list.get(0).sgj_auth;
			System.out.println(auth);
			model.addAttribute("auth", auth);
			model.addAttribute("list", list);
		}
		
		
		return "student/groupApplyList";
	}
	
	//그룹 가입 신청 승인 여부
	@GetMapping("/groupApproval")
	public String groupApprove(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		
		ArrayList<StudyGroupVO> sgList = studentService.groupApplyList(user_no);
			
		model.addAttribute("sgList", sgList);			
		System.out.println(sgList.toString());
		return "student/groupApproval";
	}
	
	//나의 그룹
	@GetMapping("/myGroupList")
	public String myGroupList(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		
		ArrayList<StudyGroupVO> sgList = studentService.groupApplyList(user_no);
		model.addAttribute("sgList", sgList);
		System.out.println( sgList.toString());
		
		return "student/myGroupList";
	}
	
	
	//숙제 내역 조회
	@GetMapping("/homeworkTable")
	public String homeworkTable(Model model, HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		ArrayList<HomeWorkVO> hwList = studentService.getHomeworkList(user_no);
		
		model.addAttribute("user_name", vo.user_name);
		model.addAttribute("hwList", hwList);	
		
		System.out.println(hwList.toString());
		System.out.println(hwList.get(1).hwDuedate() < 0);
		return "student/homeworkTable";
	};
	
	//슥제 제출
	@GetMapping("/submission")
	public String submission(HomeWorkVO hwVO) {
		studentService.homeworkSubmission(hwVO);
		return "redirect:/student/homeworkTable";
	}
	
	@GetMapping("/homeworkPass")
	public String homeworkPass() {
		
		
		return "student/homeworkPass";
	}
	
	@GetMapping("/myGroupDetail")
	public String myGroupDetail(Model model,
			  					HttpServletRequest request,
			  					@RequestParam("sg_no") int sg_no) {
		
		HttpSession session = request.getSession();
		UserVO Uservo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(Uservo.user_no);
		
		ArrayList<StudyGroupVO> list = studentService.groupList(user_no, sg_no);
		
		System.out.println(list.size() +"~~~~~~~~~~~~~~~~~~~~~~~~~3333333333333333");
		
		learnGroupVO vo = teacherService.groupDetail(sg_no);
		model.addAttribute("group", vo);
		
		System.out.println(vo.toString() + "11111111111~~~~~~~~~~~~~");
		
		if(!list.isEmpty()) {		
			String auth = (String) list.get(0).sgj_auth;
			System.out.println(auth);
			model.addAttribute("auth", auth);
			model.addAttribute("list", list);
		}
		
		return "student/myGroupDetail";
	}
	
	
}
