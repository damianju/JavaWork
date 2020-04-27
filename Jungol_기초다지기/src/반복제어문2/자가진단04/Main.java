package 반복제어문2.자가진단04;

// 100 이하의 정수를 입력받아서 입력받은 정수부터 100까지의 합을 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for (int i = sc.nextInt(); i <= 100; i++) {
			sum += i;

		}
		System.out.println(sum);

		sc.close();
	}
}
