package Evaluation01;

import java.util.Scanner;

// 실수 타입의 값을 두개 입력 받아서, 두개의 ‘합’과 ‘곱’ 을 출력하세요  (결과는 소숫점 한자리까지 출력하세요)
public class Main01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double n1 = sc.nextDouble();
		double n2 = sc.nextDouble();

		double sum = n1 + n2;
		double mul = n1 * n2;

		System.out.printf("%.1f", sum);
		System.out.println();
		System.out.printf("%.1f", mul);

		sc.close();
	}

}
