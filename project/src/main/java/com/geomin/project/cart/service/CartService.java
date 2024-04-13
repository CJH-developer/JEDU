package com.geomin.project.cart.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.CartVO;

public interface CartService {
	
	//장바구니 추가
	public int addtoCart(int user_no, int game_no);
	
	//장바구니 중복 조회
	public int checkCart(int user_no, int game_no);
	
	//장바구니 조회
	public ArrayList<CartVO> getListCart(int user_no);
	
	//장바구니 결제 완료
	public int successPay(@Param("user_no") int user_no);
	
	//장바구니 삭제
	public int delCart(int user_no, int game_no);

	//결제 내역 추가
	public int gamePurchase(int user_no, int game_no);
	
}
