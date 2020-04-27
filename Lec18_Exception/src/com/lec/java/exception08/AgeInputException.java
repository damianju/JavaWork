package com.lec.java.exception08;

// TODO : Exceptio 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception {
	
	// 생성자
	public AgeInputException() {
		super("나이 입력 오류"); //예외 메세지 설정
	}
	
	public AgeInputException(String msg) {
		super(msg);
	}

	
} // end class AgeInputException
