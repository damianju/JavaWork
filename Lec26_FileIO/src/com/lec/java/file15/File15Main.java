package com.lec.java.file15;

import java.io.File;

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 폴더:" + curWorkingDir);

		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir); // 현재 작업 디렉토리 객체
		File[] list = curDir.listFiles(); // listFiles() : 디렉토리 안에 있는 '파일'과 '디렉토리'를 File배열로 리턴
		System.out.println(list.length); // '파일'과 '디렉토리'의 개수
		for (int i = 0; i < list.length; i++) {
			if (list[i].isDirectory()) {
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴
				System.out.print("DIR\t");
			} else {
				System.out.print("FILE\t");
			}
			System.out.print(list[i].getName() + "\t");
			System.out.println(list[i].length()); // length() '파일'의 크기(byte) '디렉토리'인 경우 의미 없음
		}

		System.out.println();
		// 디렉토리의 내용 출력, enhanced for 문 이용
//		File tempDir = new File("temp"); // 상대경로

		// 절대경로(absolute path) 를 이용한 File 객체 생성
		String tempDirPath = System.getProperty("user.dir") + File.separator // 윈도우(\), LINUX, Mac(/)
				+ "temp";

		System.out.println("절대경로: " + tempDirPath);
		File tempDir = new File(tempDirPath);

		File[] list2 = tempDir.listFiles();
		System.out.println(list2.length);
		for (File f : list2) {
			if (f.isFile()) {
				System.out.print("FILE\t");
			} else {
				System.out.print("DIR\t");
			}
			System.out.print(f.getName() + "\t");
			System.out.println(f.length());
		}

		System.out.println();
		// 파일 하나에 대한 정보
		String path = "dummy.txt";
		File f = new File(path); // 새로운 파일 객체 생성
		// * File 객체를 생성(new)했다고 해서 물리적인 파일/디렉토리가 만들어지는 것은 아니다
		System.out.println("파일 이름: " + f.getName()); // 상대 경로명
		System.out.println("절대 경로:" + f.getAbsolutePath()); // 절대 경로명
		System.out.println("있냐?: " + f.exists()); // 물리적으로 존재하는지 여부

		System.out.println("\n프로그램 종료");

	} // end main()

} // end File11Main
