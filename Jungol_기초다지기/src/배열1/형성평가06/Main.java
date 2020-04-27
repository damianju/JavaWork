package 배열1.형성평가06;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = {"J","U","N","G","O","L"};
		List<String> list = Arrays.<String>asList(arr);
		String s = sc.next();
		int i = list.indexOf(s);
		if(i != -1) {
			System.out.println(i);			
		} else {
			System.out.println("none");
		}			
		sc.close();
	}

}
