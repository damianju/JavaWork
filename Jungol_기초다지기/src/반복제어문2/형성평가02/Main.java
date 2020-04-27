package 반복제어문2.형성평가02;

import java.util.Scanner;

//100 이하의 두 개의 정수를 입력받아 작은 수부터 큰 수까지 차례대로 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		sc.nextLine();
		if (n1 <= n2) {
			for (int i = n1; i <= n2; i++) {
				System.out.print(i + "\t");
			}
		} else {
			for (int i = n2; i <= n1; i++) {
				System.out.print(i + "\t");
			}
		}

		sc.close();

	}

}
