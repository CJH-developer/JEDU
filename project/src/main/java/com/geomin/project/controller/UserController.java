package com.geomin.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geomin.project.UserServiceTwo.UserServiceTwo;
import com.geomin.project.command.GameContentVO;
import com.geomin.project.user.service.UserService;
import com.geomin.project.util.JPageVO;
import com.geomin.project.util.JTwoCriteria;
import com.geomin.project.util.JTwoPageVO;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	@Qualifier("userServiceTwo")
	public UserServiceTwo userServiceTwo;
	
	@GetMapping("/main")
	public String main() {
		System.out.println("user/main페이지");
		return "user/main";
	}
	
	
	
	@GetMapping("/Study_Status")
	public String Study_Status() {
		return "user/Study_Status";
	}

	
	
	
	@GetMapping("/SubScribe_User")
	public String SubScribe() {
		return "user/SubScribe_User";
	}
	
	@GetMapping("/User_myproduct")
	public String Usermyproduct(Model model,JTwoCriteria JTwo) {
		
		ArrayList<GameContentVO> List=userServiceTwo.MyList(JTwo);
		int JTwoTotal = userServiceTwo.JTwoTotal(JTwo);
		JTwoPageVO JTwoPageVO=new JTwoPageVO(JTwo,JTwoTotal);
		model.addAttribute("JTwoPageVO",JTwoPageVO);
		model.addAttribute("List", List);
		//구매이력의 페이지당 포함될수 있는 리스트 양이 다르기 때문에 (JPageVO, JCriteria)한 묶음으로 한개 (JTwoPageVO, JTwocriteria)한 묶음으로 한개씩 두개를 만들었습니다.
		System.out.println(List);
		System.out.println(JTwoPageVO);
		System.out.println(JTwoTotal);
		return "user/User_myproduct";
	}

}
