package com.lec.java.crawl04;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword, "utf-8"); // 네이버 검색페이지는 utf-8로 url encode 함. 크롤링할 사이트의 인코딩 방식을 먼저 확인
		
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query="+encoded;
		
		System.out.println(url); // 생성된 url 확인해보자
		
		doc = Jsoup.connect(url).execute().parse();
		elements = doc.select(".lst_relate ul li");
		System.out.println(elements.size());
		for(Element e: elements) {
			System.out.println(e.selectFirst("a").text());
		}
		
		
		
		System.out.println("\n프로그램 종료");

	}

}
