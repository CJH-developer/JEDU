package com.geomin.project.board.service;

import com.geomin.project.command.NoticeVO;

public interface BoardService {

	// 공지사항 등록
		public int regist(NoticeVO vo);
}
