package com.geomin.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geomin.project.cart.service.CartService;
import com.geomin.project.command.CartVO;
import com.geomin.project.command.MyData;

@RestController
public class PurchaseController {
	
	@Autowired
	private CartService cartService;
	
	
	@PostMapping("/submitData")
    public String submitData(@RequestBody MyData myData) {
        // 클라이언트로부터 전송된 데이터 확인
        System.out.println("Received data: " + myData.getSelectedValues());
        
        // 데이터를 처리하거나 다른 작업 수행
        
        // 클라이언트에 응답 전송
        return "Data received successfully";
    }
	
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
	
	@GetMapping("/list/cart")
	public ArrayList<CartVO> getListCart(@RequestParam("user_no") int user_no) {
//		System.out.println("ArrayList실행됨");
//		System.out.println(user_no);
		return cartService.getListCart(user_no);
	}
	
}
