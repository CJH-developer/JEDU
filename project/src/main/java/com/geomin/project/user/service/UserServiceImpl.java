package com.geomin.project.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.UserVO;
import com.geomin.project.util.Criteria;
import com.geomin.project.util.CriteriaMember;

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

	 
	@Override
	public ArrayList<UserVO> getList(CriteriaMember criteria) {
		
		return userMapper.getList(criteria);
	}

	@Override
	public int getTotal() {
		return userMapper.getTotal();
	}

	@Override
	public UserVO findUser(int user_no) {
		
		return userMapper.findUser(user_no);
	}

}
