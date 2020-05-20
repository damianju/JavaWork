<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Session List</title>
</head>
<body>
<%
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 세션이 있음<hr>");
	} else {
		out.println("유효한 세션이 없음<hr>");
	}

	String sessionName, sessionValue;
	// 현재 세션의 모든 name들 가져오기
	Enumeration<String> enumeration = session.getAttributeNames(); // Enumeration<String> 리턴
	
	int i = 0;
	while(enumeration.hasMoreElements()){
		
		sessionName = enumeration.nextElement();
		// session.getAttribute(sessionName) <-- 특정 name의 세션값 추출, name 없으면 null 리턴
		sessionValue = session.getAttribute(sessionName).toString();
		out.println((i+1)+"]" + sessionName +":"+ sessionValue + "<br>");
		
		i++;
	} // end while
		
	if (i ==0){
		out.println("세션이 없습니다<br>");
	}

%>

<hr>
<form action="sessionCreate.jsp">
	<input type ="submit" value="세션생성">
	
</form>

<br>

<form action="sessionDelete.jsp">
	<input type ="submit" value="세션삭제">
	
</form>

<hr>

<% 
	String sessionId = session.getId();
	int sessionInterval = session.getMaxInactiveInterval(); //1800초 (30분) 서버에 설정된 값 Servers/web.xml --> session-timeout
	
	out.println("세션ID: "+sessionId + "<br>");
	out.println("세션 유효시간: " + sessionInterval + "<br>");
%>

<% 
	out.println("---session.invalidate() 후 -- <br>");
	// 세션 무효화 invlidate
	// 세션테이블 삭제(session id 무효화)
	// 	- 그 안의 모든 attribute(이름)도 삭제됨.
	// 새로운 세션테이블 생성
	
	// session.invalidate(); // 세션 무효화
	
	sessionId = session.getId();
	sessionInterval = session.getMaxInactiveInterval();
	
	out.println("세션ID: "+sessionId + "<br>");
	out.println("세션 유효시간: " + sessionInterval + "<br>");
	
	
	
%>

</body>
</html>