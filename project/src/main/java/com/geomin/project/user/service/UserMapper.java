package com.geomin.project.user.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.UserVO;

@Mapper
public interface UserMapper {
	
	//회원가입
	public int regist(UserVO vo);
	
	//로그인
	public UserVO login(String user_id);
	
	// 회원가입 페이지 속, id 체크하기 버튼
	public int buttonIdCheck(String id);
	

}
