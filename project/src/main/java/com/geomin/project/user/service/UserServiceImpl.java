package com.geomin.project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	// 회원가입
	@Override
	public int regist(UserVO vo) {
		return userMapper.regist(vo);
	}

	// 회원가입 - 아이디 중복 조회
	@Override
	public int buttonIdCheck(String id) {

		return userMapper.buttonIdCheck(id);
	}

	 
	 // 회원 정보 수정
	  
	 @Override 
	 public int modify(UserVO vo) { 
		 System.out.println("임플먼트 vo 값 :" +vo.toString()); 
		 
		 return userMapper.modify(vo); 
		 
	 }

}
