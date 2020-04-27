package 반복제어문2.자가진단05;

import java.util.Scanner;

// 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int i = 0;
		int j = 0;
		int arr[] = new int[10];
		for (int k = 0; k < arr.length; k++) {
			arr[k] = sc.nextInt();
			if (arr[k] % 3 == 0)
				i++;
			if (arr[k] % 5 == 0)
				j++;

		}

		System.out.println("Multiples of 3 : " + i);
		System.out.println("Multiples of 5 : " + j);
		sc.close();

	}

}
