package 함수1.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int result = getPow(a, b);
		
		System.out.println(result);
		
		sc.close();

	}
	
	public static int getPow(int a, int b) {
		
		int result = (int) Math.pow(a, b);
		
		return result;
	}

}
