package 배열1.자가진단06;

import java.util.Scanner;

// 10개의 정수를 입력받아 그 중 가장 작은 수를 출력하는 프로그램을 작성하시오.(입력받을 정수는 1000을 넘지 않는다.)
public class Main {

	public static void main(String[] args) {
		int[] arr = new int[10];
		int min =1000;
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(min>arr[i])
				min = arr[i];
		}
		System.out.println(min);
		sc.close();

	}

}
