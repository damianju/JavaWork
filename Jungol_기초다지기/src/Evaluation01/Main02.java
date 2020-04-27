package Evaluation01;

// 문자열 세개를 입력 받아서 세 문자열의 앞글자만 출력하세요 
import java.util.Scanner;

public class Main02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();

		System.out.println();

		System.out.print(a.charAt(0));
		System.out.print(b.charAt(0));
		System.out.print(c.charAt(0));

		sc.close();

	}

}
