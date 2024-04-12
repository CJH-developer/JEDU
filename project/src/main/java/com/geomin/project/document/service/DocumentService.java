package com.geomin.project.document.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.geomin.project.command.DocumentVO;
import com.geomin.project.util.Criteria;

public interface DocumentService {

	public int regist(DocumentVO vo, List<MultipartFile> list);
	
	// 학습 - 학습 자료 조회 - 내용
	public ArrayList<DocumentVO> getList(Criteria criteria);
	public int getTotal();
	
	// 게임 컨텐츠 삭제 - del_check 값 N으로 변경
	public int learnContentDelete(int docu_no);
	
	// 학습 - 학습 자료 조회 - 내용
	public ArrayList<DocumentVO> delList(Criteria criteria);
	public int getNoTotal();
}
