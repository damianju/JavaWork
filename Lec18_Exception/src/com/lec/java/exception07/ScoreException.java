package com.lec.java.exception07;

// 우리가 만드는 예외 클래스
// Exception 또는 RuntimeException 클래스를 상속 받아서 만듬

// TODO : Excettion 을 상속받아 예외 클래스 정의하기
public class ScoreException extends Exception {

	// 생성자
	public ScoreException() {
			super("나이 입력 오류"); // 예외 메세지 설정
			// Exception(String message) 생성자 호출
	} 
	
	public ScoreException(String msg) {
		super(msg);
	}
	
	
} // end class ScoreException




