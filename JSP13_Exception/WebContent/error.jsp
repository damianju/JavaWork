<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>에러 안내</title>
</head>
<body>
에러 발생 <br>
exception type: <%= exception.getClass().getName() %> <br>
exception message: <%= exception.getMessage() %>

</body>
</html>