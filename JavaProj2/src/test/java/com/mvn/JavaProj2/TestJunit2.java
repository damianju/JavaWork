package com.mvn.JavaProj2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class TestJunit2 extends TestCase{

	@Before
	public void before() {
		System.out.println("[before()]");
	}
	@After
	public void after() {
		System.out.println("[after()]");
	}
	
	@BeforeClass
	public static void beforeCLass() {
		System.out.println("<<beforeClass()>>");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("<<afterClass()>>");
	}
	
	@Test
	public void testA() {
		System.out.println("TestA()");
		System.out.println("No. of Test Case = "+ this.countTestCases());
		setName("A테스트");
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testB() {
		System.out.println("TestB()");
		System.out.println("No. of Test Case = "+ this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testC() {
		System.out.println("TestC()");
		System.out.println("No. of Test Case = "+ this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}
	@Test
	public void testD() {
		System.out.println("TestD()");
		System.out.println("No. of Test Case = "+ this.countTestCases());
		System.out.println("Test Case Name = " + this.getName());
	}

}
