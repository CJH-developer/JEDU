package com.geomin.project.gameContentService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.geomin.project.command.GameContentVO;


@Service("GameContentService")
public class GameContentServiceImpl implements GameContentService{

	@Autowired
	private GameContentMapper gameContentMapper;
	
	
	@Override
	public int regist(GameContentVO vo) {
		
		return gameContentMapper.regist(vo);
			
	}


}
