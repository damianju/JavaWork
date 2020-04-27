package 반복제어문2.형성평가03;

import java.util.Scanner;

//정수를 입력받아서 1부터 입력받은 정수까지의 5의 배수의 합을 구하여 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int sum = 0;

		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
