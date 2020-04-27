package practice.maxwords;

import java.util.Scanner;

/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
//2020-03-22  12:00 최종수정 완료

public class MaxWord {

	public static void checkLength(String words) {

		int max = 0;
		String maxWords = "";
		for (String word : words.split("\\.|\\?|\\!")) {
			String[] arr = word.trim().split(" ");
			if (arr.length > max) {
				max = arr.length;
				maxWords = word.trim();
			} // end if
		} // end for
		System.out.println(max);
		System.out.println(maxWords);
	} // end method

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		checkLength(word);

		sc.close();
	} // end main
} // end class
