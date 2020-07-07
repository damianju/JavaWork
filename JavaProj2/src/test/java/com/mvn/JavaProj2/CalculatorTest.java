package com.mvn.JavaProj2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	
	// JUnit은 멤버 필드 방식을 비추한다 --> 특정 테스트 결과가 다른 테스트 결과에 영향을 줄 수 있다.
	// 각각의 '테스트'는 '독립적'으로 실행되는 것을 봊ㅇ하는 것을 원칙으로 한다.
	
	// 각 테스트 전/후에 공통으로 수행해야 할 코드가 필요하다면
	// @Before, @After
	
	
	/* private Calculator cal = new Calculator(); */
	
	private Calculator cal;
	
	@Before // 테스트 메소드 실행 전에 수행할 메소드
	public void setUp() {
		System.out.println("[테스트 전]");
		cal = new Calculator();
	}
	
	@After // 테스트 메소드 실행 후에 수햏할 메소드
	public void shutDown() {
		System.out.println("[테스트 후]");
	}
	
	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		int result = cal.add(10, 20);
		assertEquals(30, result);
	}
	
	@Test
	public void testSub() {
		System.out.println("testSub()");
		int result = cal.sub(10, 20);
		assertEquals(-10, result);
	}
	
	@Test
	public void testMul() {
		System.out.println("testMul()");
		int result = cal.mul(10, 20);
		assertEquals(200, result);
	}
	
	@Test
	public void testDiv() {
		System.out.println("testDiv()");
		int result = cal.div(10, 20);
		assertEquals(0, result);
	}








}
