<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>login</title>
</head>
<body>

<%!
	int i = 0;
%> 

<%
	String sessionName = "userid";   // 로그인 성공하면 발급되는 쿠키 이름.
	// session.getAttribute(sessionName) <-- 특정 name의 세션값 추출, name 없으면 null 리턴
	
if(session.getAttribute(sessionName) == null){ %>
		<h2>로그인 상태가 아닙니다</h2>
		<form action="loginOk.jsp">
			id:<input type="text" name="userid"><br>
			pw:<input type="password" name="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
<% } else { %>
		<h2>로그인 상태입니다</h2>
		<form action="logout.jsp">
			<input type="submit" value="로그아웃"><br>
		</form>
<% } %>

</body>
</html>