package com.geomin.project.document.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.geomin.project.command.DocumentVO;

public interface DocumentService {

	public int regist(DocumentVO vo, List<MultipartFile> list);
	
	// 학습 - 학습 자료 조회 - 내용
	public ArrayList<DocumentVO> getList();
}
