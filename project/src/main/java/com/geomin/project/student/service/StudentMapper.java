package com.geomin.project.student.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.learnGroupVO;

@Mapper
public interface StudentMapper {
	
	public int groupApply(@Param("user_no") int user_no, 
						  @Param("sg_no") int sg_no,
						  @Param("sg_level") int sg_level);
	
	public int groupCheck (@Param("user_no") int user_no, 
			  				@Param("sg_no") int sg_no);

	
	
}
