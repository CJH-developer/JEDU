package com.geomin.project.cart.service;

import java.util.ArrayList;

import com.geomin.project.command.CartVO;

public interface CartService {
	
	//장바구니 추가
	public int addtoCart(CartVO vo);
	
	//장바구니 조회
	public ArrayList<CartVO> getListCart();
	
}
