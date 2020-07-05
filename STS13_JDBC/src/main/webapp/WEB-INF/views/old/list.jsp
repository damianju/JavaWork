<%--contentType="charset=UTF-8": (결과) 웹 브라우저가 받아볼 페이지의 인코딩 방식 --%>
<%--pageEncoding="UTF-8": (작업) JSP파일(페이지)에 기록된 소스코드 자체의 인코딩 방식 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="old.*" %>    
  


<% // Controller 부터 결과데이터 받음.
	// getAttribute()
		// 매개변수: attributed의 이름
		// 리턴값: 해당 이름을 가진 attribute(매개변수)의 값(Object) 
	WriteDTO [] arr = (WriteDTO [])request.getAttribute("list");
%>

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
<%
	if(arr != null){
		for(int i = 0; i < arr.length; i++){
%>
			<tr>
				<td><%= arr[i].getUid() %></td>
				<td><a href="view.do?uid=<%= arr[i].getUid()%>"><%= arr[i].getSubject() %></a></td>
				<td><%= arr[i].getName() %></td>
				<td><%= arr[i].getViewCnt() %></td>
				<td><%= arr[i].getRegDate() %></td>
			</tr>
<%			
		} // end for
	} // end if
%>
		</table>
		<br>
		<button onclick="location.href='write.do'">신규등록</button>



</body>
</html>















