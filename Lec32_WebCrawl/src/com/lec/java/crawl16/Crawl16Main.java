package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

//https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=
public class Crawl16Main {

	public static void main(String[] args) throws IOException {
		System.out.println("요기요 맛집정보 : header 추가");
		
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=";
		
		StringBuffer sb =  readFromUrl(url);
		// System.out.println(sb.toString()); // 확인용 : response code: 400 --> header 정보 없음
		
		ObjectMapper mapper = new ObjectMapper();
		
		// 맛집 이름 /평점
		System.out.println(mapper.readValue(sb.toString(), Yogiyo.class));
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {
		
		StringBuffer sb = new StringBuffer(); // response 받을 데이터 담을 객체
		
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection
		
		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 -> 문자기반 Reader
		BufferedReader br = null;
		
		char [] buf = new char[512]; // 문자용 버퍼
		
		// BufferedReader <- InputreamReader <- InputStream <- HttpURLConnection
		
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // URLConnection(추상클래스) 객체 생성 
			
			if(conn != null) {
				conn.setConnectTimeout(2000); // 2초 이내에 '연결'이 수립 안 되면 java.net.StoketTimeoutException 발생
				
				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET", "POST"
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시 사용 안 함
				
				// 헤더 정보 추가
				conn.setRequestProperty("X-ApiKey", "iphoneap");
				conn.setRequestProperty("X-ApiSecret", "fe5183cc3dea12bd0ce299cf110a75a2");
				
				System.out.println("request 시작: "+ urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");
				
				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : "+ responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				
				if(responseCode == HttpURLConnection.HTTP_OK) {
					
					in = conn.getInputStream(); // // InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader
					
					int cnt; // 읽은 글자 개수
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer 에 추가
					}
				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect(); // 작업 끝나고 Connection 해제
		}
		return sb;
	} // end readFromURL()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Yogiyo {
	private List<Restaurant> restaurants;

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("");
		
		for (Restaurant e : restaurants) {
			sb.append(e.toString() + "\n");
		}
		
		return sb.toString();
	}
		 
	
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Restaurant {
	private String name;
	
	@JsonProperty("review_avg")
	private double reviewAvg;

	public String getSlug() {
		return name;
	}

	public void setSlug(String slug) {
		this.name = slug;
	}

	public double getReviewAvg() {
		return reviewAvg;
	}

	public void setReviewAvg(double reviewAvg) {
		this.reviewAvg = reviewAvg;
	}
	
	@Override
	public String toString() {
		return String.format("%s : %.1f", name, reviewAvg);
	}

} // end class
