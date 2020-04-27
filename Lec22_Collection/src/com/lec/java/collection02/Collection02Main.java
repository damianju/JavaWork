package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		ArrayList<String> arr1 = new ArrayList<String>();
		
		arr1.add("a");
		arr1.add("b");
		arr1.add("c");
		arr1.add("d");
		arr1.add("e");
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println("["+i+"] "+arr1.get(i));
		}
		System.out.println();
		
		arr1.remove(2);
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println("["+i+"] "+arr1.get(i));
		}
		System.out.println();
		
		
		arr1.set(2, "f");
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println("["+i+"] "+arr1.get(i));
		}
		System.out.println();
		
		arr1.remove(0);
		Iterator<String> li = arr1.iterator();
		
		while(li.hasNext()){
			System.out.println(li.next());
			
		}
		System.out.println();
		for(String e: arr1) {
			System.out.println(e);
		}
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator


		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












