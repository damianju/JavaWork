package com.mvn.junittest31;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;



public class AppTest {
	
	
	private App app;
	File f =null;
	
	public static final String TEST_DIRECTORY = "/TEST";
	public static final String TEST_FILE = "report.txt";
	
	@Before
	public void setUp() {
		app = new App();
		
		String path = System.getProperty("user.dir") + File.separator + TEST_DIRECTORY; 
		System.out.println("절대경로: " + path);

		f = new File(path);

		System.out.println();
		if (!f.exists()) {// 디렉토리가 존재하는지 체크
			
			if (f.mkdir()) {
				System.out.println("폴더 생성 성공!");
			} else {
				System.out.println("폴더 생성 실패!"); 
			}

		} else {
			System.out.println("폴더가 이미 존재합니다");
		}
	}
	
    // 실습1
    @Test
    public void test1(){
    	int[] arr1 = { 4, 9, 3, 5, 1, 2 };
    	int[] arr2 = { 55, 5, 1, 3, 4, 2 };
    	int[] arr3 = { 1, 2, 3};
    	int[] arr4 = { 100, 999, 99};
    	int[] arr5 = { 22, 11, 33, 55, 44, 66 };
    	
    	int[] arr11 = { 1, 2, 3, 4, 5, 9 };
    	int[] arr22 = { 1, 2, 3, 4, 5, 55};
    	int[] arr33 = { 1, 2, 3};
    	int[] arr44 = { 99, 100, 999};
    	int[] arr55 = { 11, 22, 33, 44, 55, 66};
    	
    	app.sortArr(arr1);
    	app.sortArr(arr2);
    	app.sortArr(arr3);
    	app.sortArr(arr4);
    	app.sortArr(arr5);
		
		/*
		 * System.out.println(Arrays.toString(arr1));
		 * System.out.println(Arrays.toString(arr2));
		 * System.out.println(Arrays.toString(arr3));
		 * System.out.println(Arrays.toString(arr4));
		 * System.out.println(Arrays.toString(arr5));
		 */
		 
    	
    	assertEquals(Arrays.toString(arr11), Arrays.toString(arr1));
    	assertEquals(Arrays.toString(arr22), Arrays.toString(arr22));
    	assertEquals(Arrays.toString(arr33), Arrays.toString(arr33));
    	assertEquals(Arrays.toString(arr44), Arrays.toString(arr44));
    	assertEquals(Arrays.toString(arr55), Arrays.toString(arr55));
    }
    

	
	
    // 실습2
    @Test
    public void test2(){
    	
    	int[] arr1 = { 4, 9, 3, 5, 1, 2 };
    	int[] arr2 = { 55, 5, 1, 3, 4, 2 };
    	int[] arr3 = { 1, 2, 3};
    	
    	
    	if(app.max(arr1) != 9 || app.min(arr1) != 1 ) {
    		fail();
    		return;
    	}
    	
    	if(app.max(arr2) != 55 || app.min(arr2) != 1 ) {
    		fail();
    		return;
    	}
    	
    	if(app.max(arr3) != 3 || app.min(arr3) != 1) {
    		fail();
    		return;
    	}
    	
    	
    	File f2 = new File(f, TEST_FILE); 
  
		System.out.println(f2.getAbsolutePath());

		if (!f2.exists()) { 
			
			try {
				if (f2.createNewFile()) { 
					System.out.println("파일 생성 성공!");
				} else {
					System.out.println("파일 생성 실패!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { 
			System.out.println("파일이 이미 존재합니다");
		}
		
		try {
		    OutputStream output = new FileOutputStream(f2.getAbsolutePath());
		    String str = "테스트1] 최대값: "+Integer.toString(app.max(arr1))+"\n";
		    str += "테스트1] 최소값: "+ Integer.toString(app.min(arr1))+"\n";
		    str += "테스트2] 최대값: "+ Integer.toString(app.max(arr2))+"\n";
		    str += "테스트2] 최소값: "+ Integer.toString(app.min(arr2))+"\n";
		    str += "테스트3] 최대값: "+ Integer.toString(app.max(arr3))+"\n";
		    str += "테스트3] 최소값: "+ Integer.toString(app.min(arr3))+"\n"+"end^^";
		    
		    
		    byte[] by=str.getBytes();
		    output.write(by);
		    
		    output.close();
				
		} catch (Exception e) {
	            e.getStackTrace();
		}
 
    	
    	
		/*
		 * assertEquals(9, app.max(arr1)); assertEquals(55, app.max(arr2));
		 * assertEquals(3, app.max(arr3));
		 * 
		 * assertEquals(1, app.min(arr1)); assertEquals(1, app.min(arr2));
		 * assertEquals(1, app.min(arr3));
		 */
    	
    }
    
    
}
