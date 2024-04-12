package com.geomin.project.cart.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.CartVO;

@Mapper
public interface CartMapper {
	
	//장바구니 추가
	public int addtoCart(@Param("user_no") int user_no, @Param("game_no") int game_no);
	
	//장바구니 중복 조회
	public int checkCart(@Param("user_no") int user_no, @Param("game_no") int game_no);
	
	//장바구니 조회
	public ArrayList<CartVO> getListCart(int user_no);
	
	//장바구니 결제 완료
	public int successPay(@Param("user_no") int user_no);
	
	//장바구니 삭제
	public int delCart(@Param("user_no") int user_no, @Param("game_no") int game_no);
	
}
