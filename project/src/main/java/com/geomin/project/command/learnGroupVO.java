
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
	private String sg_no;
	private String user_no;
	private String game_no;
	private String sg_name;
	private String sg_level;
	private String sg_capa;
	private String sg_regdate;
	private String sg_enddate;
	private String sg_plus;
	private String sg_grouplimit;
	
	
	// gameContent 가져옴
	private String game_title;
	private Integer game_target_level;
	private Integer game_price;
	private Integer game_discount_price;
	private String game_content;
	private Integer game_count;
	private String game_sub_startDate;
	private String game_sub_endDate;
	
	// USER 가져옴
	public String user_id;
	public String user_name;
	public String user_level;
	public String user_email;
	public String user_phone;
	public String user_birth;
	public String user_address;
	public String user_gender;
	
	public String user_regdate;
}

