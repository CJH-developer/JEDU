package com.geomin.project.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.gameContentService.GameContentService;



@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	@Qualifier("GameContentService")
	private GameContentService gameContentService;
	
	// 파일 업로드 경로
	@Value("${project.upload.path}")
	private String uploadPath;
	
	// 메인 화면 - 관리자 
	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}
	
// 게임 컨텐츠 관련
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 게임 메뉴 - 컨텐츠 등록
	@GetMapping("/gameRegist")
	public String gameRegist() {
		return "admin/gameRegist";
	}

	// 게임 컨텐츠 등록
	@PostMapping("/gameRegistForm")
	public String gameRegistForm(GameContentVO vo, @RequestParam("InputFile") MultipartFile multipartFile) {
		
	
		
		gameContentService.regist(vo);
		
		return "redirect:/command/gameList";
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 학습 메뉴 - 학습 자료 등록
	@GetMapping("/learnRegist")
	public String learnRegist() {
		return "admin/learnRegist";
	}
	
	// 게시판 - 공지사항 등록
	@GetMapping("/noticeRegist")
	public String noticeRegist() {
		return "admin/noticeRegist";
	}
	
	// 게시판 - FAQ 등록
	@GetMapping("/faqRegist")
	public String faqRegist() {
		return "admin/faqRegist";
	}
	
	// 게시판 - Q&A 등록
	@GetMapping("/qnaRegist")
	public String qnaRegist() {
		return "admin/qnaRegist";
	}
	
	
	
}
