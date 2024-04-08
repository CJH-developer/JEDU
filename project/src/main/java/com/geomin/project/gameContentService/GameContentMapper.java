package com.geomin.project.gameContentService;



import org.apache.ibatis.annotations.Mapper;


import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.UploadVO;


@Mapper
public interface GameContentMapper {

	public int regist(GameContentVO vo);
	public void registFile(UploadVO vo);
}