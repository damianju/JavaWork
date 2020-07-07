package com.lec.java.file16;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";

	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		System.out.println();

		String path = System.getProperty("user.dir") + File.separator + TEST_DIRECTORY; // "test"
		System.out.println("절대경로: " + path);

		// File 객체 생성 ==> 디스크에 물리적인 파일/디렉토리가 만들어진 것은 아니다!!
		File f = new File(path);

		System.out.println();
		// 폴더 생성: mkdir()
		if (!f.exists()) {// 디렉토리가 존재하는지 체크
			// 디렉토리가 존재하지 않는다면 생성!
			if (f.mkdir()) {
				System.out.println("폴더 생성 성공!");
			} else {
				System.out.println("폴더 생성 실패!"); // 용량, 권한 등
			}

		} else {
			System.out.println("폴더가 이미 존재합니다");
		}

		System.out.println();
		// 파일 생성 : createNewFile()
		// 자바에 파일 객체 생성
		File f2 = new File(f, TEST_FILE); // "test/dummy.txt", File(디렉토리 File, 파일명)
		System.out.println(f2.getAbsolutePath());

		if (!f2.exists()) { // 파일이 존재하는지 체크
			// 파일이 존재하지 않으면 생성
			try {
				if (f2.createNewFile()) { // 물리적으로 파일 생성  //0바이트 파일 생성
					System.out.println("파일 생성 성공!");
				} else {
					System.out.println("파일 생성 실패!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 파일이 존재한다면
			System.out.println("파일이 이미 존재합니다");
		}
 
		System.out.println();
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		File f3 = new File(f, TEST_RENAME); // "text/re_dummy.txt"
		System.out.println(f3.getAbsolutePath());
		
		if (f2.exists()) { // "test/dummy.txt"가 존재하는지 체크
			// 변경
			
			if(f2.renameTo(f3)) {
				System.out.println("파일명 변경 성공");
			} else {
				System.out.println("파일명 변경 실패"); // 이미 "re_dummy.txt"가 있으면 실패
			}
			
			
		} else {
			System.out.println("변경할 파일이 없습니다");
		}

		System.out.println();
		// 파일 삭제: delete()
		File f4 = new File(f, TEST_RENAME); // "test/re_dummy.txt"
		System.out.println(f4.getAbsolutePath());
		if(f4.exists()){
			// 파일이 존재한다면
			if(f4.delete()) {
				System.out.println("파일 삭제 성공");
			} else {
				System.out.println("파일 삭제 실패");
			}
		}else {
			System.out.println("삭제할 파일 없음");
		}

		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
