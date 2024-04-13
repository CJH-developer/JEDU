package com.geomin.project.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

@Configuration
public class JTwoPageVO implements WebMvcConfigurer {
	private JTwoCriteria JTwo;

	private int JTwoPage;
	private int JTwoAmount;
	private int JTwoTotal;

	private int JTwoFirst;
	private int JTwoEnd;
	private boolean JTwoPrev;
	private boolean JTwoNext;


	private int JTwoRealEnd;





	private List<Integer> JTwoPageFirst;



	public JTwoPageVO(JTwoCriteria JTwo,  int JTwoTotal) {
		this.JTwoPage = JTwo.getJTwoPage();
		this.JTwoAmount = JTwo.getJTwoAmount();
		this.JTwoTotal = JTwoTotal;
		this.JTwo = JTwo;

		this.JTwoEnd = (int) (Math.ceil(this.JTwoPage / 5.0) * 5);

		this.JTwoFirst = this.JTwoEnd - 5 + 1;

		this.JTwoRealEnd = (int) (Math.ceil(this.JTwoTotal / (double) this.JTwoAmount));

		if (this.JTwoEnd > this.JTwoRealEnd) {
			this.JTwoEnd = this.JTwoRealEnd;
		}

		this.JTwoPrev = this.JTwoFirst > 1;

		this.JTwoNext = this.JTwoRealEnd > this.JTwoEnd;

		this.JTwoPageFirst = IntStream.rangeClosed(this.JTwoFirst, this.JTwoEnd).boxed().collect(Collectors.toList());
	}
 

}
