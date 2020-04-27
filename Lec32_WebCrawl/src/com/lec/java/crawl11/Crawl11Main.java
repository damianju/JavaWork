package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* XML, JSON 파싱 연습
 *  ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울
http://swopenapi.seoul.go.kr/api/subway/554272615264616d3132394273656947/xml/stationInfo/1/5/%EC%84%9C%EC%9A%B8

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울
http://swopenapi.seoul.go.kr/api/subway/554272615264616d3132394273656947/json/stationInfo/1/5/%EC%84%9C%EC%9A%B8


 * 
 */

public class Crawl11Main {
	public static final String REQ_SERVICE = "stationInfo";
	public static final String API_KEY = "554272615264616d3132394273656947";

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("서울시 지하철 역사(station) 정보");

		String url_address;
		StringBuffer sb; // response 받은 텍스트

		// TODO: API url에 필요한 parameter들
		int startIndex;
		int endIndex;
		String statnNm;

		startIndex = 1;
		endIndex = 5;
		statnNm = "왕십리";

		System.out.println("---- XML 파싱 ----");
		// TODO
		url_address = buildUrlAddress("xml", startIndex, endIndex, statnNm);
		System.out.println(url_address);
		sb = readFromUrl(url_address);
		parseXML(sb.toString());

		// url_address = buildUrlAddress("xml", startIndex, endIndex, date);

		

		System.out.println("---- JSON 파싱 ----");
		// TODO
		
		url_address = buildUrlAddress("json", startIndex, endIndex, statnNm);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString());
		/*
		 *
		 * 
		 * //url_address = buildUrlAddress("json", startIndex, endIndex, date);
		 */
//		sb = readFromUrl(url_address);
//		parseJSON(sb.toString());

		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String statnNm) throws UnsupportedEncodingException {
		String url_address = String.format("http://swopenapi.seoul.go.kr/api/subway/%s/%s/stationInfo/%d/%d/%s",
				API_KEY, reqType, startIndex, endIndex, URLEncoder.encode(statnNm, "utf-8"));

		return url_address;
	}
//	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {
//		String url_address = ""; //TODO
//
//		return url_address;
//
//	}

	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체

		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초이내에 '연결' 이 수립안되면
												// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET", "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함

				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");

				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) {

					in = conn.getInputStream(); // InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader

					int cnt; // 읽은 글자 개수
					while ((cnt = br.read(buf)) != -1) {
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
			if (conn != null)
				conn.disconnect(); // 작업 끝나고 Connection 해제
		}

		return sb;
	}

	public static void parseXML(String xmlText) {
		//TODO
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;
		
		try {
			dbFactory  = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));
			
			Document dom = dBuilder.parse(in);
			
			Element docElement = dom.getDocumentElement();
			docElement.normalize();
			
			NodeList nList = docElement.getElementsByTagName("row");
			System.out.println(nList.getLength());
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				if(node.getNodeType() != Node.ELEMENT_NODE) continue;
				Element rowElement = (Element) node;
				
				String statnNm =rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue().trim();
				String subwayId =rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0).getNodeValue().trim();
				String subwayNm =rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue().trim();
				
				
				System.out.println((i+1)+" "+statnNm+" "+subwayId+" "+subwayNm);
			}
			
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

			
	} // end parseXML
	
	

	public static void parseJSON(String jsonText) {
		// org.json 라이브러리 다운로드
		// TODO
		JSONObject jobj = new JSONObject(jsonText);
		JSONArray row = jobj.getJSONArray("stationList");
		System.out.println(row.length());
		
		for (int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i);
			String statnNm = station.getString("statnNm");
			String subwayId = station.getString("subwayId");
			String subwayNm = station.getString("subwayNm");
			System.out.println((i+1)+" "+statnNm+" "+subwayId+" "+subwayNm);
		}
	

} // end method

} // end class
