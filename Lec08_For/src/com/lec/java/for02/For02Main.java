package com.lec.java.for02;

public class For02Main {

	public static void main(String[] args) {
		System.out.println("For문 - 구구단 출력");

		// 2x1 =2
		// 2x2 =4
		// ...
		// 2x9 =18

		for (int i = 1; i <= 9; i++) {
			System.out.println("2x" + i + "=" + (2 * i));
		}

		// 구구단 4단
		for (int i = 1; i <= 9; i++) {
			System.out.println("4x" + i + "=" + (4 * i));
		}
		// 2X2=4
		// 3X3+9
		// ....
		// 9X9=81

		for (int i = 2; i <= 9; i++) {
			System.out.println(i + "x" + i + "=" + (i * i));
		} // end for

	} // end main()

} // end class For02Main
