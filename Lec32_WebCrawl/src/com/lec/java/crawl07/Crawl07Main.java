package com.lec.java.crawl07;
/*
 * '검색어' 입력받아서
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 * 		책이름/ 책가격/ 상세페이지url/ 썸네일url
 * 
 * yes24.com 검색페이지는 euc-kr로 URL 인코딩되어 있다.
 * 		한글 1글자당 2byte 인코딩
 * 
 * 
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl07Main {

	private static final String PATH = "books";

	public static void main(String[] args) throws IOException {
		System.out.println("인터파크 도서 검색결과 페이지");

		Scanner sc = new Scanner(System.in);
		System.out.println("검색어를 입력하세요: ");
		String search = sc.nextLine();
		sc.close();

		try {
			Crawl07Main app = new Crawl07Main();
			ArrayList<InfoBook> list = app.crawlInterPark(search);
			int fileIndex = 1;
			for (InfoBook e : list) {
				System.out.println(e); // 크롤링 정보 출력
				// 썸네일 이미지 다운로드
				String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
				URL imgUrl = new URL(e.getImUrl());

				BufferedImage imgData = ImageIO.read(imgUrl);
				File file = new File(fileName);
				ImageIO.write(imgData, "jpg", file);

				System.out.println(fileName + " 이 저장되었습니다");
				fileIndex++;
			}
		} catch (IndexOutOfBoundsException ex) { // 검색 결과가 없는 검색어 에러 잡기
			System.out.println("관련 도서를 찾을 수 없습니다. 에러: " + ex.getMessage());
		}

		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg ~thumb020.jpg...

		System.out.println("\n프로그램 종료");
	} // end main()

	private ArrayList<InfoBook> crawlInterPark(String search)
			throws IOException, IndexOutOfBoundsException {
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();

		String url;
		Document doc;
		Response response;
		Element element;
		Elements rowelements;
		String temp = "";

		// http://book.interpark.com/

		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query="
				+ URLEncoder.encode(search, "euc-kr");
		// System.out.println(url); // 확인용

		doc = Jsoup.connect(url).execute().parse();

		rowelements = doc.select("#bookresult > form").get(0).select("div.list_wrap");

		// System.out.println(rowelements.size()); //확인용

		for (Element e : rowelements) {
			String imgUrl = e.selectFirst("div.bimgWrap > a > img.bd").attr("src").trim();
			// System.out.println(imgUrl); //확인용
			Element infoElement = e.selectFirst("div.info > p.tit > b> a");
			String bookTitle = infoElement.text().trim();
			String linkUrl = infoElement.attr("href").trim();
			// System.out.println(bookTitle+" : "+linkUrl); //확인용
			
			try {
			temp = e.selectFirst("div.price > p > span").text().trim().replace(",", ""); // 할인가 
			}
			catch(NullPointerException ex){  // 할인가가 없으면 정가 적용
			temp = e.selectFirst("div.price > div.topCon > p.defaultNum").text().trim().replace(",", ""); // 정가
			} 
			
			double price = Double.parseDouble(temp.substring(0, temp.indexOf("원")));
			
			// System.out.println(price+"원"); //확인용

			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		} // end for

		return list;

	} // end method

} // end class
