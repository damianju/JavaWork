<%-- updateOk.jsp: 수정내용을 DBMS에 업데이트하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
	<c:when test="${updateOk == 0 }">
	
		<script>
			alert("수정 실패");
			history.back();
		</script>	
		
	</c:when>
	
	<c:otherwise>
	
		<script>
			alert("수정 성공");
			location.href = "view.do?uid=${param.uid}";
		</script>
	
	</c:otherwise>
</c:choose>

 


















