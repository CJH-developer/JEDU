package com.geomin.project.service.command;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.util.JCriteria;
import com.mysql.cj.x.protobuf.MysqlxCrud.DataModel;

@Mapper
public interface CommandMapper {
	public ArrayList<GameContentVO> getList(JCriteria JCri);
	public int getTotal(JCriteria JCri);

	//민상이 한거
}
