package com.lec.java.collection10;

import java.util.Iterator;
import java.util.TreeSet;

public class Collection10Main {

	public static void main(String[] args) {
		System.out.println("TreeSet 연습");

		// String 타입을 저장할 수 있는 TreeSet 인스턴스 생성
		// 5개 이상의 데이터를 저장해보고
		// 오름차순, 내림차순으로 출력해보기
		TreeSet<String> tset = new TreeSet<String>();

		tset.add("a");
		tset.add("b");
		tset.add("c");
		tset.add("d");
		tset.add("e");

		Iterator<String> list = tset.iterator();
		while (list.hasNext()) {
			System.out.println(list.next());
		}

		System.out.println();

		list = tset.descendingIterator();
		while (list.hasNext()) {
			System.out.println(list.next());
		}

		System.out.println("\n프로그램 종료");
	} // end main

} // end class
