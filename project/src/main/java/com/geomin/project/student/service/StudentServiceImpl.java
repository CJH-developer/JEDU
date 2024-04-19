package com.geomin.project.student.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.StudyGroupVO;
import com.geomin.project.command.learnGroupVO;
import com.geomin.project.util.StudyGroupCriteria;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper;
	
	//그룹 신청
	@Override
	public int groupApply(int user_no, int sg_no, int sg_level) {
		return studentMapper.groupApply(user_no, sg_no, sg_level);
	}
	
	//그룹 신청 리스트
	@Override
	public ArrayList<StudyGroupVO> groupList(int user_no, int sg_no) {
		return studentMapper.groupList(user_no, sg_no);
	}
	
	//그룹 신청 승인 여부 
	@Override
	public ArrayList<StudyGroupVO> groupApplyList(int user_no) {
		return studentMapper.groupApplyList(user_no);
	}
	
	//그룹 신청 중복 여부
	@Override
	public int groupCheck(int user_no, int sg_no) {
		return studentMapper.groupCheck(user_no, sg_no);
	}
	
	//그룹 신청 거절 여부
	@Override
	public ArrayList<StudyGroupVO> rejectCheck(int user_no, int sg_no) {
		return studentMapper.rejectCheck(user_no, sg_no);
	};
	
	//그룹 재가입 신청
	@Override
	public int reapplyGroup(int user_no, int sg_no) {
		return studentMapper.reapplyGroup(user_no, sg_no);
	};
	
	@Override
	public ArrayList<HomeWorkVO> getHomeworkList(int user_no) {
		return studentMapper.getHomeworkList(user_no);
	};
	
	//숙제 디테일 조회
	public  ArrayList<HomeWorkVO> getHomeworkDetail (int user_no , int homework_no) {
		return studentMapper.getHomeworkDetail(user_no, homework_no);
	}

	@Override
	public int groupCheckingList(int user_no) {
		return studentMapper.groupCheckingList(user_no);
	}

	@Override
	public int homeworkSubmission(HomeWorkVO hwVO) {
		return studentMapper.homeworkSubmission(hwVO);
	}

	//그룹 스터디 조회
	@Override
	public ArrayList<StudyGroupVO> getList(StudyGroupCriteria cri) {
		return studentMapper.getList(cri);
	}
	@Override
	public int getTotal() {
		return studentMapper.getTotal();
	}

	
	//ai 체크
	public ArrayList<StudyGroupVO> aiList(int user_no, int user_level){
		return studentMapper.aiList(user_no, user_level);
	}
	
	
	//숙제 포인트 등록
	@Override
	public void addPoint(int user_no, int sg_no) {}



	
	

	



	
	
}
