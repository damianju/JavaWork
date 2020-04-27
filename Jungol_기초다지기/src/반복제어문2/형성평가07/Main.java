package 반복제어문2.형성평가07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			int m = n*i;
			System.out.print(m+"\t");
		}
		
		sc.close();
	}

}
