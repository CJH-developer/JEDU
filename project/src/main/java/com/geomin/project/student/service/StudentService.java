package com.geomin.project.student.service;

import java.util.ArrayList;

import com.geomin.project.command.HomeWorkVO;

import com.geomin.project.command.StudyGroupVO;
import com.geomin.project.command.learnGroupVO;


public interface StudentService {

	//스터디 그룹 신청
	public int groupApply(int user_no, int sg_no, int sg_level);


	//스터디 그룹 신청 중복 조회
	public int groupCheck (int user_no, int sg_no);


	//그룹 신청 리스트
	public ArrayList<StudyGroupVO> groupList (int user_no, int sg_no);
	

	
	//그룹 신청 리스트
	public ArrayList<StudyGroupVO> groupApplyList (int user_no);
	

	//그룹 승인 완료시 조회 안하기
	public int groupCheckingList (int user_no);

	//숙제 조회
	public ArrayList<HomeWorkVO> getHomeworkList (int user_no);

	
	//숙제 제출
    public int homeworkSubmission(HomeWorkVO hwVO);
	
}
