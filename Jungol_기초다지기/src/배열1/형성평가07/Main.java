package 배열1.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		int min = 999;
		
		int arr[] = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			
			if(arr[i] == 999)  break;
			
			if(max<arr[i])
				max = arr[i];
			if(min>arr[i])
				min = arr[i];
			
		}
		System.out.println("max : "+max);
		System.out.println("min : "+min);
		
		sc.close();
	}

}
