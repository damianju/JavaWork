package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");

		// 방법 1 덧셈
		Operable op1 = new Operation();
		double result1 = op1.operate(2, 1);
		System.out.println(result1);

		// 방법 2 뺄셈
		System.out.println(new Operable() {

			@Override
			public double operate(double x, double y) {

				return x - y;
			}
		}.operate(2, 1));

		// 방법 3 제곱연산

		Operable op2 = (x, y) -> Math.pow(x, y);
		double result2 = op2.operate(2, 2);
		System.out.println(result2);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

interface Operable {
	public abstract double operate(double x, double y);
}

class Operation implements Operable {

	@Override
	public double operate(double x, double y) {

		return x + y;
	}

}