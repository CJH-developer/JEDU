package com.geomin.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {

	// 메뉴 - 서비스
	@GetMapping("/service")
	public String service() {
		return "menu/service";
	}
	
	// 메뉴 - 게임
	@GetMapping("/game")
	public String game() {
		return "menu/game";
	}
	
	// 메뉴 - 교육영상
	@GetMapping("/eduVideo")
	public String eduVideo() {
		return "menu/eduVideo";
	}
	
	// 메뉴 - 센터
	@GetMapping("/center")
	public String center() {
		return "menu/center";
	}
	
	// 메뉴 - 사이트맵
	@GetMapping("/sitemap")
	public String sitemap() {
		return "menu/sitemap";
	}
	
}
