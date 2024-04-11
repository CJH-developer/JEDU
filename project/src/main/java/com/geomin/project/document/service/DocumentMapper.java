package com.geomin.project.document.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.geomin.project.command.DocumentUploadVO;
import com.geomin.project.command.DocumentVO;
import com.geomin.project.util.Criteria;


@Mapper
public interface DocumentMapper {

	public int regist(DocumentVO vo);
	
	// 파일 업로드(Insert)
	public void registFile(DocumentUploadVO vo);
	
	// 학습 - 학습 자료 조회 - 내용
	public ArrayList<DocumentVO> getList(@Param("criteria") Criteria criteria);
	public int getTotal();
	
	// 게임 컨텐츠 삭제 - del_check 값 N으로 변경
	public int learnContentDelete(int docu_no);
	
	// 학습 - 학습 자료 조회 - 내용
	public ArrayList<DocumentVO> delList(@Param("criteria") Criteria criteria);
	public int getNoTotal();
}
