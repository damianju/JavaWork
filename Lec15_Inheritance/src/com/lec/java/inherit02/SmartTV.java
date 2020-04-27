package com.lec.java.inherit02;

// BasicTV
//  |_SmartTV

public class SmartTV extends BasicTV {
	String ip;

	public void displayInfo() {
		super.displayInfo();
		System.out.println("IP주소 : " + ip);

	}

}
