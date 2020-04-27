package practice.game369;

public class Game369 {
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {

			int a = i % 10; // 1의 자리수
			int b = i / 10; // 10의 자리수
			
			if ((a == 3 || a == 6 || a == 9) || (b == 3 || b == 6 || b == 9)) {
				System.out.print("*\t");
			} else {
				System.out.print(i + "\t");
			} // end if
			
			if (i % 10 == 0) {
				System.out.println();
			} //end if
		} // end for
	} // end main()
} // end class
