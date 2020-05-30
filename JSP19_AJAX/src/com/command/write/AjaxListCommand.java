package com.command.write;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lec.beans.AjaxWriteListJson;
import com.lec.beans.AjaxWriteListJsonXML;
import com.lec.beans.WriteDTO;

public class AjaxListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// parameter 받아오기, 없으면 json 동작 디폴트로
		String reqType = request.getParameter("reqType");
		if(reqType == null) reqType = "json";
		
		// "xml" 혹은 "json" 으로 response 하기
		switch(reqType) {
			case "xml": 
				//responseXML(request, response); // jdom 사용
				responseXML2(request, response); // Jackson 사용
				break;
			default: // 이상한 파라미터에 대한 디폴트
				//responseJSON(request, response); // org.json 사용
				responseJSON2(request, response); // Jackson 사용
				
		} // end switch
	} // end execute()
	
	private void responseJSON(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr = (WriteDTO [])request.getAttribute("list");
		
		JSONObject jsonOutput = new JSONObject();  // 최종결과는 object
		
		if(dtoArr == null) {
			jsonOutput.put("status", "FAIL");
		} else {
			jsonOutput.put("status", "OK");
			int count = dtoArr.length;
			jsonOutput.put("count", count);
			
			// 글 목록 저장
			JSONArray dataArr = new JSONArray(); // array
			
			// TODO
			
			jsonOutput.put("data", dataArr);
			
			for(int i = 0; i<count; i++) {
				JSONObject dataObj = new JSONObject();
				
				dataObj.put("uid", dtoArr[i].getUid());
				dataObj.put("name", dtoArr[i].getName());
				dataObj.put("subject", dtoArr[i].getSubject());
				dataObj.put("content", dtoArr[i].getContent());
				dataObj.put("viewcnt", dtoArr[i].getViewCnt());
				dataObj.put("regdate", dtoArr[i].getRegDate());
				
				// array에 추가
				dataArr.put(dataObj);
				
			}
			
		}
		
		String jsonString= jsonOutput.toString(); // JSON ==> String 변환
		
		response.setContentType("application/json; charset=utf-8"); // MIME 설정
		
		try {
			response.getWriter().write(jsonString); // response 내보내기
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end reposneJSON

	private void responseJSON2(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr = (WriteDTO []) request.getAttribute("list");
		
		AjaxWriteListJson list = new AjaxWriteListJson();// response 할 JAVA 객체
		
		if(dtoArr == null) {
			list.setStatus("FAIL");
		} else {
			list.setStatus("OK");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));
		}
		
		
		
		
		
		
		
		ObjectMapper mapper = new ObjectMapper();// JSON을 매핑할 Mapper 객체
		
		try {
			// Java 객체 -> JSON 문자열로 변환
			String jsonString = mapper.writeValueAsString(list);
			
			response.setContentType("application/json; charset=utf-8"); // MIME 설정 
			response.getWriter().write(jsonString); // response 보내기
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // end responseJSON2
	
	private void responseXML(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO[] dtoArr = (WriteDTO []) request.getAttribute("list");
		
		Document dom = new Document();
		
		Element rootElement = new Element("WriteList"); // <WriteList> ... </WriteList>
		
		dom.setRootElement(rootElement);
		
		
		Element statusElement = new Element("status");
		if(dtoArr == null) {
			statusElement.setText("FAIL");
		} else {
			statusElement.setText("OK");
			
			// 데이터 개수
			int count = dtoArr.length;
			Element countElement = new Element("Count")
					.setText(""+count)
					.setAttribute("id", "ccc")
					.setAttribute("pw","xxx")
					;
			rootElement.addContent(countElement);
			
			for(int i = 0; i < count; i++) {
				Element dataElement = new Element("Data");
				
				dataElement.addContent(new Element("uid").setText(dtoArr[i].getUid()+""));
				dataElement.addContent(new Element("name").setText(dtoArr[i].getName()+""));
				dataElement.addContent(new Element("subject").setText(dtoArr[i].getSubject()+""));
				dataElement.addContent(new Element("content").setText(dtoArr[i].getContent()+""));
				dataElement.addContent(new Element("viewcnt").setText(dtoArr[i].getViewCnt()+""));
				dataElement.addContent(new Element("regdate").setText(dtoArr[i].getRegDate()+""));
				
				
				rootElement.addContent(dataElement);
			}
			
		}
		rootElement.addContent(statusElement);
		
		XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
		System.out.println(xmlOutputter.outputString(dom)); //테스트용
		
		try {
			response.setContentType("application/xml; charset=utf-8"); // text/xml 도 가능
			
			response.getWriter().write(xmlOutputter.outputString(dom));// dom 객체를 문자열로 만들어 response함
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end reposneXML

	private void responseXML2(HttpServletRequest request, HttpServletResponse response) {
		WriteDTO [] dtoArr = (WriteDTO []) request.getAttribute("list");
		
		AjaxWriteListJsonXML list = new AjaxWriteListJsonXML(); // response 할 Java 객체
		
		if(dtoArr == null) {
			list.setStatus("FAIL");
		} else {
			list.setStatus("OK");
			list.setCount(dtoArr.length);
			list.setList(Arrays.asList(dtoArr));
			
		} // end if
		
		
		
		
		XmlMapper mapper = new XmlMapper(); // XML 매핑할 Mapper 객체
		
		try {
			// Java => XML 문자열 변환
			String xmlString = mapper.writeValueAsString(list);
			
			response.setContentType("application/xml; charset=utf-8");
			response.getWriter().write(xmlString); // response 내보내기
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
