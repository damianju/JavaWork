package practice.game369;

import java.util.Scanner;

public class Game3692 {

	public static void main(String[] args) {{
		Scanner sc = new Scanner(System.in);
		int max = sc.nextInt(); // 사용자에게 입력받는 최대값

		int row = 10; // 가로
		int col = (max / row) + 1; // 세로, max/row의 소수점 이하가 잘리므로 1더함
		int cnt = 1; // 출력되어 나오는 값
		int x = 0; //3, 6, 9가 있으면 1을 없으면 0을 저장해두는 변수

		while (cnt < max) {
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					cnt = row * i + j + 1; 	
					if (cnt > max) break; //만약 쓰여질 숫자가 max값보다 크면 바로 나옴
					
					int num = 1; //1 10 100,, 곱해가며 확인
					int temp = cnt; //cnt를 temp에 저장
					
					while(num < cnt) { //숫자에 3이 들어가있는지 확인하는 코드
						 int a = temp % 10;
						if (a == 3 || a == 6 || a == 9) {
							x = 1; //3, 6, 9가 있으면 x라는 변수에 1넣음
							break;
						}else {
							num *= 10;
							temp /= 10;
						}
					}
					
					if(x == 1) {
						System.out.print("*\t");
						x = 0;
					}else {
					System.out.print(cnt + "\t");
					}

				} // 가로 끝
				System.out.println(); //줄바꿈
			}
		}
		sc.close();}
	}
}
