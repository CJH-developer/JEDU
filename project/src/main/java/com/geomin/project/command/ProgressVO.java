package com.geomin.project.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgressVO {
	
	public String sg_no;
	public String user_no;
	public String sg_name;
	public String sg_level;
	public Integer sg_class;

	//Homework_History
	private String homework_submit;
	
}
