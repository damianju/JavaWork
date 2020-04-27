package practice.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..
class WordFreq implements Comparable<WordFreq> {

	String word; // 발생단어
	int freq; // 빈도수

	public WordFreq(String word, int freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public String toString() {
		String str = String.format("%-15s : %2s개", this.word, this.freq);
		return str;
	}

	@Override
	public int compareTo(WordFreq o) {
		if (o.freq < this.freq)
			return -1;
		if (o.freq > this.freq)
			return 1;
		return 0;
	}
}

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도 (내림차순)");
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		List<WordFreq> list = new LinkedList<WordFreq>();
		String regex = "^[a-z]{2,}$"; // 정규표현식
		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+|\\W");

		// 발생빈도 작성
		for (int i = 0; i < words.length; i++) {
			Matcher matcher = Pattern.compile(regex).matcher(words[i]);
			while (matcher.find()) {
				Integer v = hmap.get(matcher.group());
				if (v == null)
					hmap.put(matcher.group(), 1);
				else
					hmap.put(matcher.group(), v + 1);
			} // end while
		} // end for

		// 빈도별 정렬 (내림차순)
		for (Map.Entry<String, Integer> e : hmap.entrySet()) {
			list.add(new WordFreq(e.getKey(), e.getValue()));
		} // end for
		Collections.sort(list);
		
		// 결과 출력
		for (int i = 0; i < list.size(); i++) {
			System.out.println("#"+(i+1)+"\t"+list.get(i));			
		}
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class
