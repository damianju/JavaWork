package 반복제어문2.형성평가09;

import java.util.Scanner;

// 행과 열의 수를 입력받아 다음과 같이 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
	
		
		for (int i = 1; i <= n; i++) {
			
		for (int j = 1; j <= n; j++) {
			System.out.print("("+i+", "+j+")"+"\t");
			
			
		}
		System.out.println();
			
		}
		
		sc.close();
	}

}
