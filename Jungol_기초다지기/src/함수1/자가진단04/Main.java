package 함수1.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int mx = getMax(arr);
		System.out.println(mx);
		
		sc.close();
	}
	public static int getMax(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			
			if(arr[i] < arr[i+1]) {
				int temp = arr[i+1];
				
			}
		}
		return max;
	}
	
}
