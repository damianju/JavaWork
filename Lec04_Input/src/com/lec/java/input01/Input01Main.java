package com.lec.java.input01;

import java.util.Scanner;

/*
 * 표준 입력 (Standard Input) : 키보드로부터 입력
 *			Scanner 객체 사용 
 * 표준 출력 (Standard Output) : 모니터로 출력
 */
public class Input01Main {

	public static void main(String[] args) {
		System.out.println("표준입력: Scanner 사용");
		
		Scanner sc = new Scanner (System.in); // import 필요, Scanner 객체 생성
		
		// Scanner 사용한 입력 작업
		int num1, num2;
		System.out.print("숫자1을 입력하세요: ");
		num1 = sc.nextInt(); // 키보드로부터 int 입력
		System.out.print("숫자2을 입력하세요:");
		num2 = sc.nextInt();
		
		System.out.println(num1+" + "+num2+"=" + (num1+num2));
		System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
		
		// nextInt() 에서 문자나 다른걸 입력하면 InputMismatchException 발생
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();

		
		sc.close(); // Scanner 객체를 사용한 뒤에는 반드시 close()를 해주자.
		

	} // end main()

} // end class

