package Evaluation01;

//정수를 입력받아서 0 이면 ‘일요일’, 1 이면 ‘월요일’ … 6이면 ‘토요일’ 을 출력하시고, 그 외의 경우는 ‘잘못 입력하셨습니다’ 를 출력하세요
import java.util.Scanner;

public class Main03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		switch (n) {
		case 0: {
			System.out.println("일요일");
			break;
		}
		case 1:
			System.out.println("월요일");
			break;
		case 2: {
			System.out.println("화요일");
			break;
		}
		case 3: {
			System.out.println("수요일");
			break;
		}
		case 4: {
			System.out.println("목요일");
			break;
		}
		case 5: {
			System.out.println("금요일");
			break;
		}
		case 6: {
			System.out.println("토요일");
			break;
		}
		case 7: {
			System.out.println("일요일");
			break;
		}

		default:
			System.out.println("잘못 입력하셨습니다");
			break;
		}

		sc.close();
	}
}
