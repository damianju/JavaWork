package 배열1.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum =0;
		int [] arr = new int[5];
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(i%2==0) sum += arr[i];
		}
		
		System.out.println(sum);
		
		sc.close();
	}

}
