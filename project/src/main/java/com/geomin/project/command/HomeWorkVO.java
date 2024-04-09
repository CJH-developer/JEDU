package com.geomin.project.command;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public int leftDays() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date regDate = sdf.parse(this.homework_regdate);
        Date dueDate = sdf.parse(this.homework_duedate);
        long diff = dueDate.getTime() - regDate.getTime();
		
        return (int) (diff / (24 * 60 * 60 * 1000));
		
	}
	
}
