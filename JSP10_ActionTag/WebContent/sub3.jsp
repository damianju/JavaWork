<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*"%>

<%
	
	String name = URLDecoder.decode(request.getParameter("name"), "utf-8");
	String age = request.getParameter("age");
%>
name: <%= name %> <br>
age: <%= age %> <br>
