package 배열1.자가진단02;

import java.util.Scanner;

// 정수 10 개를 저장할 수 있는 배열을 만들어서 1 부터 10 까지를 대입하고 차례대로 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		int[] arr = new int[11];
		
		for (int i = 1; i <= 10; i++) {
			arr[i] = i;
		System.out.print(arr[i]+"\t");
		}
		
	}
	

}
