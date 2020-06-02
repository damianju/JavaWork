<%-- update.jsp: 수정화면을 구성하고 수정내용을 request하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:choose>
	<c:when test="${empty update || fn:length(update) ==0 }">
	
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>
	
	</c:when>
	<c:otherwise>




<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정화면 ${update[0].subject }</title>
<script src="ckeditor/ckeditor.js"></script>
</head>
<script>
function chkSubmit(){
	frm=document.forms['frm']; // 변수 정의: 현재 문서(document)의 'frm'이라는 form을 frm으로 정의
	var subject= frm['subject'].value.trim();
	
	if(subject==""){ // 프런트엔드 변수 검즘 (제목은 필수), required로도 처리 가능
		alert("제목은 반드시 작성해야 합니다");
		frm['subject'].focus(); // cursor 포커스 옮겨주기
		return false; // submit 실패
	}
	return true; // submit 성공
}

</script>
<body>
<h2>수정</h2>
<form name="frm" action="updateOk.do" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="${update[0].uid }"/> <!-- parameter 넘길 때 자주 사용 -->
작성자: ${update[0].name }<br> <%-- 작성자 이름 변경 불가 --%>
제목: 
<input type="text" name="subject" value="${update[0].subject }"/><br>
내용: <br>
<textarea name="content" id = "editor1">${update[0].content }</textarea>
<script>
	CKEDITOR.replace('editor1', {
		allowedContent:true,
		filebrowserUploadUrl: '${pageContext.request.contextPath}/fileUpload.do'
	});
</script>
<br>
<input type="submit" value="수정"/>

</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.do'">목록보기</button>

</body>
</html>

</c:otherwise>
</c:choose>
