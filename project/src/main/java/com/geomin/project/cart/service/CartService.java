package com.geomin.project.cart.service;

import java.util.ArrayList;

import com.geomin.project.command.CartVO;

public interface CartService {
	
	//장바구니 추가
	public int addtoCart(int user_no, int game_no);
	
	//장바구니 조회
	public ArrayList<CartVO> getListCart();
	
}
