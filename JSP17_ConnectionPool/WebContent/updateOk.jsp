<%-- updateOk.jsp: 수정내용을 DBMS에 업데이트하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/> <%-- DAO bean 생성 --%>

<%	// parameter 받아오기
	request.setCharacterEncoding("utf-8"); // 한글 인코딩 꼭!(post 방식)
	// 'update.jsp'의 수정값을 받아옴.
	int uid = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	// * 이 단계에서 parameter 검증 필요
	
%>
<% // DAO 사용한 트랜젝션
	int cnt = dao.update(uid, subject, content);

%>
 
<% if(cnt == 0){ %> <%-- 반영된 행이 없다면 --%>
		<script>
			alert("수정 실패");
			history.back();
		</script>	
<% } else{ %>
		<script>
			alert("수정 성공");
			location.href= "view.jsp?uid=<%=uid%>";
		</script>
<% } %>






















