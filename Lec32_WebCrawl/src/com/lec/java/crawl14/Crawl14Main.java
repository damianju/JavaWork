package com.lec.java.crawl14;
/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/554272615264616d3132394273656947/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/554272615264616d3132394273656947/json/CardSubwayStatsNew/1/5/20181001 
 * */

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Crawl14Main {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("jackson-databind 연습 : URL -> json -> Java");
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/554272615264616d3132394273656947/json/CardSubwayStatsNew/1/5/20181001");
		
		Subways subways = mapper.readValue(url, Subways.class);
		
		System.out.println(subways.getCardSubwayStatsNew().getListCount());
		
		for(Info e: subways.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
					e.getLineNum(), 
					e.getStaName(), 
					e.getRideNum(), 
					e.getAlightNum());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Subways {
	private CardSubwayStatsNew CardSubwayStatsNew; // 왜 이것만 public ???

	public CardSubwayStatsNew getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(CardSubwayStatsNew cardSubwayStatsNew) {
		CardSubwayStatsNew = cardSubwayStatsNew;
	}
	
} // end class


@JsonIgnoreProperties(ignoreUnknown = true)
class CardSubwayStatsNew {
	@JsonProperty("list_total_count")
	private int listCount;
	
	private List<Info> row;

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public List<Info> getRow() {
		return row;
	}

	public void setRow(List<Info> row) {
		this.row = row;
	}
	
} // end class

//JSON 필드명과 매핑되는 Java 객체의 변수명을 달리하고 싶다면
@JsonIgnoreProperties(ignoreUnknown = true)
class Info {
// @JsonProperty 사용
	@JsonProperty("LINE_NUM") // JSON의 LINE_NUM ==> lineNum 으로 매핑
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")
	private String staName;
	
	@JsonProperty("RIDE_PASGR_NUM")
	private int rideNum;
	
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightNum;

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	public int getRideNum() {
		return rideNum;
	}

	public void setRideNum(int rideNum) {
		this.rideNum = rideNum;
	}

	public int getAlightNum() {
		return alightNum;
	}

	public void setAlightNum(int alightNum) {
		this.alightNum = alightNum;
	}
	
} // end class
