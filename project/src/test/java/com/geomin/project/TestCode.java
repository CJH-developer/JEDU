package com.geomin.project;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.geomin.project.UserServiceTwo.UserServiceTwoMapper;
import com.geomin.project.command.GameContentVO;
import com.geomin.project.command.UserVO;
import com.geomin.project.gameContentService.GameContentMapper;
import com.geomin.project.service.command.CommandMapper;
import com.geomin.project.user.service.UserMapper;
import com.geomin.project.util.JTwoCriteria;

import lombok.Builder;


@SpringBootTest
public class TestCode {
	
//	@Autowired
//	CommandMapper commandMapper;
 @Autowired
 public GameContentMapper gameContentMapper; 
 @Autowired
 public UserServiceTwoMapper userTwoServiceMapper;
	
//	@Test
//	public void test01() {
//		for(int i = 1; i <= 20; i++) {
//			UserVO vo=UserVO.builder()
//					.user_id("aa12")
//					.user_pw("{noop}u123")
//					.user_name("조민상")
//					.user_level("1")
//					.user_role("ROLE_ADMIN")
//					.user_email("alstkdwh24@naver.com")
//					.user_phone("01043324254")
//					.user_birth("2000-12-12")
//					.user_address("1")
//					.user_gender("남")
//					.build();
//					
//		
//		userMapper.regist(vo);
//			
//		
//		}
	
//	}
	
	@Test
	public void text02() {
		for(int i = 1; i <= 7; i++) {
			GameContentVO vo=GameContentVO.builder()
					.user_no("12")
					.game_title("ss")
					.game_target_level(1)
					.game_price(1)
					.game_discount_price(1)
					.game_content("sasa")
					.game_count(12)
					.game_sub_startDate("2024-02-15")
					.game_sub_endDate("2024-04-14")
					.game_content("sdaasda")
					.game_title("눈오는 일기")
					.game_price(20000)
					.purchase_date(LocalDate.of(2024, 3, 15))
					.build();
			
			
			gameContentMapper.regist(vo);
			
	}
		
}

}
