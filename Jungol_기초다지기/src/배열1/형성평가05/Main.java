package 배열1.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float [] arr = new float[6];
		float sum = 0;
		float avg = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextFloat();
			sum += arr[i];
		}
		
		avg = sum / arr.length;
		System.out.printf("%.1f",avg);
		
		sc.close();
	}

}
