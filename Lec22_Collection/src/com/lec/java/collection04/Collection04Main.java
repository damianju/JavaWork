package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		// TODO

		Scanner sc = new Scanner(System.in);
		ArrayList<MemberModel> list = new ArrayList<MemberModel>();

		for (int i = 0; i < 3; i++) {
			System.out.println("id:");
			String id = sc.nextLine();
			System.out.println("passwd: ");
			String passwd = sc.nextLine();

			MemberModel mm = new MemberModel(id, passwd);
			list.add(mm);
		}

		for (int i = 0; i < list.size(); i++) {
			list.get(i).displayInfo();
		}

		System.out.println();
		Iterator<MemberModel> li = list.iterator();

		while (li.hasNext()) {
			li.next().displayInfo();
		}

		System.out.println();
		for (MemberModel e : list) {
			e.displayInfo();
		}

		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
