package com.lec.java.inherit07;

// final 클래스는 더 이상 상속 불가
// public final class Person

public class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void showInfo() {
		System.out.println("이름: "+name);
	}
	
	
	// final 메소드: 더 이상 오버리이딩 불가
	public final void whoAreYou() {
		System.out.println("이름: "+name);
	}

}
