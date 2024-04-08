package com.geomin.project.cart.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.geomin.project.command.CartVO;

@Service
public class CartServiceImpl implements CartService{

	@Override
	public int addtoCart(CartVO vo) {
		return 0;
	}

	@Override
	public ArrayList<CartVO> getListCart() {
		return null;
	}

}
