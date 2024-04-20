package com.geomin.project.student.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.StudyGroupVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.util.StudyGroupCriteria;

public interface StudentService {
	
	//스터디 그룹 신청
	public int groupApply(int user_no, int sg_no, int sg_level);
	
	//그룹 신청 리스트
	public ArrayList<StudyGroupVO> groupList (int user_no, int sg_no);
	
	//스터디 그룹 신청 중복 조회
	public int groupCheck (int user_no, int sg_no);
	
	//스터디 그룹 거절 조회
	public ArrayList<StudyGroupVO> rejectCheck (int user_no, int sg_no);
	
	//그룹 재가입 신청
	public int reapplyGroup (int user_no, int sg_no);
	
	//그룹 신청 리스트
	public ArrayList<StudyGroupVO> groupApplyList (int user_no);
	
	//그룹 승인 완료시 조회 안하기
	public int groupCheckingList (int user_no);

	//숙제 조회
	public ArrayList<HomeWorkVO> getHomeworkList (int user_no);
	
	//숙제 디테일 조회
	public  ArrayList<HomeWorkVO> getHomeworkDetail (int user_no , int homework_no);

	//숙제 제출
    public int homeworkSubmission(HomeWorkVO hwVO);
	
	//그룹 스터디 조회
	public ArrayList<StudyGroupVO> getList(StudyGroupCriteria cri);
	public int getTotal();
	
	//ai 체크
    public ArrayList<StudyGroupVO> aiList(int user_no, int user_level);
	
    //숙제 포인트 +1
    public void addPoint(int user_no, int sg_no);
    
}
