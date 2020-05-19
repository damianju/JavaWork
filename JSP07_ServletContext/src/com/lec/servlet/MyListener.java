package com.lec.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
	// 웹어플이케이션(컨텍스트) 종료할 때 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("JSP07 어플리케이션 종료");
	}
	
	// 웹어플이케이션(컨텍스트) 시작할 때 호출
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("JSP07 어플리케이션 시작");
	}
	
}
