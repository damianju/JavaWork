package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// (id, name, kor, eng, math)
		// 3가지 방법으로 출력해보세요.
		// for, Enhanced-for, Iterator

		Scanner sc = new Scanner(System.in);
		ArrayList<Student> st = new ArrayList<Student>();

		for (int i = 0; i < 3; i++) {
			System.out.println("id:");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("name:");
			String name = sc.nextLine();
			System.out.println("국,영,수:");
			int kor = sc.nextInt();
			int eng = sc.nextInt();
			int math = sc.nextInt();

			Student stu = new Student(id, name, new Score(kor, eng, math));
			st.add(stu);

		}

		for (int i = 0; i < st.size(); i++) {
			System.out.println("[" + i + "]" + st.get(i));
		}

		for (Student e : st) {
			System.out.println(e);
		}

		Iterator<Student> li = st.iterator();
		while (li.hasNext()) {
			System.out.println(li.next());
		}

		sc.close();

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
