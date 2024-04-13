package com.geomin.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.cart.service.CartService;
import com.geomin.project.command.CartVO;

@RestController
public class PurchaseController {
	
	@Autowired
	@Qualifier("CartServiceImpl")
	private CartService cartService;
	
	
	
	@GetMapping("/check/cart")
	public boolean checkCart (@RequestParam("user_no") int user_no, @RequestParam("game_no") int game_no) {
	        int inCart = cartService.checkCart(user_no, game_no);

	        if (inCart > 0) {
	            return false;
	        } else {
	            return true;
	        }
	}
	
	@GetMapping("/add/cart")
	public int addCart(@RequestParam("user_no") int user_no, @RequestParam("game_no") int game_no) {
		

		return cartService.addtoCart(user_no, game_no);
	}
	
//	@GetMapping("/list/cart")
//	public ArrayList<CartVO> getListCart(@RequestParam("user_no") int user_no) {
//		System.out.println("ArrayList실행됨");
//		System.out.println(user_no);
//		return cartService.getListCart(user_no);
//	}
	
	@GetMapping("/del/cart")
	public void delCart(@RequestParam("user_no") int user_no, @RequestParam("game_no") int game_no) {
		System.out.println(user_no+"님의 " + game_no + "번이 장바구니에서 제거함");
		cartService.delCart(user_no, game_no);
	}
	
	
	/*
	 * @GetMapping("/game/purchase") public void purchase(@RequestParam("user_no")
	 * int user_no, @RequestParam("game_no") int game_no) {
	 * System.out.println(user_no+"님의 " + game_no + "가 결재 내역에 입력되었습니다.");
	 * cartService.gamePurchase(user_no, game_no); }
	 */
	
	
}
