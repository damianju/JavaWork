package Evaluation01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

// 	Jsoup 라이브러리를 활용하여, 아래의 내용을 파싱하여 결과보여주기를 작성해보세요
//URL : https://movie.naver.com/movie/sdb/rank/rmovie.nhn
public class Main09 {

	public static void main(String[] args) throws IOException {
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("#assistant div:nth-child(1) ul li");
		System.out.println(elements.size());
		

		for(Element e: elements) {
			
		
			String b = e.selectFirst("a").text().trim();
			
			
			System.out.printf("%s\n", b);
		}
	}

}
