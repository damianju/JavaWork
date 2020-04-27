package 반복제어문3.자가진단03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();
			
			for (int i = n; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}


			for (int a = 0; a < n; a++) {
				for (int b = 0; b <= a; b++) {
					System.out.print("*");
				}
				System.out.println();
			}

			sc.close();

		}


}
