package com.lec.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

/*
Dependency Injection (DI, 의존주입)
필요한 객체는 누가 만들어 사용하나?

방법2 : 외부에서 만들어 주입 (injection)
	스프링 특징 의존주입 (Dependenty Injection) 사용
	즉 '외부' 에서 만들어 놓은 것을 가져옴.
*/

public class DIMain02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// 스프링 설정 파일 resource 명시
		String configLocation = "classpath:appCtx.xml";
		
		// ApplicationContext 객체를 만드는 시점에서 bean 객체가 생성된다
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		System.out.println("Application Context 컨테이너 생성 완료\n");
		
		// 외부에서 만들어진 객체 주입(injection)
		MessageBean msg = ctx.getBean("messageBean", MessageBean.class); // bean의 id값, bean의 타입(다형성)
		
		msg.sayHello();
		
		ctx.close(); // Application Context 컨테이너는 반드시 close()
		System.out.println("Main 종료");
		
		ApplicationContext ctx2;
		
	} // end main()

}
