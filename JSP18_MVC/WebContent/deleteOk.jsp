<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<% // 
	int cnt = (Integer)request.getAttribute("delete");
	// getAttribute("class_name"): class_name에 맞는 값을 리턴, 없으면 null 리턴  
%>

<% if(cnt == 0){ %>
		<script>
			alert("삭제 실패");
			history.back();
		</script>	
<% } else{ %>
		<script>
			alert("삭제 성공");
			location.href= "list.do"; <%-- 삭제 후 리스트로 넘어가기--%>
		</script>
<% } %>






















