<%-- updateOk.jsp: 수정내용을 DBMS에 업데이트하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% 
	int uid = (Integer)request.getAttribute("update_uid");
	int cnt = (Integer)request.getAttribute("updateOk");

%>
 
<% if(cnt == 0){ %> <%-- 반영된 행이 없다면 --%>
		<script>
			alert("수정 실패");
			history.back();
		</script>	
<% } else{ %>
		<script>
			alert("수정 성공");
			location.href= "view.do?uid=<%=uid%>";
		</script>
<% } %>






















