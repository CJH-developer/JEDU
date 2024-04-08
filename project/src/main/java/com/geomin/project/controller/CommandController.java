package com.geomin.project.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


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
	public String gameList() {
		return "command/gameList";
	}
	
	// 게임 컨텐츠 목록 - 일반 사용자 / 선생님
	@GetMapping("/lookup")
	public String lookup() {
		return "command/lookup";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "command/cart";
	}
	
	
}
