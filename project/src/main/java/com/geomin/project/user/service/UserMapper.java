package com.geomin.project.user.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.UserVO;
import com.geomin.project.util.Criteria;
import com.geomin.project.util.CriteriaMember;

@Mapper
public interface UserMapper {

	//회원가입
	public int regist(UserVO vo);

	//로그인
	public UserVO login(String user_id);

	// 회원가입 페이지 속, id 체크하기 버튼
	public int buttonIdCheck(String id);

	// 회원정보수정
	public int modify(UserVO vo);

	
	// 회원정보 조회
	public ArrayList<UserVO> getList(@Param("criteria") CriteriaMember criteria);
	public int getTotal();
	
	// 선택한 회원 조회
	public UserVO findUser(int user_no);

}
