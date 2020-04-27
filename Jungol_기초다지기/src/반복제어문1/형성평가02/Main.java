package 반복제어문1.형성평가02;

import java.util.Scanner;

//0 이상의 정수들이 공백으로 구분되어 반복적으로 주어진다.
//
//0이 입력되면 반복문을 멈추고 그 전까지 입력받은 수들에 대하여
//
//홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int odd = 0;
		int even = 0;

		while (true) {
			int n = sc.nextInt();
			if (n % 2 == 0) {
				even++;
			} else if (n % 2 == 1) {
				odd++;
			} else if (n == 0) {
				break;
			}

		}
		System.out.println("even : " + even);
		System.out.println("odd : " + odd);

		sc.close();

	}

}
