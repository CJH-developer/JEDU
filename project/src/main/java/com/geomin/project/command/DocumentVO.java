package com.geomin.project.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentVO {

	private Integer docu_no;
	private Integer docu_type;
	private Integer docu_category;
	private Integer docu_service;
	private String docu_title;
	private String docu_content;
	private String docu_path;
	private String game_title;
	
	private String filename; 
	private String filepath;
	private String uuid;
}