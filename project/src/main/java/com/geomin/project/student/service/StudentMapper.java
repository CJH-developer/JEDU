package com.geomin.project.student.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.HomeWorkVO;
import com.geomin.project.command.learnGroupVO;

@Mapper
public interface StudentMapper {
	
	public int groupApply(@Param("user_no") int user_no, 
						  @Param("sg_no") int sg_no,
						  @Param("sg_level") int sg_level);
	
	public int groupCheck (@Param("user_no") int user_no, 
			  				@Param("sg_no") int sg_no);

	//숙제 조회
	public ArrayList<HomeWorkVO> getHomeworkList (int user_no);
	
	
}
