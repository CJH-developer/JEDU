package com.geomin.project.teacher.service;

import java.util.ArrayList;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.learnGroupVO;

public interface TeacherService {
	
	// 학습 그룹 등록
	public int RegistGroup(learnGroupVO vo);
	
	// 학습 그룹 조회
	public ArrayList<learnGroupVO> learnGroupLook();
	
	// 내 학습그룹 조회(숙제 페이지에 내 학습그룹 불러오기 포함)
	public ArrayList<learnGroupVO> myGroupList(int user_no);
	
	// 숙제 등록
	public int RegistHomework(HomeWorkVO vo);
	
	// 숙제 조회
	public ArrayList<HomeWorkVO> getHomework();
	
	// 그룹 상세조회(join 걸었음)
	public learnGroupVO groupDetail(int sg_no);
	
	
	

}
