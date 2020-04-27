package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Jsoup");
		
		Element element;
		Elements elements;
		
		
		File f = new File("data/hello.html");
		Document doc = Jsoup.parse(f, "UTF-8"); // 파일 ->> Document 변환 (DOM구조 변환)
		
		//System.out.println(doc.outerHtml());
		
		element = doc.selectFirst("div");
		// System.out.println(element.outerHtml());
		
		elements=doc.select("div");
		System.out.println(elements.size()+"개");
		
		// Elements의 get(n) => n번째 Element 리턴
//		element = elements.get(3);
//		System.out.println(element.outerHtml());
		
//		for (int i = 0; i < elements.size(); i++) {
//			element = elements.get(i);
//			System.out.println(element.outerHtml());
//			System.out.println();
//		}
//		
//		for(Element e: elements) {
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}
//		
		element = doc.selectFirst("div#addr");
		//System.out.println(element.outerHtml());
		
		elements = element.select("ul.favorite a");
		System.out.println(elements.size()+"개");
		
		for (Element e: elements) {
			//System.out.println(e.outerHtml());
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		//TODO
		System.out.println();
		for(Element img : doc.select("img")) {
			System.out.println(img.attr("src").trim());
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
