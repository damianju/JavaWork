<%--contentType="charset=UTF-8": (결과) 웹 브라우저가 받아볼 페이지의 인코딩 방식 --%>
<%--pageEncoding="UTF-8": (작업) JSP파일(페이지)에 기록된 소스코드 자체의 인코딩 방식 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%-- JSTL 버전으로 바뀌니, import 번잡함도 사라진다. JAVA 변수 선언도 사라진다 --%>



<!DOCTYPE html>
<html lang="ko">
<!-- head: 현재 문서의 정보를 제공하는 역할 -->
<head>
<!-- Meta Data: 다른 데이터를 설명해주는 데이터, charset: Character set(구성문자 집합, 문자셋)-->
<meta charset="UTF-8">
<!-- width=device-width: 브라우저(페이지) 너비를 장치(기기) 너비와 동일하게 설정 -->
<!-- initial-scale=1.0(100%): 뷰포트의 초기 배율 (로딩시 확대/축소 없는 원래 크기, 범위: 0~10)-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table {width: 100%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

		<hr>
		<h2>리스트</h2>
		<table>
			<tr>
				<th>UID</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
			
		<c:choose>
			<c:when test="${empty list || fn:length(list) == 0}">
			</c:when>
			<c:otherwise>
			
			<c:forEach var="dto" items="${list }">
			
			<tr>
				<td>${dto.uid }</td>
				<td><a href="view.do?uid=${dto.uid }">${dto.subject }</a></td>
				<td>${dto.name }</td>
				<td>${dto.viewCnt }</td>
				<td>${dto.regDate }</td>
			</tr>

			</c:forEach>
			
			</c:otherwise>
		</c:choose>

		</table>
		<br>
		<button onclick="location.href='write.do'">신규등록</button>



</body>
</html>















