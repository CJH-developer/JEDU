package com.geomin.project.util;


import lombok.Data;

@Data //여기는 페이지하고 페이지에 나오는 리스트 량을 설정하는 클래스
public class JTwoCriteria {
	private int JTwoPage;
	private int JTwoAmount;
	private Integer game_no;//여기에 없다고 오류가 떠서 추가함
	private String searchName; //상품이름
	private String searchContent; //상품내용
	private String searchPrice; //상품가격 정렬방식
	private String startDate; //날짜조회 시작
	private String endDate; //날짜조회 끝
	private String pageVOVO;
	private String searchNa;
	private String searchtitle;
	private String search_product;
	
	/////////검색관련 변수를 쓰면 좋을것 같아요


public JTwoCriteria() {
	this.JTwoPage=1;
	this.JTwoAmount = 4;

	
}



public JTwoCriteria(int JTwoPage, int JTwoAmount) {
	super();
	this.JTwoPage=JTwoPage;
	this.JTwoAmount=JTwoAmount;
}


public int getJTwoPageFirst() {
	return (JTwoPage-1) * JTwoAmount;
}
}
