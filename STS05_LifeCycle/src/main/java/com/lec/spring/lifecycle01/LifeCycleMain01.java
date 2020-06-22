package com.lec.spring.lifecycle01;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Score;

public class LifeCycleMain01 {
	 public static void main(String[] args) {
		 System.out.println("Main 시작");
		 // new GenericXMl.. // 생성 + 설정
		 // 먼저 컨테이너 생성
		 GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); // 생성
		 System.out.println("컨테이너 생성 완료");
		 
		 // 나중에 설정을 load 할 수 있다
		 ctx.load("classpath:appCtx01_A.xml");
		 System.out.println("설정 load 완료");
		 
		 ctx.refresh(); // < -- refresh() 해야 제대로 설정(빈 생성) 완료 된다.
		 System.out.println("컨테이너 refresh 완료");
		 
		 Score score1 = ctx.getBean("score1", Score.class);
		 System.out.println(score1);
		 
		 ctx.close();
		 
		 System.out.println("Main 종료");
	}
}
