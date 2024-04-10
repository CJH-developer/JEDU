package com.geomin.project.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JTwoPageVO {
	private JTwoCriteria JTwo;

	private int JTwoPage;
	private int JTwoAmount;
	private int JTwoTotal;
	private List<Integer> JTwoPageFirst;
	private int JFirst;
	private int JEnd;
	private boolean JPrev;
	private boolean JNext;


	private int JRealEnd;

	private JCriteria JCri;

	private List<Integer> JPageList;

	private List<Integer> JTwoPageList;

	public JTwoPageVO(JTwoCriteria JTwo,  int JTwoTotal) {
		this.JTwoPage = JTwo.getJTwoPage();
		this.JTwoAmount = JTwo.getJTwoAmount();
		this.JTwoTotal = JTwoTotal;
		this.JTwo = JTwo;

		this.JEnd = (int) (Math.ceil(this.JTwoPage / 5.0) * 5);

		this.JFirst = this.JEnd - 5 + 1;

		this.JRealEnd = (int) (Math.ceil(this.JTwoTotal / (double) this.JTwoAmount));

		if (this.JEnd > this.JRealEnd) {
			this.JEnd = this.JRealEnd;
		}

		this.JPrev = this.JFirst > 1;

		this.JNext = this.JRealEnd > this.JEnd;

		this.JTwoPageFirst = IntStream.rangeClosed(this.JFirst, this.JEnd).boxed().collect(Collectors.toList());
	}

}
