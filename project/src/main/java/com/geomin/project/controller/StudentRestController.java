package com.geomin.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.student.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("apply/group")
	public int groupApply(@RequestParam("user_no") int user_no,
						   @RequestParam("sg_no") int sg_no,
						   @RequestParam("sg_level") int sg_level) {

		return studentService.groupApply(user_no, sg_no, sg_level);
	}
	
	@GetMapping("check/group")
	public boolean groupCheck(@RequestParam("user_no") int user_no,
						  @RequestParam("sg_no") int sg_no) {
		
		int inGroup = studentService.groupCheck(user_no, sg_no);
		
		  if (inGroup > 0) {
	            return false;
	        } else {
	            return true;
	        }
	}
	
}