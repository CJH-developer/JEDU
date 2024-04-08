package com.geomin.project.controller;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.geomin.project.PAGEVO.JCriteria;
import com.geomin.project.command.MyData;





@Controller
@RequestMapping("/command")
public class CommandController {


	
	// 회원 정보 수정
	@GetMapping("/modify")
	public String modify() {
		
		
		return "command/modify";
	}
	
	
	// 게임 컨텐츠 목록 - 일반 사용자 / 선생님
	@GetMapping("gameList")
	public String gameList(Model model,JCriteria Jcri) {
		ArrayList<MyData> list = 
		return "command/gameList";
	}
	
	// 게임 컨텐츠 목록 - 일반 사용자 / 선생님
	@GetMapping("/lookup")
	public String lookup() {
		return "command/lookup";
	}
	
	
	
}
