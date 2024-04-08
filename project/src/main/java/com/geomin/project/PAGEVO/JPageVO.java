package com.geomin.project.PAGEVO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//페이지 누르는 바 안에 리스트를 만들어주는 기능과 페이지 리스트에 얼마만큼의 페이지를 넣을 건지를 정해주는 클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JPageVO {
	private int Jfirst;
	private int Jend;
	private boolean Jprev;
	private boolean Jnext;
	
	
	
	private int Jpage;
	private int Jamount;
	private int Jtotal;
	
	private int Jrealend;
	
	
	
	private JCriteria Jcri;
	
	
	
	private List<Integer> JpageList;
	
	
	
	
	public JPageVO(JCriteria Jcri,int Jtotal) {
		this.Jpage=Jcri.getJpage();
		this.Jamount=Jcri.getJamount();
		
	this.Jend=(int)(Math.ceil(this.Jpage/10.0) * 10);
	
	
	this.Jfirst=this.Jend- 10 + 1;
	
	this.Jrealend= (int)(Math.ceil(this.Jtotal / (double)this.Jamount));
	
	
	
	
	
	if(this.Jend > this.Jrealend) {
		this.Jend = this.Jrealend;
	}
	
	
	this.Jprev =this.Jfirst>1;
	
	
	
	
	this.Jnext = this.Jrealend>this.Jend;
	
	
	this.JpageList=IntStream.rangeClosed(this.Jfirst,this.Jend)
							.boxed()
							.collect(Collectors.toList());
	}
}
