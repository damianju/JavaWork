package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		Scanner sc = new Scanner(System.in);

		int[] a = new int[5];
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			System.out.println("점수 입력: ");
			a[i] = sc.nextInt();
			total += a[i];
		}
		double avg = (double) total / a.length;
		System.out.println("총점: " + total);
		System.out.println("평군: " + avg);

		System.out.println();

		// 최대값
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}

		}
		System.out.println("최댓값 = " + max);

		System.out.println();

		// 최소값
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			//min = (a[i] < min) ? a[i] : min;
		}
		System.out.println("최소값 = " + min);

		sc.close();

	} // end main()

} // end class Array04Main
