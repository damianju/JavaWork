package com.lec.java.crawl01;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class NaverMovie {

	public static void main(String[] args) throws IOException {
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";

		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("#assistant div:nth-child(1) ul li a");
		System.out.println(elements.size());

		for (Element e : elements) {

			e.selectFirst("span.blind").remove(); // 1위, 2위 텍스트<span> 없애려면 해당 element 삭제(remove())

			System.out.println(e.text().trim());
		}
	}

}
