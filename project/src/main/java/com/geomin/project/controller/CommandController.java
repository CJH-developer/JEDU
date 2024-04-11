package com.geomin.project.controller;


import java.util.ArrayList;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


import com.geomin.project.command.GameContentVO;
import com.geomin.project.service.command.CommandService;
import com.geomin.project.util.JCriteria;
import com.geomin.project.util.JPageVO;



import com.geomin.project.command.CartVO;
import com.geomin.project.command.UserVO;



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
	 List<GameContentVO> pagesubList = safeList(list,0, 5);
	 
	 List<GameContentVO> pagesubListTwo = safeList(list,5, 10);
	int total=commandService.getTotal(JCri);
		JPageVO JPageVO=new JPageVO(JCri, total);
		
		model.addAttribute("JPageVO",JPageVO);
		model.addAttribute("pagesubList",pagesubList);
		model.addAttribute("pagesubListTwo",pagesubListTwo);
		return "command/gameList";
	}
	public static List <GameContentVO> safeList(List<GameContentVO> list, int fromIndex, int toIndex){
		int actualToIndex = Math.min(list.size(), toIndex);
		if(fromIndex >= list.size()) {
			return new ArrayList<>();
			
		}
		return list.subList(fromIndex,actualToIndex);
	}
	
	// 게임 컨텐츠 목록 - 일반 사용자 / 선생님
	@GetMapping("/lookup")
	public String lookup() {
		return "command/lookup";
	}

//	@GetMapping("/cart")
//	public String cart(HttpServletRequest request, Model model) {
//		
//		HttpSession session = request.getSession();
//		UserVO vo = (UserVO) session.getAttribute("vo");
//		int user_no = Integer.parseInt(vo.user_no);
//		
//		ArrayList<CartVO> cartList = cartService.getListCart(user_no);
//		
//		System.out.println(cartList.get(0).getGame_price());
//		
//		int total_price = 0;
//		
//		for(CartVO c : cartList) {
//			total_price += c.getGame_price();
//		}
//		
//		System.out.println(total_price);
//		
//		model.addAttribute("cartList", cartList);
//		model.addAttribute("total_price", total_price);
//		
//		
//	    return "command/cart";
//	}

	

	
	
}
