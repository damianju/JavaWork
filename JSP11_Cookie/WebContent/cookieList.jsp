<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>cookie list</title>
</head>
<body>

<%
	// 사용자 컴퓨터 안의 쿠키 정보는 requst 시에 서버로 전달된다.
	// request.getCookies()로 쿠키 받아온다
	Cookie[] cookies = request.getCookies(); // Cookie[] 배열 리턴
	
	if(cookies != null){ // 만약 쿠키가 하나도 없다면 null
		for(int i = 0; i <cookies.length; i++){
			String cookieName = cookies[i].getName(); // 쿠키 '이름'
			String cookieValue = cookies[i].getValue(); // 쿠키 '값'
			out.println((i+1)+"] "+cookieName + ":"+cookieValue + "<br>");
			// 1] JSESSIONID:7B515965E56E5BB0527CC8FC74948E1E TomCat 기본 발행 cookie
		}
	} else {
		out.println("쿠키가 없습니다 <br>");
	} // end if

%>

<hr>
<form action="cookieCreate.jsp" method="get">
	<input type="submit" value="cookie생성 &갱신">
</form>
<br>
<form action="cookieDelete.jsp" method="get">
	<input type="submit" value="cookie삭제">
</form>
</body>
</html>