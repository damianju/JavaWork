package com.lec.spring.di04;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Student;

public class DIMain04 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		GenericApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx.xml");
		System.out.println("--컨테이너 생성--");
		
		Student stu1 = ctx.getBean("Hong", Student.class);
		System.out.println(stu1);
		
		Student stu2 = ctx.getBean("Joo", Student.class);
		System.out.println(stu2);
		
		System.out.println();
		stu2.getScore().setKor(100);
		System.out.println(stu2);
		
		System.out.println(stu1); // 홍의 점수도 바뀜. 홍이나 주 모두 같은 score 객체를 referencing하고 있음.
		
		ctx.close();
		System.out.println("Main 종료");
	}

}
