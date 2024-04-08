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
		System.out.println("cartService 동작");
		System.out.println(user_no);
		System.out.println(game_no);
		return cartMapper.addtoCart(user_no, game_no);
	}

	@Override
	public ArrayList<CartVO> getListCart() {
		return null;
	}

}
