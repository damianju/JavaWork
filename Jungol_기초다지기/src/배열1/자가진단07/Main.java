package 배열1.자가진단07;

import java.util.Scanner;

//10개의 정수를 입력받아 100 미만의 수 중 가장 큰 수와 100 이상의 수 중 가장 작은 수를 출력하는 프로그램을 작성하시오.
//
//(입력되는 정수의 범위는 1이상 10,000 미만이다. 만약 해당하는 수가 없을 때에는 100 을 출력한다.)
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		
		int max = 0;
		int min = 10000;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			
			if(arr[i]< 100) {
				if(max< arr[i]) {
					max = arr[i];
				} 
			} 
			
			if(arr[i]>= 100) {
				if(min > arr [i]) {
					min = arr[i];
				}
				
			}	
		}
		
		if(max == 0) {
			max = 100;
		}
		
		if(min == 10000) {
			min = 100;
		}
		
		System.out.print(max);
		System.out.print(" ");		
		System.out.print(min);
		
		sc.close();

	}

}
