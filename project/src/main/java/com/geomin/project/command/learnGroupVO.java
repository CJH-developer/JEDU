package com.geomin.project.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	private String sgj_pro;
	private String sg_class;
	
	
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
	private String user_id;
	private String user_name;
	private String user_level;
	private String user_email;
	private String user_phone;
	private String user_birth;
	private String user_address;
	private String user_gender;
	
	private String user_regdate;
	
	// 얘 하면 값이 안 불러와짐;;
    // 사용자 등록일을 yyyy년 MM월 dd일 형식으로 반환하는 메서드
//    public String getUserRegDate() {
//        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
//
//        try {
//            Date date = inputFormat.parse(user_regdate);
//            return outputFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // 처리 중 예외 발생 시 null 반환 또는 적절한 오류 처리
//            return null;
//        }
//    }
	
	
	
}
