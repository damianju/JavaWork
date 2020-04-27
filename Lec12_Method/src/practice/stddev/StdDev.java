//정수 5개를 담는 배열을 생성하고
//1 ~ 100 사이의 임의의 자연수로 초기화되게 하고,
//생성된 배열원소들을 출력하고
//
//그  배열원소의  평균, 분산, 표준편차를 구하라

package practice.stddev;

import java.util.Arrays;
import java.util.Random;

public class StdDev {

	public static void main(String[] args) {

		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Random().nextInt(100) + 1;
		}

		System.out.println(Arrays.toString(arr));
		System.out.println("평균 : " + calcAvg(arr));
		System.out.println("분산 : " + calcVariance(arr));
		System.out.println("표준편차 : " + calcStdDev(arr));
		// 임의정수 5개로 초기화한 정수로
		// 평균, 분산, 표준편차 구하기

	} // end main

	/**
	 * 메소드 이름 : calcAvg 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */

	// 2020-03-21 16:00 최종수정 완료
	public static double calcAvg(int[] arr) {
		double sum = 0;
		for (int e : arr) {
			sum += e;
		} // end for
		double avg = sum / arr.length;
		return avg;
	} // end method ()

	/**
	 * 메소드 이름 : calcVariance 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[] arr) {
		double total = 0;
		double squ = 0;
		for (int e : arr) {
			squ = Math.pow(e - calcAvg(arr), 2);
			total += squ;
		} // end for
		double var = total / arr.length;
		return var;
	} // end method ()

	/**
	 * 메소드 이름 : calcStdDev 매개변수 : int [] 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] arr) {
		double std = Math.sqrt(calcVariance(arr));
		return std;
	} // end method ()

} // end class
