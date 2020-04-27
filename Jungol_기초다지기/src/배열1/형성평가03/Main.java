package 배열1.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum1 = 0;
		int sum2 = 0;
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(i%2==0) sum1+= arr[i];
			if(i%2==1) sum2+= arr[i];
		}
		
		System.out.println("odd : " +sum1);
		System.out.println("even : " +sum2);
		
		sc.close();

	}

}
