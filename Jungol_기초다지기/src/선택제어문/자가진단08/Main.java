package 선택제어문.자가진단08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double s = sc.nextDouble();
		
		if(s>=4.0) {
			System.out.println("scholarship");
		} else if (s>=3.0){
			System.out.println("next semester");
		} else if (s>=2.0){
			System.out.println("seasonal semester");
		} else if (s<2.0){
			System.out.println("retake");
		} 
	
		sc.close();

	}

}
