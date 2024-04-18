package com.geomin.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geomin.project.board.service.BoardRepository;
import com.geomin.project.command.DocumentVO;
import com.geomin.project.command.FaqVO;
import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.NoticeVO;
import com.geomin.project.command.QnaVO;
import com.geomin.project.document.service.DocumentService;
import com.geomin.project.gameContentService.GameContentService;
import com.geomin.project.util.Criteria;

@Controller
public class MainController {

	@Autowired
	@Qualifier("BoardService")
	private BoardRepository boardService;
	
	@Autowired
	@Qualifier("GameContentService")
	private GameContentService gameContentService;
	
	@Autowired
	@Qualifier("DocumentService")
	private DocumentService documentService;
	
	@GetMapping("/main")
	public String main(Model model, Criteria ciriteria) {
		
		ArrayList<NoticeVO> noticeVO = boardService.getNotice();
		ArrayList<FaqVO> faqVO = boardService.getFaq();
		ArrayList<QnaVO> qnaVO = boardService.getQna();
		
		ArrayList<GameContentVO> list = gameContentService.getList(ciriteria);
		model.addAttribute("gameContent", list);
		
		ArrayList<DocumentVO> list2 = documentService.getList(ciriteria);
		model.addAttribute("Document", list2);
		
		model.addAttribute("noticeVO", noticeVO);
		model.addAttribute("faqVO", faqVO);
		model.addAttribute("qnaVO", qnaVO);
		
		return "main";
	}

}
