package com.geomin.project.user.service;

import com.geomin.project.command.UserVO;

public interface UserService {

	//회원가입
	public int regist(UserVO vo);
	// 회원가입 페이지 속, id 체크하기 버튼
	public int buttonIdCheck(String id);

	public int modify(UserVO vo);


}
