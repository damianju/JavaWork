package 선택제어문.형성평가01;

// 두 개의 정수를 입력받아 큰 수에서 작은 수를 뺀 차를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int diff;
		
		diff= (a>=b)? (a-b) : (b-a);
		
		System.out.println(diff);
		
		sc.close();
		

	}

}
