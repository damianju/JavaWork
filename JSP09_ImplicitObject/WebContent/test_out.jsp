<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>out</title>
</head>
<body>
<%-- 
<%
	int i = 0;
	while(true){
		i++;
		
		out.println("5 * " + i + "=" + 5 * i + "<br>");
%>
	------------ <br>
<%
		if(i >= 9) break;
	}

%>
--%>

<%! //<-- 선언문 태크: 변수 선언, 메소드 정의
	int i =100;
	String str = "test";
	
	public int hap(int a, int b){
		return a+b;
	}
%>

<% // 스크립트
	out.println("i =" +i + "<br>");
	out.println("str ="+str+ "<br>");
	out.println("hap ="+hap(2,10)+ "<br>");
	
%>

<hr>
<%-- 익스프레션 식으로 작성 --%>
i = <%= i %> <br>
str = <%= str %><br>
hap = <%= hap(2,10) %><br>
</body>
</html>