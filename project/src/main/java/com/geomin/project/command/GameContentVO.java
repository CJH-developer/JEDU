package com.geomin.project.command;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameContentVO {
	private Integer game_no;
	private String game_title;
	private Integer game_target_level;
	private Integer game_price;
	private Integer game_discount_price;
	private String game_content;
	private Integer game_count;
	private String user_no;
	private String game_sub_startDate; //GAME_SUB_REGDATE라고 테이블파일에 되어있어서 바꿈니다.
	private String game_sub_endDate;
	
	
	//조인해서 받아오는값
	private LocalDate purchase_date;
	private String sg_name;
	private String sg_level;
	

   
	private String filename;  // 작성자가 업로드한 파일명
	private String filepath;
	private String uuid;

	}
