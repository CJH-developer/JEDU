package com.geomin.project.student.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.StudyGroupVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.util.StudyGroupCriteria;

@Mapper
public interface StudentMapper {
	
	//그룹 신청
	public int groupApply(@Param("user_no") int user_no, 
						  @Param("sg_no") int sg_no,
						  @Param("sg_level") int sg_level);
	//그룹 신청 중복체크
	public int groupCheck (@Param("user_no") int user_no, 
			  				@Param("sg_no") int sg_no);
	
	//그룹 신청 리스트
	public ArrayList<StudyGroupVO> groupList (@Param("user_no") int user_no, @Param("sg_no") int sg_no);
	
	//그룹 신청 승인 여부 
	public ArrayList<StudyGroupVO> groupApplyList (int user_no);
	
	//그룹 승인 완료시 조회 안하기
	public int groupCheckingList (int user_no);

	//그룹 신청 승인 여부
	public int groupApproval ();
	
	//숙제 조회
	public ArrayList<HomeWorkVO> getHomeworkList (int user_no);
	
	//숙제 제출
	public int homeworkSubmission(HomeWorkVO hwVO);
	
	//승인 조회
	
	
	//그룹 스터디 조회
	public ArrayList<StudyGroupVO> getList(StudyGroupCriteria cri);
	public int getTotal();
	
	//ai 체크
	public ArrayList<StudyGroupVO> aiList(@Param("user_no") int user_no, @Param("user_level") int user_level);
	
	
	
	
}
