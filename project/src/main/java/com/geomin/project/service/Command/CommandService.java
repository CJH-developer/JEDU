package com.geomin.project.service.Command;

import java.util.ArrayList;

import com.geomin.project.command.GameContentVO;

import com.geomin.project.util.JCriteria;

public interface CommandService {
	public ArrayList<GameContentVO> getList(JCriteria JCri);
	public int getTotal(JCriteria JCri);
	//민상이 한거
}
