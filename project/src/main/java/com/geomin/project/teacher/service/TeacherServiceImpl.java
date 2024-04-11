package com.geomin.project.teacher.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.learnGroupVO;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	TeacherMapper teacherMapper;

	@Override
	public int RegistGroup(learnGroupVO vo) {
		// 학습 그룹 등록
		return teacherMapper.RegistGroup(vo);
	}

	@Override
	public ArrayList<learnGroupVO> learnGroupLook() {
		// 학습 그룹 조회
		return teacherMapper.learnGroupLook();
	}

	@Override
	public ArrayList<learnGroupVO> myGroupList(int user_no) {
		
		return teacherMapper.myGroupList(user_no);
	}

	@Override
	public int RegistHomework(HomeWorkVO vo) {
		
		return teacherMapper.RegistHomework(vo);
	}

	@Override
	public learnGroupVO groupDetail(int sg_no) {
		
		return teacherMapper.groupDetail(sg_no);
	}

	@Override
	public ArrayList<HomeWorkVO> getHomework() {
		
		return teacherMapper.getHomework();
	}

	@Override
	public ArrayList<learnGroupVO> groupDetail2(int sg_no) {
		
		return teacherMapper.groupDetail2(sg_no);
	}

	@Override
	public int approve(int user_no) {
		
		return teacherMapper.approve(user_no);
	}

	@Override
	public int capacity(int sg_no) {
		
		return teacherMapper.capacity(sg_no);
	}

	@Override
	public int reject(int user_no) {
		
		return teacherMapper.reject(user_no);
	}

//	@Override
//	public int capaMinus(int sg_no) {
//		
//		return teacherMapper.capaMinus(sg_no);
//	}

	
	

}
