package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int min;
		
		min = (a < b && a < c) ? a : ((b < c) ? b : c);
		System.out.println(min);
		
		
		sc.close();

	}

}
