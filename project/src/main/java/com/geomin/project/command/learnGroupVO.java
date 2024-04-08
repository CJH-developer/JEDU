package com.geomin.project.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class learnGroupVO {
	public String user_no;
	public String game_no;
	public String sg_name;
	public String sg_level;
	public String sg_capa;
	public String sg_regdate;
	public String sg_enddate;
	public String sg_plus;
	public String sg_grouplimit;
}