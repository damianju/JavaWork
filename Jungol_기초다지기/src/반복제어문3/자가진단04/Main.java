package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = n; i > 0; i--) {
			
			for (int j = 0; j < i; j++) {
				for(int z = i; z < n;) {
					System.out.println(" ");
				}
				
				System.out.print("*");
			}
			System.out.println();
			
		}

		sc.close();

	}

}
