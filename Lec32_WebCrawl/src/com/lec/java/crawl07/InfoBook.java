package com.lec.java.crawl07;

public class InfoBook {
	private String bookTitle; // 책제목
	private double price; // 책가격
	private String url; // 상세페이지url
	private String imgUrl; // 썸네일url

	// 기본 생성자
	public InfoBook() {
	
	}
	// 매개변수 생성자

	public InfoBook(String bookTitle, double price, String url, String imUrl) {
		
		this.bookTitle = bookTitle;
		this.price = price;
		this.url = url;
		this.imgUrl = imUrl;
	}

	// getter& setter

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImUrl() {
		return imgUrl;
	}

	public void setImUrl(String imUrl) {
		this.imgUrl = imUrl;
	}

	@Override
	public String toString() {
		return  String.format("\n서명: %s \n가격: %,.1f원 \nURL: %s \n이미지: %s \n", bookTitle, price, url, imgUrl);
	}

}
