<%@page import="java.util.Arrays"%>
<%@page import="java.lang.reflect.Array"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>request parameter</title>
</head>
<body>
<%!
	String data1, data2;
	String name, id, pw, gender, local, memo;
	String[] hobbys;
	
%>
<%
	request.setCharacterEncoding("utf-8");

	data1 = request.getParameter("data1").trim();
	data1 = request.getParameter("data2").trim();
	name = request.getParameter("name").trim();
	id = request.getParameter("id").trim();
	pw = request.getParameter("pw").trim();
	gender = request.getParameter("gender").trim();
	local = request.getParameter("local").trim();
	memo = request.getParameter("memo").trim();
	hobbys = request.getParameterValues("hobby");
	
%>

hidden: <%= data1 %>, <%= data2 %> <br>
name: <%= name %> <br>
id: <%= id %> <br>
pw: <%= pw %> <br>
gender: <%= gender %> <br>
hobby: <%= Arrays.toString(hobbys) %><br>
local: <%= local %> <br>
memo: <%= memo %> <br>

</body>
</html>