package com.geomin.project.board.service;

import org.apache.ibatis.annotations.Mapper;

import com.geomin.project.command.NoticeVO;

@Mapper
public interface BoardMapper {

	// 공지사항 등록
	public int regist(NoticeVO vo);
}
