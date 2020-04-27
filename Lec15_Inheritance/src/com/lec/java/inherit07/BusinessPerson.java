package com.lec.java.inherit07;

public class BusinessPerson extends Person {

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// 메소드 재정의(Overriding)
	@Override // annotation
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + company);
		super.showInfo();
	}

//	public void showInfo() {
//		super.showInfo();
//		System.out.println("회사: "+company);
//	}

	// 메소드 중복정의(Overloading)
	public void showInfo(int id) {
		System.out.println("id:" + id);
		showInfo();

	}

	// alt + shift + S, V

	//@Override
	//public void whoAreYou() { //Cannot override the final method from Person
		//super.whoAreYou();
	//}

	@Override
	public String toString() { // 객체 표현

		return "BusinessPerson:" + getName() + " " + company;
	}

}
