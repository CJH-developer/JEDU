package com.geomin.project.board.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.geomin.project.command.FaqVO;
import com.geomin.project.command.NoticeVO;
import com.geomin.project.command.QnaVO;



@Mapper
public interface BoardMapper {

	// 공지사항 등록
	public int regist(NoticeVO vo);
	// faq 등록
	public int faqRegist(FaqVO vo);
	// qna 등록
	public int qnaRegist(QnaVO vo);
	
	// 공지사항 조회
	public ArrayList<NoticeVO> getNotice();
	// faq 조회
	public ArrayList<FaqVO> getFaq();
	// qna 조회
	public ArrayList<QnaVO> getQna();
	
	//공지사항 삭제
	public int NoticeDelete(int notice_no);
	//faq 삭제
	public int FaqDelete(int faq_no);
	//qna삭제
	public int qnaDelete(int qna_no);
	
	// 공지사항 수정
	public NoticeVO noticeModify(int notice_no);
	public int noticeModifyUpdate(NoticeVO vo);
	
	//faq 수정
	public FaqVO faqModify(int faq_no);
	public int faqModifyUpdate(FaqVO vo);
	
	// qna 수정
	public QnaVO qnaModify(int qna_no);
	public int qnaModifyUpdate(QnaVO vo);
}
