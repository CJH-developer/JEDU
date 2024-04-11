package com.geomin.project.document.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.geomin.project.command.DocumentUploadVO;
import com.geomin.project.command.DocumentVO;


@Mapper
public interface DocumentMapper {

	public int regist(DocumentVO vo);
	
	// 파일 업로드(Insert)
	public void registFile(DocumentUploadVO vo);
	
	// 학습 - 학습 자료 조회 - 내용
	public ArrayList<DocumentVO> getList();
}