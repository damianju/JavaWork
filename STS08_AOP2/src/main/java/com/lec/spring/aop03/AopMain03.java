package com.lec.spring.aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.*;

public class AopMain03 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx3.xml");
		System.out.println("ctx생성");

		Service service21 = ctx.getBean("service21", Service.class);
		Service service22 = ctx.getBean("service22", Service.class);
		
		ServiceEx serviceEx31 = ctx.getBean("serviceEx31", ServiceEx.class);
		ServiceEx serviceEx32 = ctx.getBean("serviceEx32", ServiceEx.class);
		
		service21.doAction();
		service22.doAction();
		serviceEx31.doAction();
		serviceEx31.doWorking();
		serviceEx31.quitAction();
		serviceEx32.doAction();
		serviceEx32.doWorking();
		serviceEx32.quitAction();
		
		ctx.close();
		System.out.println("Main 종료");
	} // end main

} // end class
