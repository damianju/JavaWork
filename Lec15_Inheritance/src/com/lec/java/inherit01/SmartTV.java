package com.lec.java.inherit01;

public class SmartTV {
	
	boolean isPowerOn;
	int channel;
	int volume;
	String ip; // SmartTV에서 새로이 추가된 필드
	
	// 메소드
	public void displayInfo() {
		System.out.println("--- TV 현재 상태---");
		System.out.println("전원: " + isPowerOn );
		System.out.println("채녈: "+ channel);
		System.out.println("볼륨: "+ volume);
		System.out.println("IP주소: "+ ip); //SmartTV에서 추가된 코드
	}

}
