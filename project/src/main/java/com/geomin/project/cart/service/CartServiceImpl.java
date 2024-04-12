package com.geomin.project.cart.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.CartVO;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public int addtoCart(int user_no, int game_no) {
		System.out.println("cartService의 addtoCart 동작");
		return cartMapper.addtoCart(user_no, game_no);
	}
	
	@Override
	public int checkCart(int user_no, int game_no) {
		System.out.println("cartService의 checkCart 동작");
		System.out.println(user_no);
		return cartMapper.checkCart(user_no, game_no);
	}
	
	
	@Override
	public ArrayList<CartVO> getListCart(int user_no) {
		return cartMapper.getListCart(user_no);
	}

	@Override
	public int successPay(int user_no) {
		return cartMapper.successPay(user_no);
	}

	@Override
	public int delCart(int user_no, int game_no) {
		return cartMapper.delCart(user_no, game_no);
	}



}
