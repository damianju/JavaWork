<%-- update.jsp: 수정화면을 구성하고 수정내용을 request하는 소스코드 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*" %>




<%// DAO 사용한 트랜젝션

WriteDTO[] arr = (WriteDTO [])request.getAttribute("update");
%>


<%
	if(arr == null || arr.length ==0){
		
%>
 
		<script>
			alert("해당 정보가 삭제되거나 없습니다");
			history.back();
		</script>

<%
	return; // 더이상 JSP 프로세싱 하지 않고 종료
	}// end if
	
%>
<%
	int uid =  arr[0].getUid();
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regDate = arr[0].getRegDate();
	int viewCnt = arr[0].getViewCnt();

%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정화면 <%= subject %></title>
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
<input type="hidden" name="uid" value="<%= uid %>"/> <!-- parameter 넘길 때 자주 사용 -->
작성자: <%= name %><br> <%-- 작성자 이름 변경 불가 --%>
제목: 
<input type="text" name="subject" value="<%= subject %>"/><br>
내용: <br>
<textarea name="content"><%= content %></textarea>
<br>
<input type="submit" value="수정"/>

</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href='list.do'">목록보기</button>

</body>
</html>