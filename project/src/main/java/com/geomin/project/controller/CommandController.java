package com.geomin.project.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.geomin.project.command.GameContentVO;

import com.geomin.project.service.Command.CommandService;
import com.geomin.project.util.JCriteria;
import com.geomin.project.util.JPageVO;





@Controller
@RequestMapping("/command")
public class CommandController {
	@Autowired
	@Qualifier("commandService")
	public CommandService commandService;

	
	// 회원 정보 수정
	@GetMapping("/modify")
	public String modify() {
		
		
		return "command/modify";
	}
	
	
	// 게임 컨텐츠 목록 - 일반 사용자 / 선생님
	//수정된 페이지민상
	@GetMapping("/gameList")
	public String power(Model model, JCriteria JCri) {
	ArrayList<GameContentVO> list=commandService.getList(JCri);
	 List<GameContentVO> pagesubList = list.subList(0, 5);
	 List<GameContentVO> pagesubListTwo = list.subList(5, 10);
	int total=commandService.getTotal(JCri);
		JPageVO JPageVO=new JPageVO(JCri, total);
		
		model.addAttribute("JPageVO",JPageVO);
		model.addAttribute("pagesubList",pagesubList);
		model.addAttribute("pagesubListTwo",pagesubListTwo);
		return "command/gameList";
	}
	
	// 게임 컨텐츠 목록 - 일반 사용자 / 선생님
	@GetMapping("/lookup")
	public String lookup() {
		return "command/lookup";
	}
	
	

	
	
}
