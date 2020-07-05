<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	// Controller 로부터 결과데이터 받음.
	//int cnt = dao.insert(subject, content, name);
	int cnt = (Integer)request.getAttribute("result");

%>
<% if(cnt == 0){ %>
	<script>
		alert("등록실패");
		history.back(); // 브라우저가 기억하는 직전 페이지 
	</script>
<% } else { %>
	<script>
		alert("등록 성공, 리스트를 출력합니다");
		location.href = "list.do";
	</script>
<% } %>


















