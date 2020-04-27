package com.lec.java.file12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {
	
	private static final String BIG_TEXT = "temp/big_eng.txt"; 
	
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		FileWriter fw = null;
		FileReader fr = null;
		
		BufferedReader br = null;
		BufferedWriter bw =  null;
		
		int charRead = 0;
		int charsCopied = 0;
		long startTime, endTime, elapsedTime;
		
		System.out.println("FileReader/Writer만 사용");
		try {
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy1.txt");
			
			startTime = System.currentTimeMillis();
			// read() 는 한글자씩 읽어서 리턴. 더이상 읽을 것이 없으면 -1 리턴
			while ((charRead = fr.read()) != -1) {
				fw.write(charRead);
				charsCopied++;
				
			}
			fw.flush(); // 문자 출력시 마지막에 꼭 flush()를 하자
			// flush를 하지 않으면 정상적으로 파일 출력이 끝나지 않는다.
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			
			System.out.println("읽고 쓴 문자수:"+charsCopied);
			System.out.println("경과 시간(ms):"+elapsedTime);
			
			//-----------------------------------------------------------------
			fw.close();
			fr.close();
			// ----------------------------------------------------------------
			
			System.out.println();
			System.out.println("BufferedReader/Writer + 버퍼 사용");
			
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy2.txt");
			br = new BufferedReader(fr); //장착!
			bw = new BufferedWriter(fw);
			
			char [] buf = new char[1024];
			
			int charsRead = 0; // 버퍼에 몇 글자 읽어들었나?
			charsCopied = 0;
			
			startTime = System.currentTimeMillis();
			
			while((charsRead=br.read(buf)) != -1) {
				bw.write(buf, 0, charsRead);
				charsCopied += charsRead;
			}
			
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			
			System.out.println("읽고 쓴 문자수:"+charsCopied);
			System.out.println("경과 시간(ms):"+elapsedTime);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
				if(br != null) br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		// TODO
		
		System.out.println("\n프로그램 종료");		
		
	} // end main()
} // end class
