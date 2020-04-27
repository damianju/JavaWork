package 배열1.자가진단03;

import java.util.Scanner;

// 10개의 문자를 입력받아서 첫 번째 네 번째 일곱 번째 입력받은 문자를 차례로 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		
		System.out.println(arr[1-1] + "\t"+arr[4-1] + "\t"+ arr[7-1]);
		sc.close();

	}

}
