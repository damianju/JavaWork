package com.lec.java.static03;

import java.util.Calendar;

public class Static03Main {

// Singleton 디자인 패턴
// 생성되는 인스턴스가 최대 1개까지만 허용해야 하는 패턴설계

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");

		// Test t1 = new Test(); //The constructor Test() is not visible
		// Test t2 = new Test();

		Test t1 = Test.getInstance();
		System.out.println("t1: num=" + t1.getNum());
		t1.setNum(123);
		System.out.println("t1: num=" + t1.getNum());

		Test t2 = Test.getInstance();
		System.out.println("t2: num=" + t2.getNum());
		t2.setNum(500);
		System.out.println("t1: num=" + t1.getNum());

		// Singleton 사용예
		// Calendar c= new Calendar();

		Calendar c = Calendar.getInstance();

	} // end main()

} // end class Static03Main
