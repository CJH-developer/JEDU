package com.geomin.project.controller;




import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.geomin.project.command.DocumentVO;
import com.geomin.project.command.GameContentVO;

import com.geomin.project.document.service.DocumentService;
import com.geomin.project.gameContentService.GameContentService;



@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	@Qualifier("GameContentService")
	private GameContentService gameContentService;
	
	@Autowired
	@Qualifier("DocumentService")
	private DocumentService documentService;
	
	// 파일 업로드 경로
//	@Value("${project.upload.path}")
//	private String uploadPath;
	
	// 메인 화면 - 관리자 
	@GetMapping("/main")
	public String main() {
		return "admin/main";
	}
	
// 게임 컨텐츠 관련
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 게임 메뉴 - 컨텐츠 조회
	@GetMapping("/gameLook")
	public String gameLook(Model model) {
		
		ArrayList<GameContentVO> list = gameContentService.getList();
		model.addAttribute("gameContent", list);
		System.out.println("불러온 리스트 값 : " + list.toString());
		return "admin/gameLook";
	}
	
	// 게임 메뉴 - 컨텐츠 등록
	@GetMapping("/gameRegist")
	public String gameRegist() {
		return "admin/gameRegist";
	}

	// 컨텐츠 등록 - 게임 컨텐츠 등록
	@PostMapping("/gameRegistForm")
	public String gameRegistForm(GameContentVO vo, RedirectAttributes ra, @RequestParam("inputFile") List<MultipartFile> list)  {
		
		// 사진 넘어올 때
		// 1. 공백 이미지 제거
		list = list.stream().filter(m -> m.isEmpty() == false).collect(Collectors.toList());
		
		// 2. 이미지 타입인지 검사
		for(MultipartFile file : list) {
			
			if(file.getContentType().contains("image") == false) {
				ra.addFlashAttribute("msg", "이미지는 필수로 선택합니다. png/jpg/jpeg/500x500만 가능합니다.");
				return "redirect:/admin/gameRegist";
			}
			
		}
		// 3.이미지를 올린 경우는 서비스로 위임
		int result = gameContentService.regist(vo, list);
		if(result == 1) { //성공
			ra.addFlashAttribute("msg", "정상적으로 처리되었습니다."); //리다이렉트시 1회성
		}else { //실패
			ra.addFlashAttribute("msg", "등록에 실패했습니다. 관리자에게 문의하세요. 8282-8282");
		}
		
		return "redirect:/admin/gameLook";
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 학습 메뉴 - 학습 자료 조회
	@GetMapping("/learnLook")
	public String learnLook(Model model) {
		
		ArrayList<DocumentVO> list = documentService.getList();
		model.addAttribute("Document", list);
		System.out.println("불러온 리스트 값 : " + list.toString());
		
		return "admin/learnLook";
	}
	
	
	// 학습 메뉴 - 학습 자료 등록
	@GetMapping("/learnRegist")
	public String learnRegist() {
		return "admin/learnRegist";
	}
	
	@PostMapping("/learnRegistForm")
	public String learnRegistForm(DocumentVO vo, RedirectAttributes ra, @RequestParam("inputFiles") List<MultipartFile> list) {
		
		
		// 사진 넘어올 때
		// 1. 공백 이미지 제거
		list = list.stream().filter(m -> m.isEmpty() == false).collect(Collectors.toList());
		
		// 2. 이미지 타입인지 검사
		for(MultipartFile file : list) {
			
			if(file.getContentType().contains("image") == false) {
				ra.addFlashAttribute("msg", "이미지는 필수로 선택합니다. png/jpg/jpeg/500x500만 가능합니다.");
				return "redirect:/admin/learnRegist";
			}
			
		}
		
		// 3.이미지를 올린 경우는 서비스로 위임
		int result = documentService.regist(vo, list);
		if(result == 1) { //성공
			ra.addFlashAttribute("msg", "정상적으로 처리되었습니다."); //리다이렉트시 1회성
		}else { //실패
			ra.addFlashAttribute("msg", "등록에 실패했습니다. 관리자에게 문의하세요. 8282-8282");
		}
		
		return "redirect:/admin/learnLook";
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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