package com.lec.java.crawl15;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
public class Crawl15Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jaskon-databind 연습2");
		

		ObjectMapper mapper = new ObjectMapper();
		Scanner sc = new Scanner(System.in);
		System.out.println("역을 입력해주세요:");
		String stName = sc.nextLine();
		String name = String.format("http://swopenapi.seoul.go.kr/api/subway/554272615264616d3132394273656947/json/stationInfo/1/5/%s", URLEncoder.encode(stName,"utf-8"));
		URL url = new URL(name);
 		
		Station station = mapper.readValue(url, Station.class);
		
	
		for(Info e: station.getStationList()) {
			System.out.println();
			System.out.println(e.getStatnNm()+" "+e.getSubwayId()+" "+e.getSubwayNm());
		}
		
		sc.close();
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
	
	@JsonIgnoreProperties(ignoreUnknown = true)
	class Station {
		
		public List<Info> stationList;

		public List<Info> getStationList() {
			return stationList;
		}

		public void setStationList(List<Info> stationList) {
			this.stationList = stationList;
		}

		
		
	}
	


	@JsonIgnoreProperties(ignoreUnknown = true)
	class Info {
		private String statnNm;
		private String subwayId;
		private String subwayNm;
		
		
		
		
		
		public Info() {
			super();
		}
		
		
		public Info(String statnNm, String subwayId, String subwayNm) {
			super();
			this.statnNm = statnNm;
			this.subwayId = subwayId;
			this.subwayNm = subwayNm;
		}


		public String getStatnNm() {
			return statnNm;
		}
		public void setStatnNm(String statnNm) {
			this.statnNm = statnNm;
		}
		public String getSubwayId() {
			return subwayId;
		}
		public void setSubwayId(String subwayId) {
			this.subwayId = subwayId;
		}
		public String getSubwayNm() {
			return subwayNm;
		}
		public void setSubwayNm(String subwayNm) {
			this.subwayNm = subwayNm;
		}

		
	}
