package 배열1.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum1 =0;
		int sum2 =0;
		float avg = 0;
		
		int [] arr = new int[10];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			if(i%2 ==1) {
				sum1 += arr[i];
			} else {
				sum2 += arr[i];
			}
		}
		
		avg = (float) sum2 / (float) (arr.length/2);
		System.out.println("sum : " + sum1);
		System.out.printf("avg : %.1f", avg);
		
		sc.close();
	} // end main()
	
} // end class

