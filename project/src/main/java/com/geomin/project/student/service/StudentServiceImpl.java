package com.geomin.project.student.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.learnGroupVO;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public int groupApply(int user_no, int sg_no, int sg_level) {
		return studentMapper.groupApply(user_no, sg_no, sg_level);
	}

	@Override
	public int groupCheck(int user_no, int sg_no) {
		return studentMapper.groupCheck(user_no, sg_no);
	}

	@Override
	public ArrayList<HomeWorkVO> getHomeworkList(int user_no) {
		return studentMapper.getHomeworkList(user_no);
	}

	@Override
	public int groupCheckingList(int user_no) {
		return studentMapper.groupCheckingList(user_no);
	}

	@Override
	public int homeworkSubmission(int user_no, int homework_no) {
		return studentMapper.homeworkSubmission(user_no, homework_no);
	}



	
	
}
