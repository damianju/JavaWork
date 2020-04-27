package 반복제어문1.자가진단01;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i =0; i<n; i++) {
			System.out.println(word);
		}
		
		sc.close();
	}

}
