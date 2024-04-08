package com.geomin.project.PAGEVO;


import lombok.Data;

@Data 


//여기는 페이지하고 페이지에 나오는 리스트 량을 설정하는 클래스
public class JCriteria {
	private int Jpage;
	private int Jamount;
	
	/////////검색관련 변수를 쓰면 좋을것 같아요


public JCriteria() {
	this.Jpage=1;
	this.Jamount = 10;
}



public JCriteria(int page, int amount) {
	super();
	this.Jpage=page;
	this.Jamount=amount;
}


public int getPageFirst() {
	return (Jpage-1) * Jamount;
}
}
