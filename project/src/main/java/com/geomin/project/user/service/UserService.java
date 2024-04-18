package com.geomin.project.user.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.QnaVO;
import com.geomin.project.command.UserVO;
import com.geomin.project.util.Criteria;
import com.geomin.project.util.CriteriaMember;
import com.geomin.project.util.CriteriaQuestion;

public interface UserService {
	
	//회원가입
	public int regist(UserVO vo);
	// 회원가입 페이지 속, id 체크하기 버튼
	public int buttonIdCheck(String id);
	
	public int modify(UserVO vo);

	// 회원정보 조회
	public ArrayList<UserVO> getList(@Param("criteria") CriteriaMember criteria);
	public int getTotal();
	
	// 선택한 회원 조회
	public UserVO findUser(int user_no);
	
	//qna 조회
	public ArrayList<QnaVO> getQnaList(int user_no,@Param("criteria") CriteriaQuestion criteria );
	public int getQnaTotal(int user_no);
	
	// 문의사항 등록
	public int qnaRegist(QnaVO vo);
	
	// 내 문의사항 삭제
	public int qnaDelete(int qna_no);
}
