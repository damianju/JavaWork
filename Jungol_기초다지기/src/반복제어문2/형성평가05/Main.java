package 반복제어문2.형성평가05;

import java.util.Scanner;

// 10개의 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 개수를 각각 구하여 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		int even = 0;
		int odd = 0;

		for (int i = 0; i < 10; i++) {
			n = sc.nextInt();
			if (n % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}
		System.out.println("even : " + even);
		System.out.println("odd : " + odd);

		sc.close();

	}

}
