package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용

		for (int dan = 2; dan <= 9; dan++) {

			System.out.println(dan + "단");
			for (int n = 1; n <= 9; n++) {
				System.out.println(dan + "x" + n + "=" + (dan * n));
			}
			System.out.println();
		}

//		int i;
//		int j;
//		for (i=1, j=2; 

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int i = 2;
		while (i <= 9) {
			System.out.println(i + "단");
			int j = 1;
			while (j <= 9) {
				System.out.println(i + "x" + j + "=" + (i * j));
				j++;
			}
			System.out.println();
			i++;
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
