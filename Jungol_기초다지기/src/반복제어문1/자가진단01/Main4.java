package 반복제어문1.자가진단01;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double age = sc.nextDouble();
		sc.nextLine();
		
		if(age <=18 && age >0 ) {
			System.out.println("미성년자");
		} else if(age >= 19) {
			System.out.println("성년");
		} else {
			System.out.println("잘못 입력하셨습니다");
		}
		
		
		sc.close();
	}

}
