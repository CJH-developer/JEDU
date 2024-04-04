package com.geomin.project.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.UserVO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int regist(UserVO vo) {
		return userMapper.regist(vo);
	}

	@Override
	public int buttonIdCheck(String id) {
		
		return userMapper.buttonIdCheck(id);
	}	
	
	
}
