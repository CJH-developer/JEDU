package com.geomin.project.service.command;

import java.util.ArrayList;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.util.JCriteria;
import com.mysql.cj.x.protobuf.MysqlxCrud.DataModel;

public interface CommandService {
	public ArrayList<GameContentVO> getList(JCriteria JCri);
	public int getTotal(JCriteria JCri);

	//민상이 한거

}
