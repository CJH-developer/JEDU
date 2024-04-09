package com.geomin.project.gameContentService;



import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.UploadVO;

public interface GameContentService {

	// 게임 - 게임컨텐츠 등록
	public int regist(GameContentVO vo, List<MultipartFile> list);
	
	// 게임 - 게임컨텐츠 조회 - 내용
	public ArrayList<GameContentVO> getList();
	
}
