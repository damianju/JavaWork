package 반복제어문2.형성평가08;

import java.util.Scanner;

// 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			
		for (int j = 1; j <= m; j++) {
			System.out.print(j+(j*i)+"\t");
			
			
		}
		System.out.println();
			
		}
		
		sc.close();
	}

}
