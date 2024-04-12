package com.geomin.project.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	
}
