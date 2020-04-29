package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = n; i > 0; i--) {
			if (i <= n - 1) {
				for(int z=i; z >0; z--) {
				System.out.print(" ");
				}
			}
			for (int j = 0; j < i; j++) {

				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();

	}

}
