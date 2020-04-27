package 함수1.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		rep(n);
		
		
		sc.close();

	}
	
	public static void rep(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println("~!@#$^&*()_+|");
		}
	}


}
