package com.geomin.project.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geomin.project.command.NoticeVO;

@Service("BoardService")
public class BoardRepository implements BoardService{

	@Autowired
	private BoardMapper boardMapper;

	// 공지사항 등록
	@Override
	public int regist(NoticeVO vo) {

		return boardMapper.regist(vo);
	}

}
