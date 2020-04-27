package 배열1.형성평가01;

import java.util.Scanner;

//10개의 문자를 입력받아 마지막으로 입력받은 문자부터 첫 번째 입력받은 문자까지 차례로 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = new String[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();	
		}
		
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		
	
		
		sc.close();
	}

}
