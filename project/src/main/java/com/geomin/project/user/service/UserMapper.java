package com.geomin.project.user.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.PurchaseVO;
import com.geomin.project.command.QnaVO;
import com.geomin.project.command.UserVO;
import com.geomin.project.util.Criteria;
import com.geomin.project.util.CriteriaMember;
import com.geomin.project.util.CriteriaPrice;
import com.geomin.project.util.CriteriaQuestion;
import com.geomin.project.util.CriteriaSleep;

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
	
	//qna 조회
	public ArrayList<QnaVO> getQnaList(@Param("user_no") int user_no, @Param("criteria") CriteriaQuestion criteria);
	public int getQnaTotal(int user_no);
	
	// 문의사항 등록
	public int qnaRegist(QnaVO vo);
	
	// 내 문의사항 삭제
	public int qnaDelete(int qna_no);
	
	// 휴먼 계정 전환
	public int userSleep(int user_no);
	
	// 휴먼 계정 조회
	public ArrayList<UserVO> getSleepList(@Param("criteria") CriteriaSleep criteria);
	public int getSleepTotal();
	
	// 매출조회
	public ArrayList<GameContentVO> getPurchaseList(@Param("criteria") CriteriaPrice criteria);
	public int getPriceTotal();
	
	// 매출 상세 조회
	public ArrayList<PurchaseVO> getPurchaseDetail(String purchase_date);
	
	// 계정 잠금
	public int lock(String user_id);
}
