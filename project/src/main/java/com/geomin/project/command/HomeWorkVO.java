package com.geomin.project.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeWorkVO {
	public String user_no;
	public String homework_name;
	public String homework_content;
	public String homework_level;
	public String homework_duedate;
	public String homework_regdate;
	public String homework_modidate;
	public String sg_no;
}