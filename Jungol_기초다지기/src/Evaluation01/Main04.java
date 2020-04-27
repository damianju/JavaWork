package Evaluation01;

import java.util.Scanner;

public class Main04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int max = 0;
		int min = 0;
		while (true) {
			int n = sc.nextInt();

			if (n == 0) {
				break;
			} else {

				if (max < n)
					max = n;

				if (min > n)

					min = n;
			}

		}

		System.out.println(max);
		System.out.println(min);

		sc.close();
	}
}
