package com.lec.spring.profile4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileMain4 {

	public static void main(String[] args) {
		String config = "run"; // "run" / "dev" 설정
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		// 현재 활성화할 profile이 무엇인지 세팅
		ctx.getEnvironment().setActiveProfiles(config);
		
		// 해당 profile 의 설정 파일만 설정된다
		ctx.load("appCtx4_dev.xml", "appCtx4_run.xml");
		ctx.refresh();
		
		ServiceInfo info = ctx.getBean("serverInfo", ServiceInfo.class);
		System.out.println("ip:" +info.getIpNum());
		System.out.println("port:" +info.getPortNum());
		
		ctx.close();
	}

}
