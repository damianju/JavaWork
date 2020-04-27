package 선택제어문.형성평가05;

import java.util.Scanner;

// 1~12사이의 정수를 입력받아 평년의 경우 해당 월의 날수를 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)
			System.out.println(31);
		if (m == 2)
			System.out.println(28);
		if (m == 4 || m == 6 || m == 9 || m == 11)
			System.out.println(30);

		sc.close();

	}

}
