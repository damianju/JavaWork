package com.lec.java.inherit04;

public class Car extends Vehicle {
	
	int oil;
	public Car() { //Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor
		// 부모클래스의 기본 생성자 호출 --> Vehicle()
		// 명시적인 super 생성자가 없으면 부모의 기본 생성자를 호출하게 됨.
		System.out.println("Car() 생성");
	}
	
	public Car(int oil) {
		// super()는 반드시 생성자 코드의 '첫번째' 문장
		super();  // super: 부모를 의미, super()<--부모의 기본 생성자를 호출 //Constructor call must be the first statement in a constructor
		//Implicit super constructor Vehicle() is undefined. Must explicitly invoke another constructor
		this.oil =oil;
		System.out.println("Car(int) 생성: oil="+oil);
	}
	
	public Car(int speed, int oil) {
		super(speed); // super(int) <--- 부모생성자 호출 //The constructor Vehicle(int) is undefined
		this.oil = oil;
		System.out.println("Car(int,int) 생성: speed ="+speed +"oil="+oil);
	}
	
	public Car(double value) {
		//super(100);  // super()와 this() 양립 불가
		this(555,(int)value); // 생성자 위임(delegation)
		System.out.println("Car(double) 생성: value="+value);
		
	}

}
