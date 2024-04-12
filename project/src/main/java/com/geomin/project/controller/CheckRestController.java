package com.geomin.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	// 그룹 가입 승인 페이지에서, 디테일 가져오는거
	@GetMapping("/groupDetails/{SG_NO}")
	public learnGroupVO groupDetails(@PathVariable("SG_NO") int sg_no) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("um1", teacherService.groupDetail(sg_no));
		map.put("um", teacherService.groupDetail2(sg_no));
		

		return teacherService.groupDetail(sg_no);

	}
	
	// 그룹 가입 승인 페이지에서, 디테일 가져오는거
	@GetMapping("/groupDetail/{SG_NO}")
	public Map<String, Object> groupDetail(@PathVariable("SG_NO") int sg_no) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("groupdetail", teacherService.groupDetail(sg_no));
		map.put("boys", teacherService.groupDetail2(sg_no));
		
		return map;
	}
	
	// 그룹 가입 승인
	@GetMapping("/approve/{user_no}")
	public int approve(@PathVariable("user_no") int user_no) {
		
		int result =teacherService.approve(user_no);
		System.out.println(result);
		
		return result;
	}
	
	// 그룹 가입 승인 시, capacity + 1
	@GetMapping("/groupcapa/{sg_no}")
	public int groupcapa(@PathVariable("sg_no") int sg_no) {
		return teacherService.capacity(sg_no);
	}
	
	// 그룹 가입 거절
	@GetMapping("/reject/{sg_no}")
	public int reject(@PathVariable("sg_no") int sg_no) {
		return teacherService.reject(sg_no);
	}
	
//	// 그룹 가입 거절 시 인구수 -1
//	@GetMapping("/groupcapaminus/{sg_no}")
//	public int groupcapaminus(@PathVariable("sg_no") int sg_no) {
//		
//		return teacherService.capaMinus(sg_no);
//	}
//	
	

}
