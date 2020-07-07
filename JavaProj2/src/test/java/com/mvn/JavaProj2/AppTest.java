package com.mvn.JavaProj2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mvn.JavaProj2.App;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
private App app = new App();
	
	@Test
	public void test1() {
//		if("welcome".equals(app.getWelcome())) {
//			System.out.println(true);
//		} else {
//			System.out.println(false);
//		}
		
		// assertXXX() 메소드 사용
		assertEquals("welcome", app.getWelcome());
		assertEquals("Hello", app.getHello());
		assertEquals("bye", app.getBye());
		
	}
	
	
	@Test
	public void test2() {
		assertEquals("Bye", app.getBye());
	}
	
	@Test
	public void test3() {
		assertEquals("hello", app.getHello());
	}
	
	
}
