package com.lec.java.array05;

import java.util.Scanner;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 * 1차원 배열 (one-dimensional array) 이라고 함
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");

		// 1차원 배열

		int[] arr1 = { 1, 2 };
		int[] arr2 = { 3, 4 };
		int[] arr3 = { 5, 6 };

		// 2차원 배열: (배열원소가 1차원 배열)
		// 1차원 배열 X 3개 갖고 있는 2차원 배열
		int[][] array = { { 1, 2 }, // array[0]
				{ 3, 4 }, // array[1]
				{ 5, 6 } // array[2]
		};

		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]);

		// * 흔히 2차원 배열을 '행'과 '열'로 표기(표현) 하기도 함
		// 위 array는 3행row X 2열column인 2차원 배열

		// 2차원 배열에서 length의 의미:
		// array.length: 2차원 배열의 원소, 즉 1차원배열의 개수
		// 행열의 개념에선 2차원 배열의 행(row)의 개수를 의미

		System.out.println("array.length: " + array.length);

		// array의 타입 >> int [][]
		// array[0]의 타입 >> int[]
		// array[0][0] >> int

		System.out.println("array[0].length: " + array[0].length);
		System.out.println("array[1].length: " + array[1].length);

		// 2차원 배열원소, for
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + " ");

			}
			System.out.println();
		}

		// TODO:
		// 2행 4열의 2차원배열을 만들어서
		// 아래와 같이 초기화하고 출력하기

		// 첫번째 배열 출력
		// 1 2 3 4
		// 5 6 7 8

		int[][] array2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		for (int x = 0; x < array2.length; x++) {
			for (int y = 0; y < array2[x].length; y++) {
				System.out.print(array2[x][y] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println(array);
		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		
		

	} // end main()

} // end class Array05Main
