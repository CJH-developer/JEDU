package com.geomin.project.gameContentService;



import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;


import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.UploadVO;

@Mapper
public interface GameContentMapper {

	public int regist(GameContentVO vo);
	
	// 파일 업로드(Insert)
	public void registFile(UploadVO vo);
	
	// 게임 - 게임컨텐츠 조회 - 내용
	public ArrayList<GameContentVO> getList();

}
