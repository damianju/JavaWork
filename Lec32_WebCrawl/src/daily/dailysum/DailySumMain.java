package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

// 2020-04-04  13:30 최종수정 완료


public class DailySumMain {
	public static final String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";
	public static final String API_KEY = "554272615264616d3132394273656947";
	
	public static void main(String[] args) throws IOException {
		System.out.println("자치구단위 서울 생활인구 일별 집계표");
		
		System.out.println("[XML]");
		System.out.println("날짜                               구ID        총생활인구수           일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		String url1 = buildUrlAddress("xml",1,5,"20190101");
		
		Document doc = Jsoup.connect(url1).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
		// System.out.println(elements.size()); // 확인용: 5개
		
		for(Element e: elements) {
			String STDR_DE_ID = e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE = e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO = e.selectFirst("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_MVMN_LVPOP_CO =e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			
			System.out.printf("%s\t%s\t%s\t%s\t\n", STDR_DE_ID, SIGNGU_CODE_SE, TOT_LVPOP_CO, DAIL_MXMM_MVMN_LVPOP_CO);
		} // end for
		
		System.out.println();
		
		System.out.println("[JSON]");
		System.out.println("날짜                               구ID        총생활인구수           일최대이동인구수");
		System.out.println("----------------------------------------------------------------------");
		
		ObjectMapper mapper = new ObjectMapper();
		URL url2 = new URL(buildUrlAddress("json", 1, 5, "20190101"));
		
		Info info = mapper.readValue(url2, Info.class);
		// System.out.println(info.getDailySum().getListCount()); // 확인용: 26
		
		for(Population e: info.getDailySum().getRow()) {
			System.out.printf("%s\t%s\t%s\t%s\t\n", e.getDate(), e.getCityCode(), e.getTotalPop(), e.getMaxMove());
		} // end for
		
		
		System.out.println("\n프로그램 종료");
	} // end main
	
	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {
		
		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/%s/%d/%d/%s", 
				API_KEY, reqType, REQ_SERVICE, startIndex, endIndex, date);
		
		return url_address;
	} // end buildUrlAddress()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Info{
	@JsonProperty("SPOP_DAILYSUM_JACHI")
	private DailySum dailySum;

	public DailySum getDailySum() {
		return dailySum;
	}

	public void setDailySum(DailySum dailySum) {
		this.dailySum = dailySum;
	}

} // end Info

@JsonIgnoreProperties(ignoreUnknown = true)
class DailySum {
	
	@JsonProperty("list_total_count")
	private int listCount;

	private List<Population> row;

	public int getListCount() {
		return listCount;
	}
	
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public List<Population> getRow() {
		return row;
	}

	public void setRow(List<Population> row) {
		this.row = row;
	}
	
} // end DailySum

@JsonIgnoreProperties(ignoreUnknown = true)
class Population {
	
	@JsonProperty("STDR_DE_ID")
	private String date;
	@JsonProperty("SIGNGU_CODE_SE")
	private String cityCode;
	@JsonProperty("TOT_LVPOP_CO")
	private String totalPop;
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String MaxMove;
	
	public Population() {
		super();
	}
	public Population(String date, String cityCode, String totalPop, String maxMove) {
		super();
		this.date = date;
		this.cityCode = cityCode;
		this.totalPop = totalPop;
		MaxMove = maxMove;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getTotalPop() {
		return totalPop;
	}
	public void setTotalPop(String totalPop) {
		this.totalPop = totalPop;
	}
	public String getMaxMove() {
		return MaxMove;
	}
	public void setMaxMove(String maxMove) {
		MaxMove = maxMove;
	}
	
} // end Population
