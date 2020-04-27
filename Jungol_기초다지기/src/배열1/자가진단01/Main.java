package 배열1.자가진단01;


import java.util.Scanner;

// 문자 10개를 저장할 수 있는 배열을 만들고 10개의 문자를 입력받아 입력받은 문자를 이어서 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {
		
		String[] arr = new String[10];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
			System.out.print(arr[i]);
		}
		
		sc.close();
	}

}
