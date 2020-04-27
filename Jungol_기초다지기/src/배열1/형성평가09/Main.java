package 배열1.형성평가09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		int[] arr1 = new int[100];
		int[] arr2 = new int[100];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = sc.nextInt();
			if (arr1[i] == 0) {
				return;
			} else if (arr1[i] % 2 == 1) {
				arr2[i] = arr1[i] * 2;
				cnt++;
			} else if (arr1[i] % 2 == 0) {
				arr2[i] = arr1[i] / 2;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+" ");
		}

		sc.close();
	}

}
