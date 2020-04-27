package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");

		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enahnce-for 등을
		// 사용하여 출력해보기
		HashSet<MyClass> set = new HashSet<MyClass>();
		MyClass m1 = new MyClass(1, "abc");
		MyClass m2 = new MyClass(1, "ABC");
		System.out.println(m1.hashCode());
		System.out.println(m2.hashCode());

		// 데이터 3개 저장
		set.add(new MyClass(1, "abc"));
		set.add(new MyClass(2, "b"));
		set.add(new MyClass(1, "ABC")); 

		System.out.println("siz e= " + set.size());

		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> list = set.iterator();
		while (list.hasNext()) {
			System.out.println(list.next());
		}

		System.out.println();
		System.out.println("enhanced for");
		for (MyClass e : set) {
			System.out.println(e);
		}

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class
