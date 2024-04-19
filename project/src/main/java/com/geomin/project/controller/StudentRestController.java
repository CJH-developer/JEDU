package com.geomin.project.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.command.StudyGroupVO;
import com.geomin.project.command.UserVO;
import com.geomin.project.student.service.StudentMapper;
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
	            return true;
	        } else {
	            return false;
	        }
	}
	@GetMapping("reject/group")
	public ResponseEntity<Boolean> rejectCheck(@RequestParam("user_no") int user_no, @RequestParam("sg_no") int sg_no) {
	    try {
	        
	        ArrayList<StudyGroupVO> list = studentService.rejectCheck(user_no, sg_no);
	        
	        if (!list.isEmpty()) {
	            int sgj_auth;
	            try {
	                sgj_auth = Integer.parseInt(list.get(0).getSgj_auth()); 
	            } catch (NumberFormatException e) {
	                System.err.println("Failed to parse sgj_auth: " + e.getMessage());
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false); 
	            }
	            
	            if (sgj_auth == 2) {
	                return ResponseEntity.ok(true);
	            } else {
	                return ResponseEntity.ok(false);
	            }
	        } else {
	            System.err.println("No entries found for user_no=" + user_no + ", sg_no=" + sg_no);
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false); 
	        }
	    } catch (Exception e) {
	        System.err.println("Error during reject check: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
	    }
	}
	
	@GetMapping("approve/group")
	public boolean approveCheck(@RequestParam("user_no") int user_no,
						  @RequestParam("sg_no") int sg_no) {
		
		ArrayList<StudyGroupVO> list = studentService.groupList(user_no, sg_no);
		int auth = Integer.parseInt( list.get(0).sgj_auth);
		
		if(auth == 1) {
			return false;
		} else {
			return true;
		}
		
	}
	
	@GetMapping("reapply/group")
	public int reapply(@RequestParam("user_no") int user_no,
						@RequestParam("sg_no") int sg_no) {
		
		int a = studentService.reapplyGroup(user_no, sg_no);
		System.out.println(a);
		return a;
	}
	
	@GetMapping("/check/ai")
	public ArrayList<StudyGroupVO> checkAi(@RequestParam("user_no") int user_no,
											HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_level = Integer.parseInt( vo.user_level );
		System.out.println(user_level);
		System.out.println(user_no);

		ArrayList<StudyGroupVO> list =studentService.aiList(user_no, user_level);
		
		System.out.println(list.toString());
		
		return studentService.aiList(user_no, user_level);
	}

}
