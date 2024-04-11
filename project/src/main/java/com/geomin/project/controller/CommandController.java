package com.geomin.project.controller;


import java.util.ArrayList;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.geomin.project.cart.service.CartService;
import com.geomin.project.command.CartVO;
import com.geomin.project.command.UserVO;


@Controller
@RequestMapping("/command")
public class CommandController {
	
	@Autowired
	private CartService cartService;
	
	private HttpSession httpSession;
	
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
	public String cart(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		UserVO vo = (UserVO) session.getAttribute("vo");
		int user_no = Integer.parseInt(vo.user_no);
		
		ArrayList<CartVO> cartList = cartService.getListCart(user_no);
		
		System.out.println(cartList.get(0).getGame_price());
		
		int total_price = 0;
		
		for(CartVO c : cartList) {
			total_price += c.getGame_price();
		}
		
		System.out.println(total_price);
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("total_price", total_price);
		
		
	    return "command/cart";
	}

	
	@GetMapping("/payment")
	public String payment() {
		return "command/payment";
	}
	
	
}
