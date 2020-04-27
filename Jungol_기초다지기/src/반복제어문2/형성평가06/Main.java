package 반복제어문2.형성평가06;

import java.util.Scanner;

//두 개의 정수를 입력받아 두 정수 사이(두 정수를 포함)에 3의 배수이거나 5의 배수인 수들의 합과 평균을 출력하는 프로그램을 작성하시오.
//(평균은 반올림하여 소수 첫째자리까지 출력한다.)

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int cnt = 0;
		int sum = 0;
		double avg = 0; 
		
		if(n<=m) {
			for (int i = n; i <=m; i++) {
				if ((i%3==0) || (i%5==0)) {
					cnt++;
					sum =sum +i;
					avg = ((double) sum / (double)cnt);
				}
			}
		} else {
			for (int i = m; i <=n; i++) {
				if ((i%3==0) || (i%5==0)) {
					cnt++;
					sum =sum +i;
					avg = ((double)sum / (double) cnt);
				}
			}
		}
		
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f", avg);
		
		sc.close();
	}

}
