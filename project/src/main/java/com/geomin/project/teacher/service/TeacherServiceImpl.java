package com.geomin.project.teacher.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	

}
