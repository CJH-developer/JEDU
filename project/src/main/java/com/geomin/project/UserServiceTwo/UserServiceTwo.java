package com.geomin.project.UserServiceTwo;

import java.util.ArrayList;

import com.geomin.project.command.GameContentVO;
import com.geomin.project.util.JTwoCriteria;

public interface UserServiceTwo {
	public ArrayList<GameContentVO> MyList(JTwoCriteria JTwo);
	public int JTwoTotal(JTwoCriteria JTwo);
}
