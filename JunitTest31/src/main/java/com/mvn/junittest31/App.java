package com.mvn.junittest31;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    }
    // 실습1
    public void sortArr(int[] arr) {
    	Arrays.sort(arr);
    }
    
    // 실습2
    public int max(int[] arr) {
    	int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}

		}
    	return max;
    }
    
    public int min(int[] arr) {
    	int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}

		}
    	return min;
    }
    
    // 실습3
    public String toNumber(String str) {
    	String result="";
    	String[] strings = str.split("\\D");
    	
    	for(String x: strings) {
			result += x;
		}
    	return result;
    }
    
}
