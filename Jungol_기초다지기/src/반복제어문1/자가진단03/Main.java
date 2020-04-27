package 반복제어문1.자가진단03;

import java.util.Scanner;

// 한 개의 정수를 입력받아 양수(positive integer)인지 음수(negative number)인지 출력하는 작업을 반복하다가 0이 입력되면 종료하는 프로그램을 작성하시오.
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = 0;

		while (true) {
			System.out.println("number?");
			i = sc.nextInt();
			if (i > 0) {
				System.out.println("positive integer");
			} else if (i < 0) {
				System.out.println("negative number");
			} else if (i == 0) {
				break;
			}

		} sc.close();
	} 

}
