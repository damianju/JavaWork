package com.lec.java.while03;

public class While03Main {

	public static void main(String[] args) {
		System.out.println("while 연습");

		// 1 ~ 10 까지 중에서 홀수만 출력

		int i = 1;
		while (i <= 10) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
			i++;
		} // end while

	} // end main()

} // end class While03Main
