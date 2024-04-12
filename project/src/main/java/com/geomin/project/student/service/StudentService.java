package com.geomin.project.student.service;

import com.geomin.project.command.learnGroupVO;

public interface StudentService {
	
	public int groupApply(int user_no, int sg_no, int sg_level);
	public int groupCheck (int user_no, int sg_no);

	
	
}
