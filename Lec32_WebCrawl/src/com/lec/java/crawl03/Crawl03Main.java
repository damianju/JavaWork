package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		//TODO
		// http://www.daum.net
		// 15개
		
		String url;
		Response response;
		Document doc;
		Element element;
		
		url = "http://www.daum.net";
		response = Jsoup.connect(url).execute();
		System.out.println(response.statusCode());
		doc = response.parse();
		
		Elements favor_elements = doc.select("div.slide_favorsch ul.list_favorsch li a");
		System.out.println(favor_elements.size()+"개");
		for(Element e: favor_elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		
		System.out.println("\n프로그램 종료");
	}

}
