package pratice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {
		for (int i = 2; i <= 10; i += 3) {
			for (int j = 1; j <= 9; j++) {
				if (i < 8) {
					System.out.printf("%2d x%2d = %-2d ", i, j, i * j);
					System.out.printf("%2d x%2d = %-2d ", i + 1, j, (i + 1) * j);
					System.out.printf("%2d x%2d = %-2d\n", i + 2, j, (i + 2) * j);
				} else {
					System.out.printf("%2d x%2d = %-2d ", i, j, i * j);
					System.out.printf("%2d x%2d = %-2d\n", i + 1, j, (i + 1) * j);
				} // end if
			} // end inner for
			System.out.println();
		} // end outer for
	} // end main ()
} // end class
