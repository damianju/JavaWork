package 배열1.자가진단09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 10개의 정수를 입력받아 배열에 저장한 후 내림차순으로 정렬하여 출력하시오.
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int[] arr = new int[10];
//		
//		for (int i = 0; i < arr.length; i++) {
//
//			//System.out.println("정수 입력:");
//
//			arr[i] = sc.nextInt();
//			
//
//		}
//
//		//System.out.println(Arrays.toString(arr));
//
//		sc.close();
//
//		for (int i = arr.length-1; i > 0; i--) {
//			for (int j = 0; j < (i - 1); j++) {
//				if (arr[i] > arr[j]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			for (int j = arr.length-1 ; j > 0; j--) {
//				if (arr[i] > arr[j]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//		}
//
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < 10; i++) {
			list.add(sc.nextInt());
		}
		
		Comparator<Integer> cmp = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		};
		
		Collections.sort(list, cmp);
		for(int e: list) {
			System.out.print(e+" ");
		}

	} // end main()

} // end class


