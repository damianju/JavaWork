package 반복제어문1.자가진단06;
//아래와 같이 나라 이름을 출력하고 숫자를 입력받아 해당하는 나라의 수도를 출력하는 작업을 반복하다가 해당하는 번호 이외의 숫자가 입력되면 "none"라고 출력한 후 종료하는 프로그램을 작성하시오.

//
//* 각 나라의 수도 : 
//대한민국 = 서울(Seoul)
//미국 = 워싱턴(Washington)
//일본 = 동경(Tokyo)
//중국 = 북경(Beijing)

//
//1. Korea
//2. USA
//3. Japan
//4. China
//number? 1
//
//Seoul
//
//1. Korea
//2. USA
//3. Japan
//4. China
//number? 5
//
//none
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.println("number?");
			int n = sc.nextInt();
			if (n == 1) {
				System.out.println("Seoul");
			} else if (n == 2) {
				System.out.println("Washington");
			} else if (n == 3) {
				System.out.println("Tokyo");
			} else if (n == 4) {
				System.out.println("Beijing");
			} else if (n < 1 || n > 4) {
				System.out.println("none");
				break;
			} System.out.println();
		}

		sc.close();
	}

}
