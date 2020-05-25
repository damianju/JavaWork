<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO" scope="page"/>
<jsp:setProperty name="dto" property="uid" value="123"/>
<jsp:setProperty name="dto" property="subject" value="제목입니다"/>
<jsp:setProperty name="dto" property="name" value="작성자입니다"/>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EL - ActionTag</title>
</head>
<body>
	<%-- jsp 방식 --%>
	uid : <%= dto.getUid() %><br>
	제목 : <%= dto.getSubject() %><br>
	이름 : <%= dto.getName() %><br>
	<hr>
	
	<%-- jsp bean 방식 --%>
	uid :<jsp:getProperty name="dto" property="uid"/><br>
	제목 : <jsp:getProperty name="dto" property="subject"/><br>
	이름 : <jsp:getProperty name="dto" property="name"/><br>
	<hr>
	
	<%-- EL 방식: property 직접 접근 가능 --%>
	uid : ${dto.uid }<br>
	제목 : ${dto.subject }<br>
	이름 : ${dto.name }<br>
	<%-- 댓글 : ${ddd.comment }<br>--%> <%-- 에러 안 남: "댓글 :" --%>
	<hr>
	
</body>
</html>