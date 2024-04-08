package com.geomin.project.cart.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.geomin.project.command.CartVO;

@Mapper
public interface CartMapper {
	
	//장바구니 추가
	public int addtoCart(int user_no);
	
	//장바구니 조회
	public ArrayList<CartVO> getListCart();
	
}
